package tracker;

import java.util.HashMap;
import java.util.Map;

public class Repository {
    private Defect[] defects;
    Map <Long, Defect> repository = new HashMap<>() ;
    private long currentDefectCount =0;
    private long id;



   // public Repository(int maxCapacity) {
    //    this.defects = new Defect[maxCapacity];
     //   this.id = id;
    //}

    public void add (Defect defect){
        /*defects[(int) currentDefectCount] = defect;
        currentDefectCount++;*/
        repository.put(currentDefectCount, defect);
        currentDefectCount++;

    }

    public Defect getDefectById(long id) {
       /* Defect targetDefect = null;
        for (int i = 0; i < currentDefectCount; i++) {
            if (defects[i].getId() == id ) {
                targetDefect = defects[i];
            }
        }

        return targetDefect ;*/
        return repository.get(id);
    }

    public Defect[] getALL(){
   //return  defects;
        return repository.values().toArray(new Defect[0]);
    }

    public int getCurrentDefectCount() {
        return (int) currentDefectCount;
    }
}
