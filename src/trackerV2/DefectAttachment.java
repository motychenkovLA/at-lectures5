package trackerV2;

import java.util.Objects;
import java.lang.Math;

public class DefectAttachment extends Attachment {
    private final long bugId;

    public DefectAttachment(long bugId) {
        this.bugId = bugId;
    }

    @Override
    public String toString() {
        return String.format("№ %d", bugId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        DefectAttachment attachment = (DefectAttachment) obj;
        return bugId == attachment.bugId;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Math.toIntExact(bugId);
        return result;
    }
}