package trackerV2;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Repository {
    private final Map<Long, Defect> bugsMap = new HashMap();
    public Repository() {

    }

    public void addBug(Defect defect) {
        bugsMap.put(defect.getId(), defect);
    }

    public Collection<Defect> getDefects() {
        return bugsMap.values();

    }



    public Defect getElementById(long id) {
        return bugsMap.get(id);
    }
}