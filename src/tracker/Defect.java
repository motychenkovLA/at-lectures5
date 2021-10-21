package tracker;

public class Defect {

    private long id;
    private String resume;
    private String critical;
    private int countDays;

    public Defect(long id, String resume, String critical, int countDays) {
        this.id = id;
        this.resume = resume;
        this.critical = critical;
        this.countDays = countDays;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
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

    public void getDisplayInf(){

        System.out.println(this.getId() + "| " + this.getResume()
                        + "| " + this.getCritical() + "| " + this.getCountDays());
    }
}
