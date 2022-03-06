public class WBox extends MBox{
    private final Maze maze ;


    public WBox(int i , int j , Maze maze) {
        super(i , j , true) ;
        this.maze = maze ;
    }
}
