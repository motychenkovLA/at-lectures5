package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int NUM_OF_BUGS = 10;

        String[] summaryBugs = new String[NUM_OF_BUGS];
        String[] priorityBugs = new String[NUM_OF_BUGS];
        int[] daysToFixBugs = new int[NUM_OF_BUGS];

        int index = 0;
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("\n---Меню---");
            System.out.println("Добавить дефект: add");
            System.out.println("Вывести список дефектов: list");
            System.out.println("Выйти: quit");

            System.out.print("Введите команду: ");
            String action = scanner.nextLine();

            switch (action) {
                case "add":
                    if (index < NUM_OF_BUGS) {

                        System.out.println("\nДобавление дефекта");
                        System.out.print("Введите резюме дефекта: ");
                        summaryBugs[index] = scanner.nextLine();

                        System.out.print("Введите критичность дефекта: блокирующий, высокий, средний, низкий: ");
                        priorityBugs[index] = scanner.nextLine();

                        System.out.print("Введите количество дней на исправление дефекта: ");
                        daysToFixBugs[index] = scanner.nextInt();
                        scanner.nextLine();

                        index++;

                    } else {
                        System.out.println("Ошибка: список полный, нельзя добавить дефект");
                    }
                    break;
                case "list":
                    if (index > 0) {
                        System.out.println("\nСписок дефектов");
                        for (int i = 0; i < index; i++) {
                            System.out.format(
                                    "Дефект: %d | Резюме: %s | Критичность: %s | Кол-во дней на исправление: %d",
                                    i, summaryBugs[i], priorityBugs[i], daysToFixBugs[i]);
                        }
                    } else {
                        System.out.println("Ошибка: список дефектов пуст");
                    }
                    break;
                case "quit":
                    loop = false;
                    break;
                default:
                    System.out.println("Ошибка: такой команды нет");
                    break;
            }
        }
    }
}
