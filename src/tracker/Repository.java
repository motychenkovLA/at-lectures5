package tracker;

public class Repository {

    private final int maxRepoIndex;
    private final Defect[] defects;
    private int repoIndex = 0;

    public Repository(int maxRepoIndex) {
        this.maxRepoIndex = maxRepoIndex;
        this.defects = new Defect[maxRepoIndex];
    }

    public void addDefectInRepo(Defect defect){
        defects [repoIndex] = defect;
        repoIndex++;
    }

    public Defect[] getAll(){
        return this.defects;
    }

    public boolean filled(){
        return repoIndex == maxRepoIndex;
    }

    public int getRepoIndex(){
        return repoIndex;
    }

    public Defect getDefectById (long id) {
        Defect currentDefect = null;
        for (int i = 0; i < repoIndex; i++) {
            if (defects[i].getId() == id) {
                currentDefect = defects[i];
                break;
            }

        }
        return currentDefect;
    }
}
