package tracker;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Transition {
    private final Status from;
    private final Status to;

    private static final Set<Transition> transitions = new HashSet<>();

    static {
        transitions.add(new Transition(Status.OPEN, Status.ANALYSIS));
        transitions.add(new Transition(Status.ANALYSIS, Status.FIX));
        transitions.add(new Transition(Status.ANALYSIS, Status.REJECT));
        transitions.add(new Transition(Status.REJECT, Status.CLOSE));
        transitions.add(new Transition(Status.FIX, Status.TEST));
        transitions.add(new Transition(Status.TEST, Status.CLOSE));
    }

    private Transition(Status from, Status to) {
        this.from = from;
        this.to = to;
    }


    public static boolean isAvailable(Status from, Status to) {
        Transition transition = new Transition(from, to);
        return transitions.contains(transition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Transition tr = (Transition) obj;
        return from.equals(tr.from) &&
                to.equals(tr.to);
    }

}
