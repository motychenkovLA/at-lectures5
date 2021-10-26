package tracker;

public class Defect {

    private static int number = 0;

    private final long id;
    private String resume;
    private String critical;
    private int countDays;

    public Defect(String resume, String critical, int countDays) {
        this.id = number;
        this.resume = resume;
        this.critical = critical;
        this.countDays = countDays;

        number++;
    }

    public long getId() {
        return id;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getCritical() {
        return critical;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }

    public int getCountDays() {
        return countDays;
    }

    public void setCountDays(int countDays) {
        this.countDays = countDays;
    }

    public String getDisplayInf() {
        return this.getId() + "| " + this.getResume() + "| " + this.getCritical() + "| " + this.getCountDays();
    }
}
