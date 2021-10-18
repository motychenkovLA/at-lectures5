package tracker;

public class Defect {
    public long id;
    public String resume;
    public String critical;
    public int countDays;

    public long getId() {
        return id;
    }

    public String getResume() {
        return resume;
    }

    public String getCritical() {
        return critical;
    }

    public int getCountDays() {
        return countDays;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }

    public void setCountDays(int countDays) {
        this.countDays = countDays;
    }
}
