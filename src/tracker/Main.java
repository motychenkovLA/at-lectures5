package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int NUM_BUG = 10;
        Bug[] bugs = new Bug[NUM_BUG];


        long countReq = 0; // переменная для количества дефектов
        boolean isRun = true; // переменная для бесконечного цикла

        while (isRun) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(" Выберите действие Add (Новый дефект)" +
                    " List (Вывести список дефектов)" +
                    " Quit (Вернуться в главное меню)");
            String action = scanner.nextLine();
//            todo приветси в порядок форматирование switch по аналогии c первым case, везде использовать () и {}
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

                    Bug bug = new Bug (countReq,resume,priority,daysToFixed);
                    bugs[(int) countReq] = bug;
                    countReq = countReq + 1;
                    break;
                }
                case ("List"): {

//todo добавить название колонок в выводимую таблицу, сейчас вывод непонятен
                    for (int i = 0; i < countReq; i++) {
                        System.out.println(bugs[i].getInfo());
                    }
                    break;
                }
                case ("Quit"): {
                    isRun = false;
                    break;
                }
                default:{
                    System.out.println("Операция не существует");
                    break;
                }
            }
        }
    }
}
