// Osin Ilya
// 10/07/2021
// Lesson3
package Homework_3;

import java.util.Scanner;

public class Main {

    // Цвета для вывода текста
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_WHITE = "\u001B[37m";
    private static final byte MAX_DEFECTS = 2;

    public static void main(String[] args) {
        String menu = null;
        Scanner scan = new Scanner(System.in);
        // Условие выхода из программы. Иначе - возврат в меню.
        // Матрица дефектов
        String[][] listOfBugs = new String[MAX_DEFECTS][3];
        // Кол-во заведенных дефектов
        byte defects = 0;
        // row - индекс ряда массива
        byte row = 0;
        while (!"quit".equals(menu)) {

            // Ввод команды
            System.out.println("_____________________________________________");
            System.out.println("Введите команду, чтобы:" + '\n' + '\t' + "Добавить новый дефект: add" + '\n' + '\t' + "Вывести список дефектов: list" + '\n' + '\t' + "Выйти из программы: quit");
            System.out.print('\n' + "Введите команду: ");
            menu = scan.nextLine();

            // Костыльная очистка консоли
            //for (int i = 0; i < 50; ++i) System.out.println();

            switch (menu) {
                case "add":
                    if (defects < MAX_DEFECTS) {

                        // Ввод резюме
                        System.out.println("_____________________________________________");
                        System.out.print("Резюме дефекта: ");
                        String resume = scan.nextLine();
                        listOfBugs[row][0] = resume;

                        // Ввод критичности
                        System.out.println("_____________________________________________");
                        System.out.println("Введите кричисность дефекта:" + '\n' + '\t' + ANSI_RED + "- Blocker" + ANSI_RESET + '\n' + '\t' + ANSI_YELLOW + "- Critical" + ANSI_RESET + '\n' + '\t' + ANSI_BLUE + "- Major" + ANSI_RESET + '\n' + '\t' + ANSI_WHITE + "- Minor" + ANSI_RESET + '\n' + '\t' + ANSI_GREEN + "- Trivial" + ANSI_RESET + '\n');
                        System.out.print("Критичность: ");
                        String severity = scan.nextLine();
                        listOfBugs[row][1] = severity;

                        // Ввод количества дней на исправление
                        System.out.println("_____________________________________________");
                        System.out.print("Ожидаемое кол-во дней на исправление: ");
                        int daysToFix = scan.nextInt();
                        System.out.println("_____________________________________________" + '\n');
                        String str = Integer.toString(daysToFix);
                        listOfBugs[row][2] = str;

                        row++;
                        defects++;
                        menu = null;

                        // Вывод результата обработки
                        //System.out.println("| " + resume + " | " + severity + " | " + daysToFix + " |");
                    } else {
                        System.out.println("Достигнуто максимальное количество дефектов. Возврат в главное меню...");
                    }
                    break;
                case "list":
                    // Вывод на экран списка созданных дефектов.
                    for (row = 0; row < defects; row++) {
                        System.out.println(listOfBugs[row][0] + " | " + listOfBugs[row][1] + " | " + listOfBugs[row][2]);
                    }
                    break;
            }
        }
        // Закрыть сканнер
        scan.close();
    }
}
