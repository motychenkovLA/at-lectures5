package tracker;

public class Repository {
    private int capacity; // вместительность репо
    private Defect[] defects; // контейнер для хранилища дефектов
    private int currentSize = 0; // текущий "размер" репо

    public Repository(int capacity) {
        this.capacity = capacity;
        defects = new Defect[capacity]; //массив в репозитории
    }

    public void add(Defect defect) {
        defects[currentSize] = defect;
        currentSize++;
    }

    public Defect[] getAll() {
        return this.defects;
    }

    public boolean isFull() {
        return currentSize >= capacity;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public Defect getDefectById (long id) {
        Defect targetDefect = null;
        for (int i = 0; i < currentSize; i++) {
            if (defects[i].getId() == id) {
                targetDefect = defects[i];
                break;
            }

        }
        return targetDefect;
    }
}