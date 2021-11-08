package tracker;

import java.util.Scanner;

public class Main {

    final static int MAX_DEFECTS = 10;
    static Repository repository = new Repository(MAX_DEFECTS);
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Выберите: (Add)/ (List)/ (Quit)");
            String menu = scan.nextLine();
            switch (menu) {
                case ("Add"): {
                    add();
                    break;
                }
                case ("List"): {
                    for (int i = 0; i < repository.getCurrentSize(); i++) {
                        System.out.println(repository.getAll()[i].getInfo());//вывод списка дефектов
                    }
                    break;
                }
                case ("Quit"):
                    isRunning = false;
                    System.out.println("До свидания!");
                    break;
                default: {
                    System.out.println("Такого пункта меню нет");
                    break;
                }

            }
        }
    }
    private static void add() {
        if (!repository.isFull()) {
            System.out.println("Введите резюме дефекта:");
            String summary = scan.nextLine();
            System.out.println("Введите критичность дефекта (Low/ Medium/ High/ Highest/:");
            String severity = scan.nextLine();
            System.out.println("Введите ожидаемое количество дней на исправление:");
            int daysToFix = scan.nextInt();
            scan.nextLine();
            Defect defect = new Defect(summary,severity, daysToFix);
            repository.add(defect); // созданный дефект добавили в репозиторий
        } else {
            System.out.println("Достигнуто максимальное количество дефектов");
        }


    }


}

