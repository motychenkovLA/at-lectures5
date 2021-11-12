package trackerV2;

public class DefectAttachment extends Attachment {
    private final long bugId;

    public DefectAttachment(long bugId) {
        this.bugId = bugId;
    }
    @Override
    public String toString() {
        return String.format("№ %d", bugId);
    }
}
