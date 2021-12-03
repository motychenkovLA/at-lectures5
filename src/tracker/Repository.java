package tracker;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Repository {
    private final Map<Long, Defect> repo = new HashMap<>();

    public void add(Defect defect) {
        repo.put(defect.getId(), defect);
    }

    public Collection<Defect> getAll() {
        return repo.values();
    }

    public boolean containsId(long i) {
        return repo.containsKey(i);
    }

    public Defect getDefect(long i) {
        return repo.get(i);
    }

    public boolean isEmpty() {
        return repo.isEmpty();
    }
}
