import java.util.*;

public class Pi {
    private HashMap<MBox , Integer> pi ;


    public Pi() {
        this.pi = new HashMap<MBox , Integer>() ;
    }

    public int show(MBox mBox) {
        return pi.get(mBox);
    }

    public void change(MBox mBox , int i) {
        pi.put(mBox , i) ;
    }


}
