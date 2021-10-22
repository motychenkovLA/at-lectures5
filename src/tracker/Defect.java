package tracker;

public class Defect {

    private long id;
    private String resume;
    private String critical;
    private int countDays;

    public Defect(long id, String resume, String critical, int countDays) {
        this.id = id;
        this.resume = resume;
        this.critical = critical;
        this.countDays = countDays;
    }

    public long getId() {
        return id;
    }
    // todo 3 - id неизменяемый, сеттера быть не должно
    public void setId(long id) {
        this.id = id;
    }

    public String getResume() {
        return resume;
    }
    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getCritical() {
        return critical;
    }
    public void setCritical(String critical) {
        this.critical = critical;
    }

    public int getCountDays() {
        return countDays;
    }
    public void setCountDays(int countDays) {
        this.countDays = countDays;
    }

    // todo 3 - get ничего не возвращает
    public void getDisplayInf(){
        // todo 3 - Defect занимается работой с консолью, должен заниматься представлением дефекта
        System.out.println(this.getId() + "| " + this.getResume()
                        + "| " + this.getCritical() + "| " + this.getCountDays());
    }
}
