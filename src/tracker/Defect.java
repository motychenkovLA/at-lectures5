package tracker;

public class Defect {

    private static long bugsAmount = 0;

    // todo 3 - final
    private final long id;
    private String summary;
    private String priority;
    private int daysToFix;

    public Defect(String summary, String priority, int daysToFix) {
        this.summary = summary;
        this.priority = priority;
        this.daysToFix = daysToFix;
        this.id = bugsAmount;

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

    public String getBugInfo() {
        return String.format(
                "Дефект: %d | Резюме: %s | Критичность: %s | Кол-во дней на исправление: %d",
                id, summary, priority, daysToFix);

    }

    public static long getBugsAmount() {
        return bugsAmount;
    }

}
