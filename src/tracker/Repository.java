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

    // todo ? - с одной стороны технически верно, потому что мы извне гарантируем что index = id,
    //   с другой - наверное все таки стоит вытаскивать по id
    public Defect getElementByIndex(int index) {

        if (index < 0) {
            return null;
        }

        for (int i = 0; i < currentElement; i++) {
            if (index == bugs[i].getId()) {
                return bugs[i];
            }
        }
        return null;
    }
}
