package tracker;

public class DefectAttachment extends Attachment {

    // todo 1 - final без set-get, поле в принципе не меняется и от этого класса нужен только toString
    private final long bugId;

    public DefectAttachment(long bugId) {
        this.bugId = bugId;
    }

    @Override
    public String toString() {
        return String.format("Дефект № %d", bugId);
    }

}
