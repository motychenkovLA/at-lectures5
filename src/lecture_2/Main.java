package lecture_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String summary;
        String priority;
        int numOfDays;
        boolean duringWorkWeek;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите резюме дефекта:");
        summary = scanner.nextLine();

        System.out.println("Введите критичность дефекта: блокирующий, высокий, средний, низкий:");
        priority = scanner.nextLine();

        System.out.println("Введите количество дней на исправление дефекта:");
        numOfDays = scanner.nextInt();
        scanner.nextLine();

        duringWorkWeek = numOfDays > 5;

        System.out.println("\nИнформация о дефекте");
        System.out.println("Резюме: " + summary);
        System.out.println("Критичность: " + priority);
        System.out.println("Количество дней на исправление: " + numOfDays);
        System.out.println("Займет больше рабочей недели: " + duringWorkWeek);
    }
}
