package tracker;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Repository {

    // todo 3 - справа создается HashMap без параметризации типов
    private final Map<Long, Defect> bugsMap = new HashMap();

    public Repository() {
    }

    public void addBug(Defect bug) {
        bugsMap.put(bug.getId(), bug);
    }

    public Collection<Defect> getAll() {
        return bugsMap.values();
    }

    public boolean isEmpty() {
        return bugsMap.isEmpty();
    }

    public Defect getElementById(long id) {
        return bugsMap.get(id);
    }
}