package tracker;

import java.util.Objects;

public class DefectAttachment extends Attachment {
    private final long defectId;

    public DefectAttachment(long defectId) {
        this.defectId = defectId;
    }

    @Override
    public String toString() {
        return "ID дефекта: " + defectId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DefectAttachment that = (DefectAttachment) o;
        return defectId == that.defectId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(defectId);
    }
}
