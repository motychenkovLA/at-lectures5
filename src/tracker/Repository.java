package tracker;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalDouble;

public class Repository {
    Map<Long, Defect> repository = new HashMap<>();
    private Defect[] defects;
    private long currentDefectCount = 0;
    private long id;


    public void add(Defect defect) {
        repository.put(currentDefectCount, defect);
        currentDefectCount++;
    }

    public Defect getDefectById(long id) {
        return repository.get(id);
    }

    public Defect[] getALL() {
        return repository.values().toArray(new Defect[0]);
    }

    public int getCurrentDefectCount() {
        return (int) currentDefectCount;
    }

    public int getMax() {
        Defect max = repository.values().stream().max(Comparator.comparingInt(Defect::getDaysToFixed)).get();
        return max.getDaysToFixed();
    }

    public int getMin() {

        Defect min = repository.values().stream().min((Defect x1, Defect x2) -> x1.getDaysToFixed() - x2.getDaysToFixed()).get();
        return min.getDaysToFixed();
    }

    //public OptionalDouble getAvg() {
    //    OptionalDouble avg = repository.values().stream().mapToDouble(x1 -> x1.getDaysToFixed()).average();
    //   return avg;
    //}

    public String getAvg() {
        Double avg = repository.values().stream().mapToInt(x1 -> x1.getDaysToFixed()).average().getAsDouble();
        return String.valueOf(avg);
    }

    public String getTableStatusOpen() {
       int countOpen = repository.values().stream().filter((Defect x) -> x.getStatus()==Status.OPEN).toArray().length;
        return String.valueOf(countOpen) ;
   }

    public String getTableStatusInprogress() {
        int countInprogress = repository.values().stream().filter((Defect x) -> x.getStatus()==Status.INPROGRESS).toArray().length;
        return String.valueOf(countInprogress) ;
    }

    public String getTableStatusTesting() {
        int countTesting = repository.values().stream().filter((Defect x) -> x.getStatus()==Status.TESTING).toArray().length;
        return String.valueOf(countTesting) ;
    }

    public String getTableStatusClose() {
        int countClose = repository.values().stream().filter((Defect x) -> x.getStatus()==Status.CLOSE).toArray().length;
        return String.valueOf(countClose) ;
    }
}
