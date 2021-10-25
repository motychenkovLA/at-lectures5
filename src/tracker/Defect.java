package tracker;
public class Defect {

    long id;
    String summary;
    String severuty;
    int daysToFix;

    public Defect(long id, String summary, String severuty, int daysToFix) {
        this.id = id;
        this.summary = summary;
        this.severuty = severuty;
        this.daysToFix = daysToFix;
    }

    public String getInfo () {
        return "ID:" + id + " | " + "РЕЗЮМЕ:" + summary + " | " + "СЕРЬЕЗНОСТЬ:" + severuty + " | " +
                "КОЛИЧЕСТВО ДНЕЙ НА ИСПРАВЛЕНИЕ:" + daysToFix;

    }
}
