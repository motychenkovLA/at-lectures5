package tracker;

public class Repository {

    private Defect[] defects;

    public Repository(int countBugs) {
        defects = new Defect[countBugs];
    }

    public void add(Defect defect) {
        defects[defect.getId()] = defect;
    }

    public Defect[] getAll() {

        return defects;
    }

    public boolean place() {
        boolean place = true;
        for (Defect defect : defects) {
            if (defect != null) {
                place = false;
                break;
            }
        }
        return place;
    }
}
