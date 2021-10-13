package tracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Предложить пользователю ввести резюме дефекта и принять строку
        System.out.println("Введите резюме дефекта:");
        String resumeOfBug = scanner.nextLine();

        // Предложить ввести критичность, выдать список вариантов и принять строку
        System.out.println("Введите критичность дефекта (Низкий, Средний, Высокий, Критичный):");
        String criticalityOfBug = scanner.nextLine();

        // Предложить ввести ожидаемое количество дней на исправление дефекта и принять число
        System.out.println("Введите ожидаемое количество дней на исправление дефекта:");
        int daysForFix = scanner.nextInt();
        scanner.nextLine();

        // Вывести информацию о заведенном дефекте в виде: резюме
        //                                                 критичность
        //                                                 количество дней на исправление
        //                                                 займет больше рабочей недели (true/false)
        final int WORKWEEK = 5;
        boolean moreThanWeek = daysForFix > WORKWEEK;
        System.out.println("Информация о заведенном дефекте:");
        System.out.println("Резюме - " + resumeOfBug + "\n" + "Критичность - " + criticalityOfBug + "\n" + "Количество дней на исправление - " + daysForFix + "\n" + "Займет больше рабочей недели - " + moreThanWeek);
    }
}
