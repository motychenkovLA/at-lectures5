package trackerV2;

import java.util.Objects;

public class CommentAttachment extends Attachment {
    private final String comment;

    public CommentAttachment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return String.format("Комментарий: %s", comment);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (comment == null ? 0 : comment.hashCode());
        return result;
    }


}