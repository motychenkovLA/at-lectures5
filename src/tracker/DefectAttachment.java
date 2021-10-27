package tracker;

// todo 3 - полностью дублирует CommentAttachment, должен хранить id или сам defect
public class DefectAttachment extends Attachment{
    private final int defectLink;

    public DefectAttachment(int defectLink) {
        this.defectLink = defectLink;
    }

    @Override
    public String toString() {
        return String.valueOf(defectLink);
    }
}
