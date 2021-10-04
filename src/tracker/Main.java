package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите резюме дефекта:");
        String resume = scanner.nextLine();

        System.out.println("Введите критичность дефекта (Высокий, Средний, Низкий ):");
        String priority = scanner.nextLine();

        System.out.println("Введите ожидаемое количество дней на исправление дефекта:");
        int daysForFixed = scanner.nextInt();
        scanner.nextLine();

        boolean moreThanWeek = 7 < daysForFixed;

        System.out.println("Информация о дефекте:");
        System.out.println( "Резюме:" +  resume + "|"+ "Серьезность:" + priority + "|" + "Количество дней на исправление:" + daysForFixed + "|" + "Займет больше рабочей недели? " + moreThanWeek + "|");


    }
}
