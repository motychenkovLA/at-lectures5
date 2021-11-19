package tracker;

public class DefectAttachment implements Attachment {

    private final int id;

    public DefectAttachment(int id){
        this.id=id;
    }

    @Override
    public String toString(){
        return "Ссыллаюсь на дефект - " + this.id;
    }
}
