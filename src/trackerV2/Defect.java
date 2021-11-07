package trackerV2;

public class Defect {
    private static long counterOfBugs = 0;
    private final long id;
    private String resume;
    private String seriousness;
    private int days;

    public Defect(String resume, String seriousness, int days) {
        this.id = counterOfBugs;
        this.resume = resume;
        this.seriousness = seriousness;
        this.days = days;
        counterOfBugs++;
    }


    public String BugInfo() {

        return ("Номер дефекта: " + id + " | Резюме: " + resume + " | Серьезность: " + seriousness + " | Количество дней на исправление: " + days);
    }
}