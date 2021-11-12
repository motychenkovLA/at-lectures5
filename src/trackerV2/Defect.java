package trackerV2;
public class Defect {
    private static long counterOfBugs = 0;
    private final long id;
    private String resume;
    private Seriousness seriousness;
    private int daysToFix;
    private Attachment attachment;
    private Status status;
    public Defect(String resume, Seriousness seriousness, int daysToFix, Attachment attachment) {
        this.resume = resume;
        this.seriousness = seriousness;
        this.daysToFix = daysToFix;
        this.id = counterOfBugs;
        this.attachment = attachment;
        this.status = Status.OPEN;
        counterOfBugs++;
    }
    public long getId() {
        return id;
    }
    public void setResume(String resume) {
        this.resume = resume;
    }
    public String getResume() {
        return resume;
    }
    public void setSeriousness(Seriousness seriousness) {
        this.seriousness = seriousness;
    }
    public Seriousness getSeriousness() {
        return seriousness;
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
                id, status.toString(), resume, seriousness.toString(), daysToFix, attachment.toString());
    }}