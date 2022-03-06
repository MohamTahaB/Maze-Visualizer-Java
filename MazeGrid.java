import javax.swing.* ;
import java.awt.* ;
import java.util.ArrayList;

public class MazeGrid extends JPanel {
    private final MazeApp mazeApp ;


    public MazeGrid(MazeApp mazeApp) {
        super() ;
        int aux = mazeApp.getMaze().getTaille() ;
        this.mazeApp = mazeApp ;
        setLayout(new GridLayout(aux , aux));
        JButtonGrid jButtonGrid = new JButtonGrid(mazeApp.getMaze() , mazeApp) ;
        JButton[][] table = jButtonGrid.getGrid() ;
        for (int i = 0 ; i < aux ; i++) {
            for (int j = 0 ; j < aux ; j++) {
                add(table[i][j]) ;
            }
        }
        setVisible(true);
    }


    public MazeGrid(MazeApp mazeApp , ArrayList<Couple> liste) {
        super() ;
        int aux = mazeApp.getMaze().getTaille() ;
        this.mazeApp = mazeApp ;
        setLayout(new GridLayout(aux , aux));
        JButtonGrid jButtonGrid = new JButtonGrid(mazeApp.getMaze() , mazeApp) ;
        JButton[][] table = jButtonGrid.getGrid() ;
        for (int i = 0 ; i < aux ; i++) {
            for (int j = 0 ; j < aux ; j++) {
                if (liste.contains(new Couple(i , j))) {
                    table[i][j].setBackground(Color.GREEN);
                    table[i][j].setOpaque(true);
                }
            }
        }
        for (int i = 0 ; i < aux ; i++) {
            for (int j = 0 ; j < aux ; j++) {
                add(table[i][j]) ;
            }
        }
        setVisible(true);
    }
}
