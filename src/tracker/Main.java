package tracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int MAX_LONG = 10;
        String playProgram = "Выберете операцию:" + "\nAdd" + "\nList" + "\nQuit";
        String operation;
        boolean runProgram = true;
        int id = 0;
        Bug[] bugs = new Bug[MAX_LONG];
        while (runProgram){
            System.out.println(playProgram);
            operation = scanner.nextLine();
            switch (operation) {
                case "Add":
                    if (id < MAX_LONG) {
                        System.out.println("Введите резюме дефекта:");
                        String resume = scanner.nextLine();
                        System.out.println(
                                "Укажите критичность дефекта:" + "\nВысокий" + "\nСредний" + "\nНизкий");
                        String priority = scanner.nextLine();
                        System.out.println("Укажите ожидаемое количество дней на исправление дефекта:");
                        int days = scanner.nextInt();
                        scanner.nextLine();
                        Bug bug = new Bug(id, resume, priority, days);
                        bugs[id] = bug;
                        id++;
                    } else {
                        System.out.println("Вы добавили максимально-возможное количество дефектов.");
                    }
                    break;
                case "List":
                    for (int indSearch = 0; indSearch < id; indSearch++) {
                        System.out.println(bugs[indSearch].getBugList());
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
        }

    }
}