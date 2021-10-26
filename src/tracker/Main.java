package tracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // todo 0 - почему long, если она int, и вообще это скорее MAX_BUG_COUNT
        final int MAX_LONG = 10;
        // todo 1 - это тогда тоже константа
        String playProgram = "Выберете операцию:" + "\nAdd" + "\nList" + "\nQuit";
        // todo 1 - инициализируется 6 строками ниже, почему не объявить там
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
                    // todo 1 - тут в принципе можно indSearch просто i назвать, в простых циклах обычно так именуют
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