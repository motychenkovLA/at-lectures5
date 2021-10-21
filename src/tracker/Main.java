package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int NUM_BUG = 10;
//        todo необходимо ввести переменную которая отражает максимальное количество дефектов
//                использовать её тут \/ и на 27 строчке
        String[] bugPriority = new String[NUM_BUG];
        String[] bugResume = new String[NUM_BUG];
        int[] bugDaysToFixed = new int[NUM_BUG];
        int countReq = 0; // переменная для количества дефектов
        boolean isRun = true; // переменная для бесконечного цикла
//        todo почему тут всего 12 попыток? зачем вообще ограничивать попыттки?
        while (isRun) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(" Выберите действие Add (Новый дефект)" +
                    " List (Вывести список дефектов)" +
                    " Quit (Вернуться в главное меню)");
            String action = scanner.nextLine();
            switch (action) {
                case ("Add"): {
// todo                     тут    \/

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
//todo переделать хранение готовой карточки клиента на массивы
                    bugResume [countReq] = resume;
                    bugPriority[countReq] = priority;
                    bugDaysToFixed[countReq] = daysToFixed;
                    countReq = countReq + 1;
                    break;
                }
                case "List":
                    // System.out.println(Arrays.toString(listbug));
//todo переделать вывод yа вывод из массивов
                    for (int i = 0; i<countReq; i++){
                    System.out.println ("|" + i + "|" + bugResume [i] + "|" + bugPriority[i] + "|" + bugDaysToFixed[i] + "|");
                }
                    break;
//todo выход не работает
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
