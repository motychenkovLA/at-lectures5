package tracker;

public class DefectAttachment extends Attachment {

    private int id;

    public DefectAttachment(int id){
        this.id=id;
    }

    @Override
    public String toString(){
        return Integer.toString(id);
    }
}
