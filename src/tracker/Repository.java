package tracker;

public class Repository {

    private final int countDefect;
    private final Defect[] defects;
    private int index = 0;


    public Repository(int countBugs) {
        this.countDefect = countBugs;
        this.defects = new Defect[countDefect];
    }

    public void add(Defect defect) {
        defects[index] = defect;
        index++;
    }

    public Defect[] getAll() {
        Defect[] def = new Defect[index];
        for (int i = 0; i < index; i++) {
            def[i] = defects[i];
        }
        return def;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public boolean isFull() {
        return index == countDefect;
    }

    // todo 0 - ...Id - не капсом
    // todo 0 - contains... - проверяет наличие в репо все таки
    public boolean checkID(int id){
        // todo 1 - getAll копирует массив, можно просто перебрать до index без создания копий
        Defect[] defect = getAll();
        for (int i = 0; i < defect.length; i++) {
            if (id==defect[i].getId()){
                return true;
            }
        }
        return false;
    }

    // todo 3 - написан id, возвращает по индексу
    public Defect getDefect(int id){
        Defect[] defect = getAll();
        return defect[id];
    }
}
