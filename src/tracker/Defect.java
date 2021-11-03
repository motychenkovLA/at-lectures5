package tracker;

public class Defect {

    private static int number = 0;

    private final long id;
    private Status status;
    private String resume;
    private Critical critical;
    private int countDays;
    private final Attachment attachment;

    public Defect(String resume, Critical critical, int countDays, Attachment attachment) {
        this.id = number;
        this.status = Status.OPEN;
        this.resume = resume;
        this.critical = critical;
        this.countDays = countDays;
        this.attachment = attachment;

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

    public Critical getCritical() {
        return critical;
    }

    public void setCritical(Critical critical) {
        this.critical = critical;
    }

    public int getCountDays() {
        return countDays;
    }

    public void setCountDays(int countDays) {
        this.countDays = countDays;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return
                id + "| " +
                status + "| "+
                resume + "| " +
                critical + "| " +
                countDays + "| " +
                attachment + "| "
                ;
    }
}
