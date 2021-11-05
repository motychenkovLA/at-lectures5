package tracker;

public class Repository {
    private int currentDefectCount =0;

    private Defect[] defects;

    public Repository(int maxCapacity) {
        this.defects = new Defect[maxCapacity];
    }

    public void add (Defect defect){
        defects[(int) currentDefectCount] = defect;
        currentDefectCount++;

    }

    public Defect[] getALL(){
   return  defects;
    }

    public int getCurrentDefectCount() {
        return currentDefectCount;
    }
}
