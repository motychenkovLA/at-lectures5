package tracker;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Transition {
    private final Status from;
    private final Status to;

    private final Set<Transition> transitions = new HashSet<>();

    public Transition(Status from, Status to) {
        this.from = from;
        this.to = to;
    }

    public void setTransitions(){
        transitions.add(new Transition(Status.OPEN, Status.ANALYSIS));
        transitions.add(new Transition(Status.ANALYSIS, Status.FIX));
        transitions.add(new Transition(Status.ANALYSIS, Status.REJECT));
        transitions.add(new Transition(Status.REJECT, Status.CLOSE));
        transitions.add(new Transition(Status.FIX, Status.TEST));
        transitions.add(new Transition(Status.TEST, Status.CLOSE));
    }

    public boolean isChangeStatusAvailable(){
        return transitions.contains(this);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from,to);
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
