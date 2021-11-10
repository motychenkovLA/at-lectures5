package tracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int MAX_SIZE = 10;
        final String PLAY_PROGRAM = "Выберете операцию:" + "\nAdd" + "\nList" + "\nQuit";
        boolean runProgram = true;
        Repository repository = new Repository(MAX_SIZE);
        while (runProgram){
            System.out.println(PLAY_PROGRAM);
            String operation = scanner.nextLine();
            switch (operation) {
                case "Add":
                        System.out.println("Введите резюме дефекта:");
                        String resume = scanner.nextLine();
                        System.out.println("Укажите критичность дефекта:" + "\nВысокий" + "\nСредний" + "\nНизкий");
                        String priority = scanner.nextLine();
                        System.out.println("Укажите ожидаемое количество дней на исправление дефекта:");
                        int days = scanner.nextInt();
                        scanner.nextLine();
                        repository.addBug(resume, priority, days);
                    break;
                case "List":
                    repository.getInfo();
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