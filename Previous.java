import java.util.*;

public class Previous {
    private final HashMap<MBox , MBox> previous ;

    public Previous() {
        this.previous = new HashMap<MBox , MBox>() ;
    }

    public MBox show(MBox mBox) {
        return previous.get(mBox);
    }

    public void change(MBox mBoxKey , MBox mBoxValue) {
        previous.put(mBoxKey , mBoxValue) ;
    }


}
