

import javax.swing.* ;
import java.awt.*;
import java.util.ArrayList;

public class MazeApp  extends JFrame {
    private final Maze maze ;
    private  WindowsPanel windowsPanel;
    private final BarreDeMenu barreDeMenu ;
    private final JButtonGrid grid ;

    public MazeApp(String string, Maze maze) {
        super(string) ;
        this.maze = maze ;
        this.grid = new JButtonGrid(maze , this) ;
        this.barreDeMenu = new BarreDeMenu(this) ;
        setJMenuBar(barreDeMenu);
        MazeGrid mazeGrid = new MazeGrid(this) ;
        this.windowsPanel = new WindowsPanel(this , mazeGrid) ;
        setContentPane(windowsPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

    }

    public MazeApp(String string, Maze maze , ArrayList<Couple> liste) {
        super(string) ;
        this.maze = maze ;
        this.grid = new JButtonGrid(maze , this) ;
        this.barreDeMenu = new BarreDeMenu(this) ;
        setJMenuBar(barreDeMenu);
        MazeGrid mazeGrid = new MazeGrid(this , liste) ;
        this.windowsPanel = new WindowsPanel(this , mazeGrid) ;
        setContentPane(windowsPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

    }

    public Maze getMaze() {
        return maze;
    }

}
