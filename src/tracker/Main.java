package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

  // todo 0 - 4 пробела отступ плз
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // todo 1 - CONSTANT_FORMAT
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
          // todo 3 - какой-то очень сложный цикл ещё и с тремя if-ами
          //   почему просто не перебрать дефекты до последнего заведенного?
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
    // todo 3 - дублирование проверки, которая делается в case;
    //   лучше ввести переменную вроде runProgram и менять ее в нужном case
    } while (!(operation.equalsIgnoreCase(goodBye)));

  }
}