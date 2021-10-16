package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final int MAX_DEFECTS = 10; // максимальное количеств дефектов
        int currentDefectNum = 0; // текущий номер дефекта
        String[] summaryList = new String[MAX_DEFECTS]; // Объявили массив
        String[] severutyList = new String[MAX_DEFECTS];
        int[] daysToFixList = new int[MAX_DEFECTS];
        boolean isRunning = true;
        while (isRunning) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Выберите: (Add)/ (List)/ (Quit)"); // добавить новый дефект, вывести список,выйти (меню)
            String menu = scan.nextLine();

            switch (menu) {
                case ("Add"): {
                    if (MAX_DEFECTS > currentDefectNum) {
                        System.out.println("Введите резюме дефекта:");
                        summaryList[currentDefectNum] = scan.nextLine();
                        System.out.println("Введите критичность дефекта (Low/ Medium/ High/ Highest/:");
                        severutyList[currentDefectNum] = scan.nextLine();
                        System.out.println("Введите ожидаемое количество дней на исправление:");
                        daysToFixList[currentDefectNum] = scan.nextInt();
                        scan.nextLine();

                        currentDefectNum++;
                    } else {
                        System.out.println("Достигнуто максимальное количество дефектов");
                    }
                    break;
                }
                case ("List"): {
                    for (int i = 0; i < currentDefectNum; i++) {
                        System.out.println("НОМЕР:" + i + "\n" + "РЕЗЮМЕ:" + summaryList[i] + "\n" +
                                "СЕРЬЕЗНОСТЬ:" + severutyList [i]+ "\n" +
                                "КОЛИЧЕСТВО ДНЕЙ НА ИСПРАВЛЕНИЕ:" + daysToFixList[i]);//вывод списка дефектов
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

