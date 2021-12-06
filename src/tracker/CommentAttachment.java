package tracker;

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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        CommentAttachment attachment = (CommentAttachment) obj;
        return comment == attachment.comment; // todo 3 - сравнение строк через ==
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment);
    }
}
