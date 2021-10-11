package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

  // todo 0 - 4 пробела отступ плз
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // todo 3 - в памяти хранится не дефект, а его консольное представление
    //  лучше сделать по массиву на каждое поле дефекта
    // todo 3 - 10 это константа
    // todo 1 - используется _ в названии
    String[] array_bugs = new String[10];
    String playProgram = "Выберете операцию:" + "\n1 - Add" + "\n2 - List" + "\n3 - Quit";
    int operation;
    // todo 0 - что значит "i" ?
    int i = 0;
    do {
      System.out.println(playProgram);
      operation = scanner.nextInt();
      scanner.nextLine();
      switch (operation) {
        // todo ? - возможно лучше все таки словами
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
          // todo 3 - выводятся null-ы в незаполненных ячейках, нужно выводить только те дефекты что есть
          System.out.println(Arrays.toString(array_bugs));
          break;
        case 3:
          System.out.println("GoodBye!");
          break;
        default:
          System.out.println("Введена неверная операция! Повторите попытку");
          // todo 3 - break;
      }
      // todo 1 - } while (...); - на одной строке
      // todo 3 - дублирование проверки, которая делается в case;
      //   лучше ввести переменную вроде runProgram и менять ее в нужном case
    }
    while ((operation != 3));
  }
}