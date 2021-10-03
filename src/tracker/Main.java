// Osin Ilya
// 10/03/2021
// Lesson2. Scanner

package tracker;

import java.util.Scanner;

public class Main {

    // Цвета для вывода текста
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {

        // Ввод резюме
        Scanner scan = new Scanner(System.in);
        System.out.println("_____________________________________________");
        System.out.print("Резюме дефекта: ");
        String resume = scan.nextLine();

        // Ввод критичности
        System.out.println("_____________________________________________");
        System.out.println("Введите кричисность дефекта:" + '\n' + '\t' + ANSI_RED + "- Blocker" + ANSI_RESET + '\n' + '\t' + ANSI_YELLOW + "- Critical" + ANSI_RESET + '\n' + '\t' + ANSI_BLUE + "- Major" + ANSI_RESET + '\n' + '\t' + ANSI_WHITE + "- Minor" + ANSI_RESET + '\n' + '\t' + ANSI_GREEN + "- Trivial" + ANSI_RESET + '\n');
        System.out.print("Критичность: ");
        String severity = scan.nextLine();

        // Ввод количества дней на исправление
        System.out.println("_____________________________________________");
        System.out.print("Ожидаемое кол-во дней на исправление: ");
        int daysToFix = scan.nextInt();
        System.out.println("_____________________________________________" + '\n');

        // Закрыть сканнер
        scan.close();

        // Вывод результата обработки
        boolean weekOrNot = daysToFix > 5;
        System.out.println("Резюме дефекта: " + ANSI_CYAN + resume + ANSI_RESET);
        System.out.println('\t' + "Критичность: " + ANSI_CYAN + severity + ANSI_RESET);
        System.out.println('\t' + "Дней на исправление: " + ANSI_CYAN + daysToFix + ANSI_RESET + '\n' + '\t' + '\t' + "Больше недели: " + ANSI_CYAN + weekOrNot + ANSI_RESET);

    }
}
