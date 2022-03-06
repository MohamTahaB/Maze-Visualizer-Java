public class ABox extends MBox{

    private final Maze maze ;

    public ABox(Maze maze) {
        super(maze.getXFinish(), maze.getYFinish(), false) ;
        this.maze = maze ;
    }
}
