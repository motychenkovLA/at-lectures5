package tracker;

public class Repository {

    private final int NUM_OF_BUGS;
    private Defect[] bugs;
    private int index = 0;


    public Repository(int numOfBugs) {
        NUM_OF_BUGS = numOfBugs;
        this.bugs = new Defect[NUM_OF_BUGS];
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
}
