package tracker;

import java.util.*;
import java.util.stream.Collectors;

public class Repository {

    private final Map<Long, Defect> bugsMap = new HashMap<>();

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

    public Map<Status, Long> getStatisticsByStatus() {
        return bugsMap.values().stream().collect(Collectors.groupingBy(Defect::getStatus, Collectors.counting()));
    }

    public IntSummaryStatistics getStatisticsByDaysToFix() {
        return bugsMap.values().stream().collect(Collectors.summarizingInt(Defect::getDaysToFix));
    }
}