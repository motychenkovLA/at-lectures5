package tracker;
public class Defect {

    private final long id;
    private String summary;
    private String severity;
    private int daysToFix;
    private static long indexNumber = 0;
    private Attachment attachment;
    private Status status;
    private Critical critical;

    public Defect(String summary, Critical critical, int daysToFix, Attachment attachment) {
        this.id = indexNumber;
        this.summary = summary;
        this.critical = critical;
        this.daysToFix = daysToFix;
        this.attachment = attachment;
        this.status = Status.OPEN;
        indexNumber++;

    }
    public String getInfo () {
        return "ID:" + id + " | " + "РЕЗЮМЕ: " + summary + " | " + "СЕРЬЕЗНОСТЬ: " + critical + " | " +
                "КОЛИЧЕСТВО ДНЕЙ НА ИСПРАВЛЕНИЕ: " + daysToFix + " | " + "Вложение - " +  attachment+ " | " +
                "Статус: " +  status;
    }

    public long getId() {
        return id;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setCritical(Critical critical) {
        this.critical = critical;
    }
}
