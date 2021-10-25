package tracker;

public class Repository {

    private final int bugsNum;
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

    public boolean isFull() {
        return bugsNum == index;
    }

    public boolean isEmpty() {
        return index == 0;
    }
}
