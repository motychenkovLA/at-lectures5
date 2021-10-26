package tracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // todo 0 - почему long, если она int, и вообще это скорее MAX_BUG_COUNT - исправила на MAX_SIZE
        final int MAX_SIZE = 10;
        // todo 1 - это тогда тоже константа - исправила
        final String PLAY_PROGRAM = "Выберете операцию:" + "\nAdd" + "\nList" + "\nQuit";
        // todo 1 - инициализируется 6 строками ниже, почему не объявить там - исправила
        boolean runProgram = true;
        int id = 0;
        Bug[] bugs = new Bug[MAX_SIZE];
        while (runProgram){
            System.out.println(PLAY_PROGRAM);
            String operation = scanner.nextLine();
            switch (operation) {
                case "Add":
                    if (id < MAX_SIZE) {
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
                    // todo 1 - тут в принципе можно indSearch просто i назвать, в простых циклах обычно так именуют - исправила
                    for (int i = 0; i < id; i++) {
                        System.out.println(bugs[i].getBugInfo());
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