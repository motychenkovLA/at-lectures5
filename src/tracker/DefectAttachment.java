package tracker;

public class DefectAttachment extends Attachment {
    private final long value;

    public DefectAttachment(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Дефект Id: " + this.value;
    }
}