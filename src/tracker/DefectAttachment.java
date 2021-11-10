package tracker;

public class DefectAttachment extends Attachment {
    private long defectId;

    public DefectAttachment(long defectId) {
        this.defectId = defectId;
    }

    @Override
    public String toString() {
        return "ID дефекта: " + defectId;
    }
}
