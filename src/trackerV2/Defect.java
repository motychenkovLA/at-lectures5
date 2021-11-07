package trackerV2;

public class Defect {
    long id;
    String resume;
    String seriousness;
    int days;

    public Defect(long id, String resume, String seriousness, int days) {
        this.id = id;
        this.resume = resume;
        this.seriousness = seriousness;
        this.days = days;
    }


    public String Bug() {

        return ("Номер дефекта: " + id + " | Резюме: " + resume + " | Серьезность: " + seriousness + " | Количество дней на исправление: " + days);
    }
}