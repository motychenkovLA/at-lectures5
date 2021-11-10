package tracker;

// todo 3 - public на все что не private
class Repository {
    private Bug[] repository;
    // todo 3 - за подсчет количества дефектов должен отвечать дефект а не репо
    //   репо должен помнить только сколько в нём сейчас
    private static int counter = 0;

    Repository(int size) {
        this.repository = new Bug[size];
    }

    // todo 3 - дз: класс Repository имеет методы
    //  > void add(Defect defect) <
    //  этот принимает набор полей а не дефект
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
    // todo 3 - get, ничего не возвращает
    // todo 3 - за вывод на консоль должен отвечать Main а не Repo
    void getInfo(){
        for(int i = 0; i<counter; i++){
            System.out.println(repository[i].getBugInfo());
        }
    }
    String getId(){
        String code = "USP-";
        // todo 1 - вне цикла нет смысла через StringBuilder собирать вместо обычного +
        StringBuilder id = new StringBuilder();
        id.append(code).append(counter+1);
        return id.toString();
    }

}
