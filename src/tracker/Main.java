package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int MAX_DEFECTS = 10; // максимальное количеств дефектов
        int currentDefectNum = 0; // текущий номер дефекта
        Defect [] defects = new Defect[MAX_DEFECTS]; // один массив для 10 дефектов
        Repository [] repositories = new Repository[MAX_DEFECTS]; // теперь Repository для хранения дефектов
        boolean isRunning = true;
        while (isRunning) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Выберите: (Add)/ (List)/ (Quit)"); // добавить новый дефект, вывести список,выйти (меню)
            String menu = scan.nextLine();
            switch (menu) {
                case ("Add"): {
                    if (MAX_DEFECTS > currentDefectNum) {
                        System.out.println("Введите резюме дефекта:");
                        String summary = scan.nextLine();
                        System.out.println("Введите критичность дефекта (Low/ Medium/ High/ Highest/:");
                        String severity = scan.nextLine();
                        System.out.println("Введите ожидаемое количество дней на исправление:");
                        int daysToFix = scan.nextInt();
                        scan.nextLine();
                        Defect defect = new Defect(currentDefectNum, summary,severity, daysToFix);
                        defects[currentDefectNum] = defect;
                        currentDefectNum++;
                    } else {
                        System.out.println("Достигнуто максимальное количество дефектов");
                    }
                    break;
                }
                case ("List"): {
                    for (int i = 0; i < currentDefectNum; i++) {
                        System.out.println(defects[i].getInfo());//вывод списка дефектов
                    }
                    break;
                }
                case ("Quit"): {
                    isRunning = false;
                    System.out.println("До свидания!");
                    break;
                }
                default: {
                    System.out.println("Такого пункта меню нет");
                    break;
                }

            }
        }
    }
}

