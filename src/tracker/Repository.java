package tracker;

class Repository {
    private Bug[] repository;
    private static int counter = 0;

    Repository(int size) {
        this.repository = new Bug[size];
    }

    void addBug(String resume, String priority, int days ){
        if(counter < repository.length ) {
            Bug bug = new Bug(getId());
            bug.setResume(resume);
            bug.setPriority(priority);
            bug.setDays(days);
            repository[counter] = bug;
            counter++;
        }
        else {
            System.out.println("Вы добавили максимально-возможное количество дефектов.");
        }
    }
    void getInfo(){
        for(int i = 0; i<counter; i++){
            System.out.println(repository[i].getBugInfo());
        }
    }
    String getId(){
        String code = "USP-";
        StringBuilder id = new StringBuilder();
        id.append(code).append(counter+1);
        return id.toString();
    }

}
