package tracker;
public class Defect {

    private final long id;
    private String summary;
    private String severity;
    private int daysToFix;
    private static long indexNumber = 0;
    private Attachment attachment;

    public Defect(String summary, String severity, int daysToFix, Attachment attachment) {
        this.id = indexNumber;
        this.summary = summary;
        this.severity = severity;
        this.daysToFix = daysToFix;
        this.attachment = attachment;
        indexNumber++;

    }
    public String getInfo () {
        return "ID:" + id + " | " + "РЕЗЮМЕ:" + summary + " | " + "СЕРЬЕЗНОСТЬ:" + severity + " | " +
                "КОЛИЧЕСТВО ДНЕЙ НА ИСПРАВЛЕНИЕ:" + daysToFix + " | " + "Вложение - " +  attachment;
    }
}
