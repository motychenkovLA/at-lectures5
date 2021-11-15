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
                        System.out.println("Какое вложение необходимо добавить?" + "\nComment" + "\nLink");
                        String attach = scanner.nextLine();
                        switch (attach) {
                            case "Comment":
                                String comment = scanner.nextLine();
                                CommentAttach commentAttach = new CommentAttach(comment);
                                bug.setAttachment(commentAttach);
                                break;
                            case "Link":
                                String linkBug = scanner.nextLine();
                                if (repository.getBugId(linkBug) != null) {
                                    BugAttach bugAttach = new BugAttach(linkBug);
                                    bug.setAttachment(bugAttach);
                                } else {
                                    System.out.println("Такого дефекта не заведено в системе!");
                                }
                                break;
                        }

                    } else {
                        System.out.println("Вы добавили максимальное количество дефектов!");
                    }
                    break;
                case "List":
                    if (!repository.isEmpty()) {
                        Bug[] bug = repository.getBugs();
                        // todo 1 - bug.length ? - исправила
                        for (int i = 0; i < bug.length; i++) {
                            System.out.println(bug[i]);
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