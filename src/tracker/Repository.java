package tracker;

public class Repository {
    private Bug[] repository;
    private int counter = 0;

    // todo 1 - public - исправила
    public Repository(int size) {
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

    public boolean isFull() {
        return counter >= repository.length;
    }

    // todo 1 - getBugS или getAll - исправила
    public Bug[] getBugs() {
        Bug[] listBug = new Bug[counter];
        System.arraycopy(repository, 0, listBug, 0, counter);
        return listBug;
    }

    public Bug getBugId(String id) {
        for (int i = 0; i < counter; i++) {
            if (id.equals(repository[i].getId())) {
                return repository[i];
            }
        }
        return null;
    }

}
