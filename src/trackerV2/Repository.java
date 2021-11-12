package trackerV2;
public class Repository {
    private final int defectCount;
    private final Defect[] defects;
    private int currentElement = 0;
    public Repository(int maxAmount) {
        this.defectCount = maxAmount;
        this.defects = new Defect[defectCount];
    }
    public void addBug(Defect defect) {
        defects[currentElement] = defect;
        currentElement++;
    }
    public Defect[] getDefects() {
        Defect[] arrayDefects = new Defect[currentElement];
        for (int i = 0; i < currentElement; i++) {
            arrayDefects[i] = defects[i];
        }
        return arrayDefects;
    }
    public boolean isFull() {
        return defectCount == currentElement;
    }
    public Defect getElementById(int count) {
        for (int i = 0; i < currentElement; i++) {
            if (count == defects[i].getId()) {
                return defects[i];
            }
        }
        return null;
    }
}
