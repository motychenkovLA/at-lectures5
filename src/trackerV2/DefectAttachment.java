package trackerV2;

public class DefectAttachment extends Attachment {


    private final int defectLink;

    public DefectAttachment(int defectLink) {
        this.defectLink = defectLink;
    }

    @Override
    public String toString() {
        return String.format(" Ссылка: " + defectLink);
    }
}