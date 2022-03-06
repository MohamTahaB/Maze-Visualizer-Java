import java.io.*;

public class Maze
implements GraphInterface {

    //on suppose dans un premier temps que la grille est tjrs carree et que sa taille est final

    private final int taille ;
    private final MBox[][] lab ;
    private int XStart ;
    private int YStart ;
    private int XFinish ;
    private int YFinish ;

    public boolean premierEstSuccesseurDuDeuxieme(MBox a , MBox b) {
        return (Math.abs(a.getX() - b.getX()) == 1 || Math.abs(a.getY() - b.getY()) == 1) && (!a.isItAWall()) && (!b.isItAWall()) ;
    }

    public boolean premierEstPereDuDeuxieme(MBox a , MBox b) {
        return premierEstSuccesseurDuDeuxieme(b , a) ;
    }

    public Maze(int taille , int XStart , int YStart , int XFinish , int YFinish) {
        this.taille = taille;
        this.XStart = XStart ;
        this.XFinish = XFinish ;
        this.YStart = YStart ;
        this.YFinish = YFinish ;
        this.lab = new MBox[taille][taille];
        for (int i = 0 ; i < taille ; i++) {
            for (int j = 0 ; j < taille ; j++) {
                lab[i][j] = new MBox(i , j , false) ;
            }
        }
    }

    public int getTaille() {
        return taille;
    }

    public int getXStart() {
        return XStart;
    }

    public int getYStart() {
        return YStart;
    }

    public int getXFinish() {
        return XFinish;
    }

    public int getYFinish() {
        return YFinish;
    }

    public void setXStart(int XStart) {
        this.XStart = XStart;
    }

    public void setYStart(int YStart) {
        this.YStart = YStart;
    }

    public void setXFinish(int XFinish) {
        this.XFinish = XFinish;
    }

    public void setYFinish(int YFinish) {
        this.YFinish = YFinish;
    }

    public MBox getCase(int i , int j) {
        return lab[i][j] ;
    }

    public void setLab(int i , int j , char c) {
        if (c == 'E') {
            this.lab[i][j] = new EBox(i , j , this);
        }
        else if (c == 'D') {
            setXStart(i);
            setYStart(j);
            this.lab[i][j] = new DBox(this);
        }
        else if (c == 'W') {
            this.lab[i][j] = new WBox(i , j , this) ;
        }
        else if (c == 'A') {
            setXFinish(i);
            setYFinish(j);
            this.lab[i][j] = new ABox(this) ;
        }

    }

    public final void initFromTextFile(String fileName) {
        File file = new File(fileName) ;

        test(file);
    }



    public void test(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine() ;
            int n = line.length() ;
            int i = 0 ;
            while (i < taille && line != null) {
                for (int j = 0 ; j < n ; j++) {
                    setLab(i , j , line.charAt(j));
                }
                System.out.println(line);
                line = br.readLine() ;
                i++ ;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final void saveToTextFile(String fileName) throws IOException {
        File file = new File(fileName) ;
        file.createNewFile() ;
        PrintWriter pw = new PrintWriter(file) ;
        for (int i = 0 ; i < taille ; i++) {
            for (int j = 0 ; j < taille ; j++) {
                if (i == getXStart() && j == getYStart()) {
                    pw.append('D') ;
                }
                else if (i == getXFinish() && j == getYFinish()) {
                    pw.write('A');
                }
                else if (getCase(i , j).isItAWall()) {
                    pw.write('W');
                }
                else {
                    pw.write('E');
                }
            }
            pw.println();
        }
        pw.flush();
        pw.close();
    }
}
