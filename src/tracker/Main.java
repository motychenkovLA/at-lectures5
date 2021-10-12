package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    final int arraySize = 10;
    String[] arrayResume = new String[arraySize];
    String[] arrayPriority = new String[arraySize];
    int[] arrayDays = new int[arraySize];
    String playProgram = "Выберете операцию:" + "\nAdd" + "\nList" + "\nQuit";
    String operation;
    String goodBye = "Quit";
    int index = 0;
    do {
      System.out.println(playProgram);
      operation = scanner.nextLine();
      switch (operation) {
        case "Add":
          if (index < arraySize) {
            System.out.println("Введите резюме дефекта:");
            arrayResume[index] = scanner.nextLine();
            System.out.println(
                "Укажите критичность дефекта:" + "\nВысокий" + "\nСредний" + "\nНизкий");
            arrayPriority[index] = scanner.nextLine();
            System.out.println("Укажите ожидаемое количество дней на исправление дефекта:");
            arrayDays[index] = scanner.nextInt();
            scanner.nextLine();
            index++;
          } else {
            System.out.println("Вы добавили максимально-возможное количество дефектов.");
          }
          break;
        case "List":
          for (int indSearch = 0; indSearch < arraySize; indSearch++) {
            if (arrayResume[indSearch] != null) {
              System.out.println(
                  "Номер:" + indSearch + " Резюме: " + arrayResume[indSearch] + " Приоритет: "
                      + arrayPriority[indSearch] + " Дней на исправление: " + arrayDays[indSearch]
                      + "\n");
            } else if (arrayResume[indSearch] == null && indSearch != 0) {
              break;
            } else {
              System.out.println("Заведенные дефекты отсутствуют");
              break;
            }
          }
          break;
        case "Quit":
          System.out.println("GoodBye!");
          break;
        default:
          System.out.println("Введена неверная операция! Повторите попытку");
          break;
      }
    } while (!(operation.equalsIgnoreCase(goodBye)));

  }
}