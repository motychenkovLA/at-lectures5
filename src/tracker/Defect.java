package tracker;
public class Defect {

    long id;
    String summary;
    String severuty;
    int daysToFixList;

    public Defect(long id, String summary, String severuty, int daysToFixList) {
        this.id = id;
        this.summary = summary;
        this.severuty = severuty;
        this.daysToFixList = daysToFixList;
    }

    public String getInfo () {
        return "ID:" + id + " | " + "РЕЗЮМЕ:" + summary + " | " + "СЕРЬЕЗНОСТЬ:" + severuty + " | " +
                "КОЛИЧЕСТВО ДНЕЙ НА ИСПРАВЛЕНИЕ:" + daysToFixList;

    }
}
