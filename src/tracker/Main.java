package tracker;

import com.sun.istack.internal.NotNull;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int COUNT_BUGS = 10;
    static Repository repository = new Repository(COUNT_BUGS);


    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);) {
            menu(scanner);
        } catch (IllegalArgumentException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public static void menu(Scanner scanner) {
        while (true) {
            System.out.println('\n' + "Выберите, что хотите сделать:\n" +
                    "- Добавить новый дефект (введите add)\n" +
                    "- Вывести список дефектов (введите list)\n" +
                    "- Изменить дефект (введите change)\n" +
                    "- Выйти из программы (введите quit)");
            String result = scanner.nextLine();

            switch (result) {
                case "add":
                    add(scanner);
                    break;
                case "list":
                    list();
                    break;
                case "change":
                    change(scanner);
                    break;
                case "quit":
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println('\n' + "Введите значение из списка");
                    break;
            }
        }
    }

    public static void add(Scanner scanner) {

        if (repository.isFull()) {
            System.out.println('\n' + "Невозможно добавить больше дефектов");
            return;
        }

        System.out.println("Введите резюме дефекта:");
        String resume = scanner.nextLine();

        Critical critical = addCritical(scanner);

        System.out.println("Введите ожидаемо количество дней на исправление:");
        int countDays = scanInt(scanner);

        Attachment attachment = addAttachment(scanner);

        Defect defect = new Defect(resume, critical, countDays, attachment);
        repository.add(defect);

        System.out.println("===================================");
    }

    public static Critical addCritical(Scanner scanner) {
        System.out.println("Введите критичность дефекта - Низкий, Средний, Высокий, Блокер");

        while (true) {
            String critic = scanner.nextLine();
            if (Critical.checkCritical(critic)) {
                return Critical.fromString(critic);
            } else {
                System.out.println("Введите значение из списка");
            }
        }
    }

    public static Attachment addAttachment(Scanner scanner) {
        System.out.println("Выберите тип вложения - комментарий (comment) или ссылка на вложение (link)");

        while (true) {
            String attachmentType = scanner.nextLine();
            switch (attachmentType) {
                case ("comment"):
                    System.out.println("Введите комментарий к дефекту:");
                    String comment = scanner.nextLine();
                    return new CommentAttachment(comment);
                case ("link"):
                    System.out.println("Введите номер дефекта:");
                    // todo 1 - тут неплохо бы тоже проверять что id валидный, как в change
                    //   ввод id тогда есть смысл вынести в отдельный метод
                    int defectLink = scanInt(scanner);
                    return new DefectAttachment(defectLink);
                default:
                    System.out.println('\n' + "Введите значение из списка - comment или link");
                    break;
            }
        }
    }

    public static void list() {
        if (repository.isEmpty()) {
            System.out.println("Список пуст");
            return;
        }
        for (Defect def : repository.getAll()) {
            System.out.println(def.toString());
        }
        System.out.println("===================================");
    }

    public static void change(Scanner scanner) {
        if (repository.isEmpty()) {
            System.out.println("Список пуст");
            return;
        }
        Defect defect;
        System.out.println("Введите id дефекта");
        int defectToChange;
        while (true) {
            defectToChange = scanInt(scanner);
            if (!repository.containsId(defectToChange)) {
                System.out.println("Дефект с таким id отсутствует");
            } else break;
        }

        defect = repository.getDefect(defectToChange);

        System.out.println("Текущий статус дефекта - " + defect.getStatus());
        System.out.println("Введите новый статус дефекта - Открыт, В работе, В тестировании, Переоткрыт, Дубль, Закрыт");

        defect.setStatus(getStatus(scanner));
        System.out.println("Статус дефекта изменен на - " + defect.getStatus());
        System.out.println("====================================");
    }

    public static Status getStatus(Scanner scanner) {
        while (true) {
            String newStatus = scanner.nextLine();
            if (Status.checkStatus(newStatus)) {
                return Status.fromString(newStatus);
            } else {
                System.out.println("Введите значение из списка");
            }
        }
    }

    // todo 1 - тут 2 раза парсится инт из строки (в scanInt и isDigit)
    //   isDigit нигде больше не используется
    //   саму логику по парсу-отлову можно целиком сюда перенести
    public static int scanInt(Scanner scanner) {
        while (true) {
            String s = scanner.nextLine();
            if (isDigit(s)) {
                return Integer.parseInt(s);
            } else {
                System.out.println("Введите число");
            }
        }
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}