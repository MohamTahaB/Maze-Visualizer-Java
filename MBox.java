public  class MBox
implements  VertexInterface{


    private final int x ;
    private final int y ;
    private boolean isItAWall ;

    public MBox(int x, int y, boolean isItAWall) {
        this.x = x;
        this.y = y;
        this.isItAWall = isItAWall;
    }

    public boolean equals(MBox sommet) {
        return (this.getX() == sommet.getX() && this.getY() == sommet.getY() && this.isItAWall() == sommet.isItAWall());
    }

    public String getLabel() {
        return ("x = " + this.getX() + " ; y = " + this.getY());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isItAWall() {
        return isItAWall;
    }

    public void setItAWall(boolean itAWall) {
        isItAWall = itAWall;
    }


}
