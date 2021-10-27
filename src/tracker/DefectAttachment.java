package tracker;

public class DefectAttachment extends Attachment{
    private final String defectLink;

    public DefectAttachment(String defectLink) {
        this.defectLink = defectLink;
    }

    @Override
    public String toString() {
        return defectLink;
    }
}
