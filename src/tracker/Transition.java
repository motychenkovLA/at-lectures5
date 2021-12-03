package tracker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Transition {

    private final Status from;
    private final Status to;

    public Transition(Status from, Status to) {
        this.from = from;
        this.to = to;
    }

    public Status getFrom() {
        return from;
    }

    public Status getTo() {
        return to;
    }

    public static final Set<Transition> transitions = new HashSet<>();

    static  {
        transitions.add(new Transition(Status.OPEN, Status.IN_TESTING));
        transitions.add(new Transition(Status.OPEN, Status.DOUBLE));
        transitions.add(new Transition(Status.IN_TESTING, Status.CLOSE));
        transitions.add(new Transition(Status.IN_TESTING, Status.RE_OPEN));
        transitions.add(new Transition(Status.IN_PROGRESS, Status.IN_TESTING));
        transitions.add(new Transition(Status.CLOSE, Status.RE_OPEN));
        transitions.add(new Transition(Status.DOUBLE, Status.RE_OPEN));
        transitions.add(new Transition(Status.IN_PROGRESS, Status.DOUBLE));
        transitions.add(new Transition(Status.RE_OPEN, Status.IN_PROGRESS));
    }

    public static List<Status> statusList(Status status) {
        List<Status> statusList = new ArrayList<>();
        for (Transition t : transitions
        ) {
            if (t.getFrom().equals(status)) {
                statusList.add(t.getTo());
            }
        }
        return statusList;
    }
}
