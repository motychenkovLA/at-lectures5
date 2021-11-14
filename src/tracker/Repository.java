package tracker;

public class Repository {

    private int maxRepoIndex;
    private Defect[] defects;
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
}
