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
        // todo 0 лучше daysToFix
        int daysForFixed = scanner.nextInt();
        scanner.nextLine();

        // todo 3 рабочая неделя 5 дней
        // todo 3 лучше вынести число в константу в самое начало метода
        boolean moreThanWeek = 7 < daysForFixed;

        System.out.println("Информация о дефекте:");
        // todo 1 строка вылезает за экран, можно перенести, разделив по плюсам
        // todo 1 складываются литералы (вроде "a" + "b"), лучше сразу написать результат ("ab")
        System.out.println( "Резюме:" +  resume + "|"+ "Серьезность:" + priority + "|" + "Количество дней на исправление:" + daysForFixed + "|" + "Займет больше рабочей недели? " + moreThanWeek + "|");
    }
}
