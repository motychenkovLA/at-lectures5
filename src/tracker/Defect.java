package tracker;

public class Defect {

    private static long bugsAmount = 0;

    private final long id;
    private String summary;
    private Priority priority;
    private int daysToFix;
    private Attachment attachment;
    private Status status;

    public Defect(String summary, Priority priority, int daysToFix, Attachment attachment) {
        this.summary = summary;
        this.priority = priority;
        this.daysToFix = daysToFix;
        this.id = bugsAmount;
        this.attachment = attachment;
        this.status = Status.OPEN;

        bugsAmount++;
    }

    public long getId() {
        return id;
    }


    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSummary() {
        return summary;
    }


    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Priority getPriority() {
        return priority;
    }


    public void setDaysToFix(int daysToFix) {
        this.daysToFix = daysToFix;
    }

    public int getDaysToFix() {
        return daysToFix;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format(
                "Дефект: %d | Статус: %s | Резюме: %s | Критичность: %s | Кол-во дней на исправление: %d | Вложение: %s",
                id, status.toString(), summary, priority.toString(), daysToFix, attachment.toString());
    }
}
