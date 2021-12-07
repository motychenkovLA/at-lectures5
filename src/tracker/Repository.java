package tracker;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Repository {

    private final Map<Long, Defect> bugsMap = new HashMap();

    public Repository() {
    }

    public void addBug(Defect bug) {
        bugsMap.put(bug.getId(), bug);
    }

    public Collection<Defect> getAll() {
        // todo 1 - особо смысла нет возвращать именно массив вместо Collection
        return bugsMap.values();
    }

    public boolean isEmpty() {
        return bugsMap.isEmpty();
    }

    // todo 0 - параметр называется index но это id
    public Defect getElementById(long id) {
        return bugsMap.get(id);
    }
}