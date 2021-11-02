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

    // todo 1 - это ...byId получается теперь
    public Defect getElementById(int index) {

        // todo 1 - не стоит проверять, репозиторий не отвечает за то какие у дефектов бывают id

        for (int i = 0; i < currentElement; i++) {
            if (index == bugs[i].getId()) {
                return bugs[i];
            }
        }
        return null;
    }
}
