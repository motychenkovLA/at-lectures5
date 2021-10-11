package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите резюме дефекта:");
        String summary = scanner.nextLine();
        System.out.println("Введите критичность дефекта:\n" + "Критичный\n" + "Высокий\n" + "Средний\n" + "Низкий");
        String criticality = scanner.nextLine();
        System.out.println("Введите кол-во дней на исправление дефекта:");
        int days = scanner.nextInt();
        scanner.nextLine();
        boolean border;
        border = days > 5;
        System.out.println("Результат:\n" + "Резюме дефекта - " + summary + "\n" + "Критичность дефекта - " + criticality + "\n" + "Кол-во дней на исправление - " + days + "\n" + "Займет больше рабочей недели - " + border);
    }

}