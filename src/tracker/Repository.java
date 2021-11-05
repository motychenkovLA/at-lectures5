package tracker;

public class Repository {
    private int countDefects = 0; // счетчик дефектов
    private Defect [] defects; // массив дефектов из main


    public Repository(int countDefects, Defect[] defects) {
        this.countDefects = countDefects;
        this.defects = defects;
    }
}
