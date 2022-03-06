import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButton extends JButton{
    private final MazeApp mazeApp ;

    public StartButton(MazeApp mazeApp) {
        super("Start") ;
        this.mazeApp = mazeApp ;
        addActionListener(new Action(getMazeApp())) ;
    }

    public MazeApp getMazeApp() {
        return mazeApp;
    }

    static class Action implements ActionListener {
        private final MazeApp mazeApp;

        public Action(MazeApp mazeApp) {
            this.mazeApp = mazeApp ;
        }

        public void actionPerformed(ActionEvent e) {
            MazeApp mazeAppSolution = new MazeApp("test" , mazeApp.getMaze() , Dijkstra.dijkstra(mazeApp.getMaze())) ;
        }
    }

}
