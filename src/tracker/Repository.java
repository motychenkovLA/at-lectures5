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

    public boolean checkID(int id){
        Defect[] defect = getAll();
        for (int i = 0; i < defect.length; i++) {
            if (id==defect[i].getId()){
                return true;
            }
        }
        return false;
    }

    public Defect getDefect(int id){
        Defect[] defect = getAll();
        return defect[id];
    }
}
