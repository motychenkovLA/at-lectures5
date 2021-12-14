package tracker;

import java.util.HashSet;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Set;

public class Main {
    private static final long NUM_BUG = 10;
    private static Repository repository = new Repository();
    private static Set<Transition> transitionsSet = new HashSet<>();
    private static Priority priority = null;
    private static Integer daysToFixed = null;
    private static String priorityString = null;
    private static long countReq = 0; // переменная для количества дефектов

    static {

        transitionsSet.add(new Transition(Status.OPEN, Status.INPROGRESS));
        transitionsSet.add(new Transition(Status.INPROGRESS, Status.TESTING));
        transitionsSet.add(new Transition(Status.TESTING, Status.CLOSE));
    }

    public static void main(String[] args) {
        boolean isRun = true; // переменная для бесконечного цикла

        try (Scanner scanner = new Scanner(System.in)) {
            while (isRun) {
                System.out.println(" Выберите действие " +
                        "\n Add (Новый дефект)" +
                        "\n List (Вывести список дефектов)" +
                        "\n Quit (Вернуться в главное меню)" +
                        "\n Change (Изменить дефект)"+
                        "\n Stat (Статистика по дефектам)")

                ;
                String action = scanner.nextLine();
                switch (action) {
                    case ("Add"): {
                        add(scanner, repository);
                        break;
                    }
                    case ("List"): {
                        list(repository);
                        break;
                    }
                    case ("Change"): {
                        change(scanner, repository, transitionsSet);
                        break;
                    }
                    case ("Quit"): {
                        isRun = false;
                        break;
                    }
                    case ("Stat"): {
                        System.out.println("Максимальное количество дней на исправление = " + repository.getMax());
                        System.out.println("Минимальное количество дней на исправление = " + repository.getMin());
                        System.out.println("Среднее количество дней на исправление = " + repository.getAvg());
                        System.out.println("|Статус OPEN |"  + repository.getTableStatusOpen()+ "|");
                        System.out.println("|Статус INPROGRESS |"  + repository.getTableStatusInprogress()+ "|");
                        System.out.println("|Статус TESTING |"  + repository.getTableStatusTesting()+ "|");
                        System.out.println("|Статус CLOSE |"  + repository.getTableStatusClose()+ "|");
                        break;
                    }

                    default: {
                        System.out.println("Операция не существует");
                        break;
                    }
                }
            }
        }
    }

    public static void list(Repository repository) {
        Defect[] defects = repository.getALL();
        for (int i = 0; i < repository.getCurrentDefectCount(); i++) {
            System.out.println(defects[i].getInfo());
        }
    }

    public static void change(Scanner scanner, Repository repository, Set<Transition> transitionsSet) {
        System.out.println("Введите id дефекта");
        long idChange = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Введите Статус дефекта : OPEN, INPROGRESS, TESTING, CLOSE");
        String statusString = scanner.nextLine().toUpperCase();
        Status status = Status.valueOf(statusString);

        Defect defect = repository.getDefectById(idChange); // возвращается весь дефект по айди
        Status statusOld = defect.getStatus();
        if (transitionsSet.contains(new Transition(statusOld, status))) {
            defect.setStatus(status);
        } else System.out.println("Недопустимый статус");


    }

    public static void add(Scanner scanner, Repository repository) {

        if (countReq > NUM_BUG - 1) {
            System.out.println("Невозможно добавить больше 10 дефектов");

        }
        System.out.println("Введите резюме дефекта:");
        String resume = scanner.nextLine();
        while (true) {
            System.out.println("Введите критичность дефекта (high, middle, low)");
            try {
                priorityString = scanner.nextLine().toUpperCase();
                priority = Priority.valueOf(priorityString);
                break;

            } catch (IllegalArgumentException a) {
                System.out.println("Некорректный ввод,попробуйте снова");
            }
        }

        while (true) {
            System.out.println("Введите ожидаемое количество дней на исправление дефекта:");
            try {
                daysToFixed = scanner.nextInt();
                scanner.nextLine();
                break;

            } catch (InputMismatchException b) {
                System.out.println("Некорректный ввод,попробуйте снова");
            }
        }

        System.out.println("Выберите тип вложения Комментарий или Ссылка на дефект, либо нажмите Enter");
        String kindOfAttachment = scanner.nextLine();

        Attachment attachment = new Attachment();
        switch (kindOfAttachment) {
            case ("Комментарий"): {
                System.out.println("Введите комментарий к дефекту");
                attachment = new CommentAttachment(scanner.nextLine());
                break;
            }
            case ("Ссылка на дефект"): {
                System.out.println("Введите Id связанного дефекта");
                attachment = new DefectAttachment(Long.parseLong(scanner.nextLine()));
                break;
            }
        }

        Status status = Status.valueOf("OPEN");
        Defect defect = new Defect(resume, priority, daysToFixed, status, attachment);
        repository.add(defect);
    }
}


