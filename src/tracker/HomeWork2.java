package tracker;
// todo 1 пакет tracker

import java.util.Scanner;

public class HomeWork2 {
    public static void main(String[] args) {

        final int WORK_WEEK = 5;

        // todo 1 - объявление переменных задолго до использования, без инициализации
        // todo 0 - dayCount, daysToFix, лучше избегать of в названиях


        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите резюме дефекта:");
        String summary = scanner.nextLine();

        System.out.println("Введите критичность дефекта: блокирующий, высокий, средний, низкий:");
        String priority = scanner.nextLine();

        System.out.println("Введите количество дней на исправление дефекта:");
        int daysToFix = scanner.nextInt();
        scanner.nextLine();

        // todo 3 - 5 это константа, вынести в начало main
        boolean duringWorkWeek = daysToFix > WORK_WEEK;

        System.out.println("\nИнформация о дефекте");
        System.out.println("Резюме: " + summary);
        System.out.println("Критичность: " + priority);
        System.out.println("Количество дней на исправление: " + daysToFix);
        System.out.println("Займет больше рабочей недели: " + duringWorkWeek);
    }
}
