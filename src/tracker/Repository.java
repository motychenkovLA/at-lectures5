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
        return index == countDefect-1;
    }

    public boolean containsId(int id){
        for (int i = 0; i < index; i++) {
            if (id==index){
                return true;
            }
        }
        return false;
    }

    public Defect getDefect(int id){
        return defects[id];
    }
}
