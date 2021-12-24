package trackerV2;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.util.stream.Collectors;

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
    public Map<Status, Long> getStatisticsByStatus() {
        return bugsMap.values().stream().collect(Collectors.groupingBy(Defect::getStatus, Collectors.counting()));
    }

    public IntSummaryStatistics getStatisticsByDaysToFix() {
        return bugsMap.values().stream().collect(Collectors.summarizingInt(Defect::getDaysToFix));
    }
}