package tracker;

public class Defect {

    private static long bugsAmount = 0;

    private final long id;
    private String summary;
    private String priority;
    private int daysToFix;
    private Attachment attachment;

    public Defect(String summary, String priority, int daysToFix, Attachment attachment) {
        this.summary = summary;
        this.priority = priority;
        this.daysToFix = daysToFix;
        this.id = bugsAmount;
        this.attachment = attachment;

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


    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getPriority() {
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
                "Дефект: %d | Резюме: %s | Критичность: %s | Кол-во дней на исправление: %d | Вложение: %s",
                id, summary, priority, daysToFix, attachment.toString());

    }
}
