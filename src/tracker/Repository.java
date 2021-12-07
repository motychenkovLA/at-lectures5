package tracker;

import java.util.HashMap;
import java.util.Map;

public class Repository {

    private final Map<Long, Defect> bugsMap = new HashMap();

    public Repository() {
    }

    public void addBug(Defect bug) {
        bugsMap.put(bug.getId(), bug);
    }

    public Defect[] getAll() {
        // todo 1 - особо смысла нет возвращать именно массив вместо Collection
        return bugsMap.values().toArray(new Defect[0]);
    }

    public boolean isEmpty() {
        return bugsMap.isEmpty();
    }

    // todo 0 - параметр называется index но это id
    public Defect getElementById(long index) {
        return bugsMap.get(index);
    }
}