package lecture_3;

import java.util.Scanner;

public class HomeWork3 {
    public static void main(String[] args) {

        final int NUM_OF_BUGS = 10;

        String[] bugs = new String[NUM_OF_BUGS];
        int index = -1;
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("\n---Меню---");
            System.out.println("Добавить дефект: add");
            System.out.println("Вывести список дефектов: list");
            System.out.println("Выйти: quite");

            System.out.print("Введите команду: ");
            String action = scanner.nextLine();

            switch (action){
                case "add":
                    index++;
                    if (index < NUM_OF_BUGS){

                        System.out.println("\nДобавление дефекта");
                        System.out.print("Введите резюме дефекта: ");
                        String summary = scanner.nextLine();

                        System.out.print("Введите критичность дефекта: блокирующий, высокий, средний, низкий: ");
                        String priority = scanner.nextLine();

                        System.out.print("Введите количество дней на исправление дефекта: ");
                        int daysToFix = scanner.nextInt();
                        scanner.nextLine();

                        bugs[index] = String.format("Дефект: %d | Резюме: %s | Критичность: %s | Кол-во дней на исправление: %d", index, summary, priority, daysToFix);

                    } else System.out.println("Ошибка, список полный, нельзя добавить дефект");
                    break;
                case "list":
                    if (index >= 0){
                        System.out.println("\nСписок дефектов");
                        for (String element: bugs) {
                           if (element != null) System.out.println(element);
                        }
                    } else System.out.println("Ошибка, список дефектов пуст");
                    break;
                case "quite":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Ошибка, такой команды нет");
                    break;
            }

        }
    }
}
