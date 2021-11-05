package tracker;
public class Defect {

    long id;
    String summary;
    String severity;
    int daysToFix;

    public Defect(long id, String summary, String severity, int daysToFix) {
        this.id = id;
        this.summary = summary;
        this.severity = severity;
        this.daysToFix = daysToFix;
    }

    public String getInfo () {
        return "ID:" + id + " | " + "РЕЗЮМЕ:" + summary + " | " + "СЕРЬЕЗНОСТЬ:" + severity + " | " +
                "КОЛИЧЕСТВО ДНЕЙ НА ИСПРАВЛЕНИЕ:" + daysToFix;

    }
}
