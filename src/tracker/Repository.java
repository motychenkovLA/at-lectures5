package tracker;

public class Repository {
    private int currentDefectCount =0;
    private long id;

    private Defect[] defects;

    public Repository(int maxCapacity) {
        this.defects = new Defect[maxCapacity];
        this.id = id;
    }

    public void add (Defect defect){
        defects[(int) currentDefectCount] = defect;
        currentDefectCount++;

    }

    public Defect getDefectById(long id) {
        Defect targetDefect = null;
        for (int i = 0; i < currentDefectCount; i++) {
            if (defects[i].getId() == id ) {
                targetDefect = defects[i];
            }
        }

        return targetDefect ;
    }

    public Defect[] getALL(){
   return  defects;
    }

    public int getCurrentDefectCount() {
        return currentDefectCount;
    }
}
