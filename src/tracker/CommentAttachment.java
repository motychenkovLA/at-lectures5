package tracker;

import java.util.Objects;

public class CommentAttachment extends Attachment {
    private String comment;

    public CommentAttachment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Комментарий: " + this.comment;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true; //проверяем сами ссылки
        if (o == null || getClass() != o.getClass()) return false;//проверяем на null и берем в getClass
        CommentAttachment that = (CommentAttachment) o;//приведение типов
        return Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment);
    }
}

