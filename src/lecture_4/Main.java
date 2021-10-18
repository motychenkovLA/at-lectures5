package lecture_4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int NUM_OF_BUGS = 10;

        Defect[] bugs = new Defect[NUM_OF_BUGS];

        int index = 0;
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("\n---Меню---");
            System.out.println("Добавить дефект: add");
            System.out.println("Вывести список дефектов: list");
            System.out.println("Выйти: exit");

            System.out.print("Введите команду: ");
            String action = scanner.nextLine();

            switch (action) {
                case "add":
                    if (index < NUM_OF_BUGS) {

                        System.out.println("\nДобавление дефекта");
                        System.out.print("Введите резюме дефекта: ");
                        String summary = scanner.nextLine();

                        System.out.print("Введите критичность дефекта: блокирующий, высокий, средний, низкий: ");
                        String priority = scanner.nextLine();

                        System.out.print("Введите количество дней на исправление дефекта: ");
                        int daysToFix = scanner.nextInt();
                        scanner.nextLine();

                        // todo 1 - каст в long избыточный здесь
                        Defect bug = new Defect((long) index, summary, priority, daysToFix);
                        bugs[index] = bug;

                        index++;

                    } else {
                        System.out.println("Ошибка: список полный, нельзя добавить дефект");
                    }
                    break;
                case "list":
                    if (index > 0) {
                        System.out.println("\nСписок дефектов");
                        for (int i = 0; i < index; i++) {
                            bugs[i].displayInfo();
                        }
                    } else {
                        System.out.println("Ошибка: список дефектов пуст");
                    }
                    break;
                case "exit":
                    loop = false;
                    break;
                default:
                    System.out.println("Ошибка: такой команды нет");
                    break;
            }
        }
    }
}
