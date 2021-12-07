package tracker;

import java.util.*;
import java.util.stream.Collectors;

public class Repository {
    private static final Map<Long, Defect> repo = new HashMap<>();

    static {
        repo.put(0L, new Defect("Дефект0", Critical.LOW, 10,new CommentAttachment("Комментарий0")));
        repo.put(1L, new Defect("Дефект1", Critical.HIGH, 4,new CommentAttachment("Комментарий1")));
        repo.put(2L, new Defect("Дефект2", Critical.LOW, 2,new CommentAttachment("Комментарий2")));
        repo.put(3L, new Defect("Дефект3", Critical.MEDIUM, 5,new CommentAttachment("Комментарий3")));
        repo.put(4L, new Defect("Дефект4", Critical.BLOCKER, 3,new CommentAttachment("Комментарий4")));
        repo.put(5L, new Defect("Дефект5", Critical.LOW, 7,new CommentAttachment("Комментарий5")));
    }

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

    private List<Integer> listDays() {
        List<Integer> integerList = new ArrayList<>();
        for (Map.Entry<Long, Defect> entry : repo.entrySet()) {
            Defect value = entry.getValue();
            integerList.add(value.getCountDays());
        }
        return integerList;
    }

    public int maxDay() {
        return listDays().stream().max(Comparator.naturalOrder()).get();
    }

    public int averageDay() {
        return (int) listDays().stream().mapToInt(e -> e).average().getAsDouble();
    }

    public int minDay() {
        return listDays().stream().min(Comparator.naturalOrder()).get();
    }

    public Map<String, Long> defectStats() {
        Map<String, Long> map= repo.entrySet().stream().collect(
                Collectors.groupingBy(repo->repo.getValue().getCritical().toString(), Collectors.counting()));

        return map;
    }
}
