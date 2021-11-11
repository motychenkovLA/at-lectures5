package tracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int MAX_SIZE = 10;
        final String PLAY_PROGRAM = "Выберете операцию:" + "\nAdd" + "\nList" + "\nQuit";
        boolean runProgram = true;
        Repository repository = new Repository(MAX_SIZE);
        while (runProgram) {
            System.out.println(PLAY_PROGRAM);
            String operation = scanner.nextLine();
            switch (operation) {
                case "Add":
                    if (!repository.isFull()) {
                        System.out.println("Введите резюме дефекта:");
                        String resume = scanner.nextLine();
                        System.out.println("Укажите критичность дефекта:" + "\nВысокий" + "\nСредний" + "\nНизкий");
                        String priority = scanner.nextLine();
                        System.out.println("Укажите ожидаемое количество дней на исправление дефекта:");
                        int days = scanner.nextInt();
                        scanner.nextLine();
                        Bug bug = new Bug(resume, priority, days);
                        repository.addBug(bug);
                    } else {
                        System.out.println("Вы добавили максимальное количество дефектов!");
                    }
                    break;
                case "List":
                    if (!repository.isEmpty()) {
                        Bug[] bug = repository.getBug();
                        // todo 1 - bug.length ?
                        int size = repository.getSize();
                        for (int i = 0; i < size; i++) {
                            System.out.println(bug[i].getBugInfo());
                        }
                    } else {
                        System.out.println("Вы не добавили ни одного дефекта!");
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