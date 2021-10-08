package tracker;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    final int WEEKDAYS = 5;
    System.out.println("Введите резюме дефекта:");
    Scanner scanner = new Scanner(System.in);
    String resume = scanner.nextLine();
    System.out.println("Укажите критичность дефекта" + "\nВысокий" + "\nСредний" + "\nНизкий");
    String priority = scanner.nextLine();
    System.out.println("Укажите ожидаемое количество дней на исправление дефекта");
    int days = scanner.nextInt();
    scanner.nextLine();
    boolean moreThanWeek = days > WEEKDAYS;
    System.out.println(
        "РЕЗЮМЕ: " + resume + "\nКРИТИЧНОСТЬ: " + priority + "\nВРЕМЯ ИСПРАВЛЕНИЯ: " + days
            + "\nБОЛЬШЕ РАБОЧЕЙ НЕДЕЛИ? " + moreThanWeek);

  }
}