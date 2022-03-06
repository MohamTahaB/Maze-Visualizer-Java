import javax.swing.*;

public class BarreDeMenu extends JMenuBar {
    private final FileMenu fileMenu ;

    public BarreDeMenu(MazeApp mazeApp) {
        super();
        add(fileMenu = new FileMenu(mazeApp)) ;
    }

}
