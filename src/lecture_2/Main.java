package lecture_2;
// todo 1 пакет tracker

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // todo 1 - объявление переменных задолго до использования, без инициализации
        String summary;
        String priority;
        int numOfDays; // todo 0 -> dayCount, daysToFix, лучше избегать of в названиях
        boolean duringWorkWeek;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите резюме дефекта:");
        summary = scanner.nextLine();

        System.out.println("Введите критичность дефекта: блокирующий, высокий, средний, низкий:");
        priority = scanner.nextLine();

        System.out.println("Введите количество дней на исправление дефекта:");
        numOfDays = scanner.nextInt();
        scanner.nextLine();

        // todo 3 - 5 это константа, вынести в начало main
        duringWorkWeek = numOfDays > 5;

        System.out.println("\nИнформация о дефекте");
        System.out.println("Резюме: " + summary);
        System.out.println("Критичность: " + priority);
        System.out.println("Количество дней на исправление: " + numOfDays);
        System.out.println("Займет больше рабочей недели: " + duringWorkWeek);
    }
}
