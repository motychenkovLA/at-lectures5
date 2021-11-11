package tracker;

// todo 3 - public на все что не private - исправила
public class Repository {
    private Bug[] repository;
    // todo 3 - за подсчет количества дефектов должен отвечать дефект а не репо
    //   репо должен помнить только сколько в нём сейчас - исправила
    private int counter = 0;

    Repository(int size) {
        this.repository = new Bug[size];
    }

    // todo 3 - дз: класс Repository имеет методы - исправила
    //  > void add(Defect defect) < - исправлено
    //  этот принимает набор полей а не дефект - исправиа
    public void addBug(Bug bug) {
        if (counter < repository.length) {
            repository[counter] = bug;
            counter++;
        }
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public int getSize() {
        return counter;
    }

    public boolean isFull() {
        return counter >= repository.length;
    }

    // todo 3 - get, ничего не возвращает - исправила
    // todo 3 - за вывод на консоль должен отвечать Main а не Repo - исправила
    public Bug[] getBug() {
        Bug[] listBug = new Bug[counter];
        System.arraycopy(repository, 0, listBug, 0, counter);
        return listBug;
    }


}
