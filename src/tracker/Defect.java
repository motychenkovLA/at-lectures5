package tracker;

public class Defect {
    // todo 3 - не приватные поля
    public long id;
    public String resume;
    public String critical;
    public int countDays;

    // todo 0 - обычно идут парами get-set в том же порядке что и поля
    //   а не сначала все get, потом все set

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
