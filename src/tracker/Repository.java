package tracker;

public class Repository {

    // todo 1 - не константа
    private final int bugsNum;
    // todo 1 - можно тоже final
    private final Defect[] bugs;
    private int index = 0;


    public Repository(int numOfBugs) {
        this.bugsNum = numOfBugs;
        this.bugs = new Defect[bugsNum];
    }

    public void addBug(Defect bug) {
        bugs[index] = bug;
        index++;

    }

    public Defect[] getAll() {
        Defect[] localBugs = new Defect[index];

        for (int i = 0; i < index; i++) {
            localBugs[i] = bugs[i];
        }

        return localBugs;
    }

    public Boolean getAvailabilityAddBug() {
        return index < bugsNum;
    }

    public Boolean isEmpty() {
        return index == 0;
    }
}
