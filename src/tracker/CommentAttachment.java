package tracker;

public class CommentAttachment extends Attachment {

    // todo 1 - final без set-get, поле в принципе не меняется и от этого класса нужен только toString
    private String comment;

    public CommentAttachment(String comment) {
        this.comment = comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return String.format("Комментарий: %s", comment);
    }

}
