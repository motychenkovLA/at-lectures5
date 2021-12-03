package tracker;


import java.util.HashSet;
import java.util.Set;

public class Transition {
    // todo 3 - public но при этом с get/set ?
    // todo 1 - final
    public   Status from;
    public   Status to;

    public Transition(Status from, Status to) {
        this.from = from;
        this.to = to;
    }
    // todo 1 - зачем?
    public Transition(Status from) {
        this.from = from;
    }

    public Status getFrom() {
        return from;
    }

    public void setFrom(Status from) {
        this.from = from;
    }

    public Status getTo() {
        return to;
    }

    public void setTo(Status to) {
        this.to = to;
    }


    //    public final static Map<Status, Status[]> statusMap = new HashMap<>();
//
//    private static void putMap(){
//        statusMap.put(Status.OPEN, new Status[]{Status.IN_TESTING, Status.CLOSE});
//    }


}
