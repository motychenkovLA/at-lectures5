package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    // todo 0 - 4 пробела отступ плз - сделала
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // todo 1 - CONSTANT_FORMAT - исправила
        final int ARRAY_SIZE = 10;
        String[] arrayResume = new String[ARRAY_SIZE];
        String[] arrayPriority = new String[ARRAY_SIZE];
        int[] arrayDays = new int[ARRAY_SIZE];
        String playProgram = "Выберете операцию:" + "\nAdd" + "\nList" + "\nQuit";
        String operation;
        boolean runProgram = true;
        String goodBye = "Quit";
        int index = 0;
        while (runProgram){
            System.out.println(playProgram);
            operation = scanner.nextLine();
            switch (operation) {
                case "Add":
                    if (index < ARRAY_SIZE) {
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
                    //   почему просто не перебрать дефекты до последнего заведенного? - исправлено
                    for (int indSearch = 0; indSearch < index; indSearch++) {
                        System.out.println(
                                "Номер:" + indSearch + " Резюме: " + arrayResume[indSearch] + " Приоритет: "
                                        + arrayPriority[indSearch] + " Дней на исправление: " + arrayDays[indSearch]
                                        + "\n");
                    }
                    break;
                case "Quit":
                    System.out.println("GoodBye!");
                    runProgram = false;
                    break;
                default:
                    System.out.println("Введена неверная операция! Повторите попытку");
                    break;
            }
            // todo 3 - дублирование проверки, которая делается в case;
            //   лучше ввести переменную вроде runProgram и менять ее в нужном case - не понимаю что не так? - исправлено
        }

    }
}