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


    @Override
    public String toString() {
        return String.format(
                "Дефект: %d | Статус: %s | Резюме: %s | Критичность: %s | Кол-во дней на исправление: %d | Вложение: %s",
                id, status.toString(), summary, priority.toString(), daysToFix, attachment.toString());
    }

    // todo 3 - сетить Status должен setStatus,
    //   а собирать Status из String, проверяя валидность, это уже ответственность самого Status
    public boolean changeStatus(String status) {
        for (Status element : Status.values()) {
            if (element.toString().equals(status)) {
                this.status = element;
                return true;
            }
        }
        return false;
    }
}
