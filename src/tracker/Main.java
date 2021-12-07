package tracker;

import java.util.*;

import static tracker.Transition.statusList;

public class Main {
    static Repository repository = new Repository();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
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
                    "- Вывести статистику по дефектам (введите stats)\n" +
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
                    changeStatus(scanner);
                    break;
                case "stats":
                    stats();
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
        if (repository.isEmpty()) {
            System.out.println("Введите комментарий к дефекту:");
            String comment = scanner.nextLine();
            return new CommentAttachment(comment);
        } else {
            System.out.println("Выберите тип вложения - комментарий (comment) или ссылка на вложение (link)");

            while (true) {
                String attachmentType = scanner.nextLine();
                switch (attachmentType) {
                    case ("comment"):
                        System.out.println("Введите комментарий к дефекту:");
                        String comment = scanner.nextLine();
                        return new CommentAttachment(comment);
                    case ("link"):
                        int defectLink;
                        while (true) {
                            System.out.println("Введите номер дефекта:");
                            if ((checkID(defectLink = scanInt(scanner)))) {
                                return new DefectAttachment(defectLink);
                            }
                        }

                    default:
                        System.out.println('\n' + "Введите значение из списка - comment или link");
                        break;
                }
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

    public static void changeStatus(Scanner scanner) {
        if (repository.isEmpty()) {
            System.out.println("Список пуст");
            return;
        }

        Defect defect;

        while (true) {
            System.out.println("Введите id дефекта");
            int defectToChange = scanInt(scanner);
            if (checkID(defectToChange)) {
                defect = repository.getDefect(defectToChange);
                break;
            }
        }
        Status status = defect.getStatus();
        List<Status> statusList = statusList(status);

        System.out.println("Текущий статус дефекта - " + status);
        System.out.println("Введите новый статус дефекта. Доступные статусы - " + statusList.toString().replace("[", "").replace("]", ""));

        defect.setStatus(getStatus(scanner, statusList));
        System.out.println("Статус дефекта изменен на - " + defect.getStatus());
        System.out.println("====================================");
    }

    private static boolean checkID(long i) {
        if (!repository.containsId(i)) {
            System.out.println("Дефект с таким id отсутствует");
            return false;
        }
        return true;
    }

    public static Status getStatus(Scanner scanner, List<Status> statusList) {
        while (true) {
            String newStatus = scanner.nextLine();
            if (Status.checkStatus(newStatus) && statusList.contains(Status.fromString(newStatus))) {
                return Status.fromString(newStatus);
            } else {
                System.out.println("Введите значение из списка");
            }
        }
    }

    public static int scanInt(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Введите число");
            }
        }
    }

    public static void stats() {
        if (repository.isEmpty()) {
            System.out.println("Список пуст");
            return;
        }

        System.out.println("Максимальное количество дней - " + repository.maxDay());
        System.out.println("Среднее количество дней - " + repository.averageDay());
        System.out.println("Минимальное количество дней - " + repository.minDay());

        for (Map.Entry<String, Long> entry : repository.defectStats().entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();
            System.out.println(key + " - " + value);
        }
    }
}