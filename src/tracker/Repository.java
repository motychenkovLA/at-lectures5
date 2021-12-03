package tracker;

import java.util.HashMap;
import java.util.Map;

public class Repository {

    private final int countDefect;
    private int index = 0;

    private Map<Long, Defect> repo = new HashMap<>();

    public void add(Defect defect) {
        // todo 5 - во всех остальных методах с мапой работают так, будто ключ это id,
        //   но здесь ключ это index
        //   потенциально баг, работает только за счет совпадения id и index
        repo.put((long) index, defect);
        index++;
    }

    public Defect[] getAll() {
        // todo 3 - return repo.values()
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
        // todo 5 - сохранен по index, тут проверяется наличие id, это разные вещи
        //   потенциально баг, работает только за счет совпадения id и index
        return repo.containsKey(id);
    }

    public Defect getDefect(long id) {
        // todo 5 - сохранен по index, тут достается по id, это разные вещи
        //   потенциально баг, работает только за счет совпадения id и index
        return repo.get(id);
    }

    public Repository(int countBugs) {
        // todo ? - с переходом на мапу можно отказаться от ограничений на размер репо, но это на усмотрение
        this.countDefect = countBugs;
    }

    public boolean isEmpty() {
        // todo 0 - repo.isEmpty()
        return index == 0;
    }

    public boolean isFull() {
        // todo ? - если без ограничений делать, то смысла нет
        return index == countDefect;
    }
}
