package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int NUM_BUG = 10;
        String[] bugPriority = new String[NUM_BUG];
        String[] bugResume = new String[NUM_BUG];
        int[] bugDaysToFixed = new int[NUM_BUG];
        int countReq = 0; // переменная для количества дефектов
        boolean isRun = true; // переменная для бесконечного цикла
        while (isRun) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(" Выберите действие Add (Новый дефект)" +
                    " List (Вывести список дефектов)" +
                    " Quit (Вернуться в главное меню)");
            String action = scanner.nextLine();
            switch (action) {
                case ("Add"): {
                    if (countReq > NUM_BUG - 1) {
                        System.out.println("Невозможно добавить больше 10 дефектов");

                        break;
                    }
                    System.out.println("Введите резюме дефекта:");
                    String resume = scanner.nextLine();

                    System.out.println("Введите критичность дефекта (Высокий, Средний, Низкий ):");
                    String priority = scanner.nextLine();

                    System.out.println("Введите ожидаемое количество дней на исправление дефекта:");
                    int daysToFixed = scanner.nextInt();
                    scanner.nextLine();
                    bugResume [countReq] = resume;
                    bugPriority[countReq] = priority;
                    bugDaysToFixed[countReq] = daysToFixed;
                    countReq = countReq + 1;
                    break;
                }
                case "List":
                    // System.out.println(Arrays.toString(listbug));
                    for (int i = 0; i<countReq; i++){
                    System.out.println ("|" + i + "|" + bugResume [i] + "|" + bugPriority[i] + "|" + bugDaysToFixed[i] + "|");
                }
                    break;
                case "Quit":
                    isRun = false;
                    break;
                default:
                    System.out.println("Операция не существует");
                    break;
            }
        }
    }
}
