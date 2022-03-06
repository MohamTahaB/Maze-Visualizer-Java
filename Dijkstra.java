import java.util.*;

public class Dijkstra {

    public static ArrayList dijkstra(Maze maze) {
        ArrayList<Couple> ans = new ArrayList<Couple>();
        ASet A = new ASet() ;
        Pi p = new Pi() ;
        Previous precedent = new Previous() ;


        MBox pivot = maze.getCase(maze.getXStart(), maze.getYStart()) ;

        A.add(pivot) ;

        p.change(pivot , 0);
        for (int i = 0 ; i < maze.getTaille() ; i++) {
            for (int j = 0 ; j < maze.getTaille() ; j++) {
                if (i != maze.getXStart() || j != maze.getYStart()) {
                    p.change(maze.getCase(i , j), 10000000 );
                }
            }
        }

        for (int q  = 1 ; q < maze.getTaille()* maze.getTaille() ; q++) {

            ArrayList<int[]> aux = new ArrayList<int[]>() ;
            if (pivot.getX() != maze.getTaille() - 1) {
                aux.add(new int[] {pivot.getX() + 1, pivot.getY()}) ;
            }
            if (pivot.getX() > 0) {
                aux.add(new int[] {pivot.getX() - 1, pivot.getY() }) ;
            }
            if (pivot.getY() != maze.getTaille() - 1) {
                aux.add(new int[] {pivot.getX() , pivot.getY() + 1}) ;
            }
            if (pivot.getY() > 0) {
                aux.add(new int[] {pivot.getX() , pivot.getY() - 1 }) ;
            }
            //tous les voisins sont trouves, reste a verifier qu'ils sont pas des murs et qu'ils sont pas dans A


            for (int[] s : aux) {

                if (!(maze.getCase(s[0] , s[1]).isItAWall()) && !(A.contains(maze.getCase(s[0] , s[1])))) {
                    if (p.show(pivot) + 1< p.show(maze.getCase(s[0] , s[1]))) {
                        p.change(maze.getCase(s[0] , s[1]) , p.show(pivot) + 1);
                        precedent.change(maze.getCase(s[0] , s[1]) , pivot);
                    }
                }
            }
            int minimum = 10000000 ;
            for (int i = 0 ; i < maze.getTaille() ; i++) {
                for (int j = 0 ; j < maze.getTaille() ; j++) {
                    if (!(maze.getCase(i , j).isItAWall()) && !(A.contains(maze.getCase(i , j))) && (p.show(maze.getCase(i , j)) < minimum )) {
                        minimum = p.show(maze.getCase(i , j)) ;
                        pivot = maze.getCase(i , j) ;
                    }
                }
            }
            A.add(pivot) ;
        }

        MBox atteint = precedent.show(maze.getCase(maze.getXFinish(), maze.getYFinish())) ;
        while (! atteint.equals(maze.getCase(maze.getXStart(), maze.getYStart()))) {
            ans.add(new Couple (atteint.getX() , atteint.getY())) ;
            System.out.print(atteint.getX()) ;
            System.out.print("   ") ;
            System.out.print(atteint.getY()) ;
            System.out.println(" ") ;
            atteint = precedent.show(atteint) ;
        }
    return ans ;
    }
}
