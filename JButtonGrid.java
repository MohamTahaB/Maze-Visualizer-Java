import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonGrid implements ActionListener {
    private final Maze maze ;
    private final MazeApp mazeApp ;
    private final JButton[][] grid ;

    public JButtonGrid(Maze maze, MazeApp mazeApp) {
        this.mazeApp = mazeApp ;
        this.maze = maze ;
        grid = new JButton[maze.getTaille()][maze.getTaille()] ;
        for (int i = 0 ; i < maze.getTaille() ; i++) {
            for (int j = 0 ; j < maze.getTaille() ; j ++) {
                if (maze.getCase(i , j).isItAWall()) {
                    grid[i][j] = new JButton("X") ;
                    grid[i][j].setBackground(Color.BLACK);
                    grid[i][j].setOpaque(true);
                }
                else if (maze.getXStart() == i && maze.getYStart() == j) {
                    grid[i][j] = new JButton("Start") ;
                    grid[i][j].setBackground(Color.GREEN);
                    grid[i][j].setOpaque(true);
                }
                else if (maze.getXFinish() == i && maze.getYFinish() == j) {
                    grid[i][j] = new JButton("Finish") ;
                    grid[i][j].setBackground(Color.GREEN);
                    grid[i][j].setOpaque(true);
                }
                else {
                    grid[i][j] = new JButton() ;
                }
                grid[i][j].addActionListener(this);
            }
        }
    }

    public JButton[][] getGrid() {
        return grid;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0 ; i < maze.getTaille() ; i++) {
            for (int j = 0; j < maze.getTaille(); j++) {
                if (!maze.getCase(i , j).isItAWall() && !(i == maze.getXStart() && j == maze.getYStart()) && !(i == maze.getXFinish() && j == maze.getYFinish())) {
                    grid[i][j].setBackground(Color.WHITE);
                    grid[i][j].setOpaque(false);
                }
            }
        }


        for (int i = 0 ; i < maze.getTaille() ; i++) {
            for (int j = 0; j < maze.getTaille(); j++) {
                if (e.getSource() == grid[i][j]) {
                    if (grid[i][j].getBackground() == Color.BLACK) {
                        grid[i][j].setBackground(Color.WHITE);
                        grid[i][j].setText("");
                        maze.getCase(i , j).setItAWall(false);
                        grid[i][j].setOpaque(true);
                    }
                    else {
                        grid[i][j].setBackground(Color.BLACK);
                        grid[i][j].setText("X");
                        maze.getCase(i , j).setItAWall(true);
                        grid[i][j].setOpaque(true);
                    }
                }
            }
        }
    }
}
