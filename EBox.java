public class EBox extends MBox{
    private final Maze maze ;

    public EBox(int x , int y , Maze maze) {
        super(x , y , false);
        this.maze = maze ;
    }
}
