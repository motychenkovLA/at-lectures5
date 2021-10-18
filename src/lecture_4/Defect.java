package lecture_4;

public class Defect {
    private long id;
    private String summary;
    private String priority;
    private int daysToFix;

    public Defect(long id, String summary, String priority, int daysToFix) {
        this.id = id;
        this.summary = summary;
        this.priority = priority;
        this.daysToFix = daysToFix;
    }

    // todo 1 - обычно всегда идут парами get-set для каждого поля по порядку

    // todo 3 - id не должен меняться, зачем ему сеттер?
    public void setId(long id) {
        this.id = id;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setDaysToFix(int daysToFix) {
        this.daysToFix = daysToFix;
    }


    public long getId() {
        return id;
    }

    public String getSummary() {
        return summary;
    }

    public String getPriority() {
        return priority;
    }

    public int getDaysToFix() {
        return daysToFix;
    }

    // todo 3 - лучше возвращать строку представляющую дефект,
    //  а выводить ее на консоль уже в main
    public void displayInfo() {
        System.out.format(
                "Дефект: %d | Резюме: %s | Критичность: %s | Кол-во дней на исправление: %d",
                id, summary, priority, daysToFix);
    }

}
