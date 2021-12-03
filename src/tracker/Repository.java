package tracker;

import java.util.HashMap;
import java.util.Map;

public class Repository {

    private final int countDefect;
    private int index = 0;

    private Map<Long, Defect> repo = new HashMap<>();

    public void add(Defect defect) {
        repo.put((long) index, defect);
        index++;
    }

    public Defect[] getAll() {
        Defect[] def = new Defect[index];
        int i = 0;
        for (Map.Entry<Long, Defect> entry : repo.entrySet()) {
            Defect value = entry.getValue();
            def[i] = value;
            i++;
        }
        return def;
    }

    public boolean containsId(long id) {
        return repo.containsKey(id);
    }

    public Defect getDefect(long id) {
        return repo.get(id);
    }

    public Repository(int countBugs) {
        this.countDefect = countBugs;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public boolean isFull() {
        return index == countDefect;
    }
}
