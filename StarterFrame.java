import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class StarterFrame  extends JFrame implements ActionListener {
    private String fileName ;
    private int taille ;

    JButton button ;
    public StarterFrame() {
        JPanel c = new JPanel() ;
        JLabel l = new JLabel("Welcome ! I would like you to check out first the documentation to know how the GUI works, it can be found in Git(Lab or Hub, github.com/MohamTahaB for the latter.\nEnjoy !!!") ;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button = new JButton("Select \'.txt\' file") ;
        setLayout(new BorderLayout());
        c.add(button, BorderLayout.SOUTH) ;
        c.add(l , BorderLayout.NORTH) ;
        button.addActionListener(this);
        setContentPane(c);
        pack() ;
        setVisible(true);

    }



    public void setTaille(int taille) {
        this.taille = taille;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getTaille() {
        return taille;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            JFileChooser fileChooser = new JFileChooser() ;
            int res = fileChooser.showOpenDialog(null) ;

            if (res == JFileChooser.APPROVE_OPTION) {
                setFileName(fileChooser.getSelectedFile().getAbsolutePath()) ;
                try {
                    setTaille((new BufferedReader(new FileReader(new File(getFileName())))).readLine().length()) ;
                } catch (IOException ex) {
                    ex.printStackTrace();
                } finally {
                    Maze maze = new Maze(this.getTaille() , 0 , 0 , 1 , 1 ) ;
                    System.out.println(this.getFileName()) ;
                    System.out.println(this.getTaille()) ;
                    maze.initFromTextFile(this.getFileName());
                    ArrayList<Couple> aux = Dijkstra.dijkstra(maze) ;
                    MazeApp app = new MazeApp("application" , maze) ;
                }
            }
        }

    }
}
