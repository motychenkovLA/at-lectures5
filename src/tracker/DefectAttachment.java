package tracker;

import java.util.Objects;

public class DefectAttachment extends Attachment{
    private final int defectLink;

    public DefectAttachment(int defectLink) {
        this.defectLink = defectLink;
    }

    @Override
    public String toString() {
        return String.valueOf(defectLink);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefectAttachment that = (DefectAttachment) o;
        return defectLink == that.defectLink;
    }

    @Override
    public int hashCode() {
        return Objects.hash(defectLink);
    }
}
