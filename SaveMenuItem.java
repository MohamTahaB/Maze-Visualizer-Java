import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SaveMenuItem extends JMenuItem implements ActionListener {
    private final MazeApp mazeApp ;

    public SaveMenuItem(MazeApp mazeApp) {
        super("Save") ;
        this.mazeApp = mazeApp ;
        this.addActionListener(this) ;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser() ;
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int res = fileChooser.showOpenDialog(null) ;
        if (res == JFileChooser.APPROVE_OPTION) {
            try {
                mazeApp.getMaze().saveToTextFile(fileChooser.getSelectedFile().getAbsolutePath()+ "/Backup.txt" );
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
