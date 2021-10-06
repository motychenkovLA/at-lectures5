// Ilya Osin
// 10/07/2021
// Lesson3
package Homework_3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final byte MAX_DEFECTS = 3; // Максимальное значение хранящихся дефектов
        String menu = null; // Выбранный пункт меню
        String[][] listOfBugs = new String[MAX_DEFECTS][3]; // Матрица дефектов
        byte defects = 0; // Кол-во заведенных дефектов
        byte row = 0; // row - индекс ряда массива

        while (!"quit".equals(menu)) {
            // Ввод команды
            System.out.println("*******************************************");
            System.out.println();
            System.out.println("Введите команду, чтобы:" + '\n' + '\t' + "Добавить новый дефект: add" + '\n' + '\t' + "Вывести список дефектов: list" + '\n' + '\t' + "Выйти из программы: quit");
            System.out.print('\n' + "Введите команду: ");
            menu = scan.nextLine();
            System.out.println();

            //for (int i = 0; i < 50; ++i) System.out.println(); // Костыльная очистка консоли через сдвиг за счет переносов строк

            switch (menu) {
                case "add": // Добавление дефекта
                    if (defects < MAX_DEFECTS) {

                        // Ввод резюме
                        System.out.println("*******************************************");
                        System.out.println();
                        System.out.print("Резюме дефекта: ");
                        String resume = scan.nextLine();
                        listOfBugs[row][0] = resume;
                        System.out.println();

                        // Ввод критичности
                        System.out.println("Введите кричисность дефекта:" + '\n' + '\t' + "- Blocker" + '\n' + '\t' + "- Critical" + '\n' + '\t' + "- Major" + '\n' + '\t' + "- Minor" + '\n' + '\t' + "- Trivial" + '\n');
                        System.out.print("Критичность: ");
                        String severity = scan.nextLine();
                        listOfBugs[row][1] = severity;
                        System.out.println();

                        // Ввод количества дней на исправление
                        System.out.print("Ожидаемое кол-во дней на исправление: ");
                        int daysToFix = scan.nextInt();
                        String str = Integer.toString(daysToFix);
                        listOfBugs[row][2] = str;
                        System.out.println();

                        row++;
                        defects++;
                        menu = null;
                    } else {
                        System.out.println("*******************************************");
                        System.out.println();
                        System.out.println("ВНИМАНИЕ!!! Достигнуто максимальное количество дефектов. Возврат в главное меню...");
                        System.out.println();
                    }
                    break;
                case "list": // Вывод на экран списка созданных дефектов.
                    System.out.println("*******************************************");
                    System.out.println();
                    System.out.println("Список дефектов:");
                    for (row = 0; row < defects; row++) {
                        System.out.println(row + " | " + listOfBugs[row][0] + " | " + listOfBugs[row][1] + " | " + listOfBugs[row][2]);
                    }
                    System.out.println();
                    break;
            }
        }
        scan.close(); // Закрыть сканнер
    }
}
