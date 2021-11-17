package tracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int MAX_SIZE = 10;
        final String PLAY_PROGRAM = "Выберете операцию:" + "\nAdd" + "\nList" + "\nChange" + "\nQuit";
        boolean runProgram = true;
        Repository repository = new Repository(MAX_SIZE);
        while (runProgram) {
            System.out.println(PLAY_PROGRAM);
            String operation = scanner.nextLine();
            switch (operation) {
                case "Add":
                    add(repository, scanner);
                    break;
                case "List":
                    list(repository);
                    break;
                case "Change":
                    change(repository, scanner);
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

    public static void add(Repository repository, Scanner scanner) {
        // todo 1 - if (полный) {вывеси ошибку; return;} весь остальной код вне скобок
        if (!repository.isFull()) {
            System.out.println("Введите резюме дефекта:");
            String resume = scanner.nextLine();
            System.out.println("Укажите ожидаемое количество дней на исправление дефекта:");
            // todo 1 - лучше тогда отдельный метод который будет делать nextInt+nextLine сразу чтоб каждый раз не писать
            int days = scanner.nextInt();
            scanner.nextLine();
            Bug bug = new Bug(resume, days);
            repository.addBug(bug);
            // (todo ? - под ввод вложения можно выделить отдельный метод)
            // (todo ? - и можно там уже организовать цикл, чтобы наверняка норм значения были введены)
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

    }

    public static void list(Repository repository) {
        // todo 1 - if (нету) {вывеси ошибку; return;} весь остальной код вне скобок
        if (!repository.isEmpty()) {
            Bug[] bug = repository.getBugs();
            // todo 1 - warning
            for (int i = 0; i < bug.length; i++) {
                System.out.println(bug[i]);
            }
        } else {
            System.out.println("Вы не добавили ни одного дефекта!");
        }
    }

    public static void change(Repository repository, Scanner scanner) {
        System.out.println("Статус какого дефекта необходимо обновить?");
        String statusBug = scanner.nextLine();
        Bug bug = repository.getBugId(statusBug);
        // todo 1 - if (нету) {вывеси ошибку; return;} весь остальной код вне скобок
        if (bug != null) {
            // (todo ? - тут можно в цикле просить пока норм статус не введут)
            System.out.println("Укажите новый статус дефекта:" + "\nWORK - в работе" + "\nREJECTED - отклонен" + "\nSOLUTION - Решен" + "\nIRRELEVANT - неактуален");
            String status = scanner.nextLine();
            Status change = Status.fromValue(status);
            if (change != null) {
                bug.setStatus(change);
            } else {
                System.out.println("Вы ввели неверный статус!");
            }
        } else {
            System.out.println("Такого дефекта не заведено в системе!");
        }
    }

}