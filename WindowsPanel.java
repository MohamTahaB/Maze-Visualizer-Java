import javax.swing.*;
import java.awt.*;

public class WindowsPanel extends JPanel  {
    private final MazeApp mazeApp ;
    private MazeGrid mazeGrid ;
    private StartPanel startPanel ;
    //other things to add

    public WindowsPanel(MazeApp mazeApp ,MazeGrid mazeGrid ) {
        super() ;
        this.mazeApp = mazeApp ;
        this.mazeGrid = mazeGrid ;
        startPanel = new StartPanel(mazeApp, new StartButton(mazeApp)) ;
        setLayout(new BorderLayout());
        add(mazeGrid , BorderLayout.CENTER) ;
        add(startPanel , BorderLayout.SOUTH) ;

    }


}
