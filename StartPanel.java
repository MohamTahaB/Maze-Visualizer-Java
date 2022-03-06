import javax.swing.*;

public class StartPanel extends JPanel {
    private StartButton startButton ;
    private MazeApp mazeApp ;

    public StartPanel(MazeApp mazeApp, StartButton startButton) {
        this.mazeApp = mazeApp ;
        this.startButton = startButton ;
        add(startButton) ;
    }
}
