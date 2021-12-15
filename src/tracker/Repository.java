package tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {
    private final int capacity; // вместительность репо
    private final Map <Long, Defect> defects;
    private static long currentSize = 0L; // id

    public Repository(int capacity) {
        this.capacity = capacity;
        this.defects = new HashMap<>();
    }

    public void add(Defect defect) {
        defects.put(currentSize,defect);
        currentSize++;
    }

    public Map <Long, Defect> getAll() {

        return this.defects;
    }

    public boolean isFull() {
        return currentSize >= capacity;
    }

    public boolean isEmpty () {
        return defects.size() == 0;
    }

    public List <Defect> getDefectList () {
        return new ArrayList<>(defects.values());
    }

    public long getCurrentSize() {
        return currentSize;
    }

    public Defect getDefectById (long id) {
        Defect targetDefect = null;
        for (long i = 0; i < currentSize; i++) {
            if (defects.get(i).getId() == id) {
                targetDefect = defects.get(i);
                break;
            }

        }
        return targetDefect;
    }
}
