package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] array_bugs = new String[10];
    String playProgram = "Выберете операцию:" + "\n1 - Add" + "\n2 - List" + "\n3 - Quit";
    int operation;
    int i = 0;
    do {
      System.out.println(playProgram);
      operation = scanner.nextInt();
      scanner.nextLine();
      switch (operation) {
        case 1:
          if (i < array_bugs.length) {
            System.out.println("Введите резюме дефекта:");
            String resume = scanner.nextLine();
            System.out.println(
                "Укажите критичность дефекта:" + "\nВысокий" + "\nСредний" + "\nНизкий");
            String priority = scanner.nextLine();
            System.out.println("Укажите ожидаемое количество дней на исправление дефекта:");
            int days = scanner.nextInt();
            scanner.nextLine();
            String bugs = i + " | " + resume + " | " + priority + " | " + days;
            array_bugs[i] = bugs;
            i++;
          } else {
            System.out.println("Вы добавили максимально-возможное количество дефектов.");
          }
          break;
        case 2:
          System.out.println(Arrays.toString(array_bugs));
          break;
        case 3:
          System.out.println("GoodBye!");
          break;
        default:
          System.out.println("Введена неверная операция! Повторите попытку");
      }
    }
    while ((operation != 3));
  }
}