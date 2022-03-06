
public class Couple {
    private final int x ;
    private final int y ;

    public Couple(int x , int y) {
        this.x = x ;
        this.y = y ;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Couple couple = (Couple) o;
        return getX() == couple.getX() && getY() == couple.getY();
    }


}
