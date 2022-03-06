public class DBox extends MBox {

    private final Maze maze ;

    public DBox(Maze maze) {
        super(maze.getXStart(), maze.getYStart(), false) ;
        this.maze = maze ;
    }
}
