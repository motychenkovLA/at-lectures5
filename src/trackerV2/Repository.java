package trackerV2;

public class Repository {

    private final int defectCount;

    private final Defect[] defects;

    private int i = 0;

    public Repository(int maxAmount) {
        this.defectCount = maxAmount;
        this.defects = new Defect[defectCount];
    }

    public void addBug(Defect defect) {
        defects[i] = defect;
        i++;

    }

    public Defect[] getBugs() {
        Defect[] arrayDefects = new Defect[i];
        for (int b = 0; b < i; b++) {
            arrayDefects[b] = defects[b];
        }
        return arrayDefects;
    }

}
