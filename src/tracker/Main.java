package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        final int WORK_DAYS = 5;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите резюме дефекта:");
        String resume = scanner.nextLine();

        System.out.println("Введите критичность дефекта (Высокий, Средний, Низкий ):");
        String priority = scanner.nextLine();

        System.out.println("Введите ожидаемое количество дней на исправление дефекта:");
        int daysToFixed = scanner.nextInt();
        scanner.nextLine();

        boolean moreThanWeek = WORK_DAYS < daysToFixed;

        System.out.println("Информация о дефекте:");
        System.out.println( "Резюме:" +  resume + "|Серьезность:" + priority + "|Количество дней на исправление:"
                + daysToFixed + "|Займет больше рабочей недели? " + moreThanWeek + "|" );
    }
}
