import javax.swing.*;

public class FileMenu extends JMenu {
    private final SaveMenuItem saveMenuItem ;


    public FileMenu(MazeApp mazeApp) {
        super("File") ;
        add(saveMenuItem = new SaveMenuItem(mazeApp)) ;
    }


}
