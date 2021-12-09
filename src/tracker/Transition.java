package tracker;

import java.util.HashSet;
import java.util.Set;

public class Transition {
    Set<String> stringSet = new HashSet<>();
    //stringSet.add("OPEN");
    public void setStringSet (String stat)
    {
        stringSet.add(stat);
    }

    public void initSet ()
    {
        stringSet.add("INPROGRESS");
    }

    public boolean checkSet (String stat)
    {
        return stringSet.contains(stat);
    }
}
