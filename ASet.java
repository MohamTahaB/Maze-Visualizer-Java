import  java.util.* ;

public class ASet  {
    private HashSet<MBox> A ;

    public ASet() {
        this.A = new HashSet<MBox>() ;
    }

    public boolean add(MBox mBox) {
        return A.add(mBox) ;
    }

    public boolean contains(MBox mBox) {
        return A.contains(mBox) ;
    }

}
