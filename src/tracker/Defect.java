package tracker;

public class Defect {

    private final long id;
    private static long index;
    private final int daysToFix;
    private final String resume;
    private Severity severity;
    private final Attachment attachment;
    private Status status;

    public Defect(String resume, Severity severity, int daysToFix, Attachment attachment, Status status) {
        this.id = index;
        this.resume = resume;
        this.severity = severity;
        this.daysToFix = daysToFix;
        this.attachment = attachment;
        this.status = status;
        index++;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    public long getId(){
        return id;
    }

    public String getDefectInfo() {
        return "id: " + id + " | " + "Резюме: " + resume + " | " + "Серьезность: " + severity + " | " +
                "Кол-во дней на исправление: " + daysToFix + " | " + "Вложение: " + attachment + " | " + "Статус: " + status;
    }
}
