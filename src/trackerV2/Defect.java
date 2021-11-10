package trackerV2;

public class Defect {
    private static long counterOfBugs = 0;
    private final long id;
    private String resume;
    private String seriousness;
    private int days;
    private Attachment attachment;

    public Defect(String resume, String seriousness, int days, Attachment attachment) {
        this.id = counterOfBugs;
        this.resume = resume;
        this.seriousness = seriousness;
        this.days = days;
        this.attachment = attachment;
        counterOfBugs++;
    }


    public String getInfo() {
        return  id + " | " + resume + " | " + seriousness + " | " + days + " | " + attachment;

    }
}