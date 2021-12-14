package tracker;

import java.util.Objects;

public class DefectAttachment extends Attachment {
    private final long bugLink;

    public DefectAttachment(long value) {
        this.bugLink = value;
    }

    @Override
    public String toString() {
        return "Дефект Id: " + this.bugLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefectAttachment that = (DefectAttachment) o;
        return bugLink == that.bugLink;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bugLink);
    }
}