package trackerV2;

public class Defect {
    private long id;
    private String resume;
    private String seriousness;
    private int days;
    public Defect(long id, String resume, String seriousness, int days) {
        this.id = id;
        this.resume = resume;
        this.seriousness = seriousness;
        this.days = days;
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
    public String getSeriousness() {
        return seriousness;
    }
    public void setSeriousness(String seriousness) {
        this.seriousness = seriousness;
    }
    public int getDays() {
        return days;
    }
    public void setDays(int days) {
        this.days = days;
    }

    public String BugInfo() {

        return ("Номер дефекта: " + this.getId() + " | Резюме: " + this.getResume() + " | Серьезность: " + this.getSeriousness()  + " | Количество дней на исправление: " + this.getDays());
    }
}
