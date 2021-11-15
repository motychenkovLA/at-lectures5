package tracker;

public class BugAttach extends Attachment {

    String linkBug;

    public BugAttach(String linkBug) {
        this.linkBug = linkBug;
    }

    @Override
    public String toString() {
        return "Дефект:" + linkBug;
    }
}
