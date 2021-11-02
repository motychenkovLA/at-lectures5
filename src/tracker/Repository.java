package tracker;

public class Repository {

    private final int bugsNum;
    private final Defect[] bugs;
    private int currentElement = 0;


    public Repository(int numOfBugs) {
        this.bugsNum = numOfBugs;
        this.bugs = new Defect[bugsNum];
    }

    public void addBug(Defect bug) {
        bugs[currentElement] = bug;
        currentElement++;

    }

    public Defect[] getAll() {
        Defect[] localBugs = new Defect[currentElement];

        for (int i = 0; i < currentElement; i++) {
            localBugs[i] = bugs[i];
        }

        return localBugs;
    }

    public boolean isFull() {
        return bugsNum == currentElement;
    }

    public boolean isEmpty() {
        return currentElement == 0;
    }

    public Defect getElementById(int index) {
        for (int i = 0; i < currentElement; i++) {
            if (index == bugs[i].getId()) {
                return bugs[i];
            }
        }
        return null;
    }
}
