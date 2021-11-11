package tracker;

public class Repository {
    private Bug[] repository;
    private int counter = 0;

    // todo 1 - public
    Repository(int size) {
        this.repository = new Bug[size];
    }

    public void addBug(Bug bug) {
        if (counter < repository.length) {
            repository[counter] = bug;
            counter++;
        }
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public int getSize() {
        return counter;
    }

    public boolean isFull() {
        return counter >= repository.length;
    }

    // todo 1 - getBugS или getAll
    public Bug[] getBug() {
        Bug[] listBug = new Bug[counter];
        System.arraycopy(repository, 0, listBug, 0, counter);
        return listBug;
    }


}
