package tracker;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    private static final long NUM_BUG = 10;
    //  Defect[] defects = new Defect[NUM_BUG];
    private static Repository repository = new Repository();
    private static Transition transition = new Transition();

    private static Priority priority = null;
    private static Integer daysToFixed = null;
    private static String priorityString = null;
    private static long countReq = 0; // переменная для количества дефектов

    public static void main(String[] args) {
        boolean isRun = true; // переменная для бесконечного цикла
        transition.initSet();
        try (Scanner scanner = new Scanner(System.in)) {
            while (isRun) {
                System.out.println(" Выберите действие " +
                        "\n Add (Новый дефект)" +
                        "\n List (Вывести список дефектов)" +
                        "\n Quit (Вернуться в главное меню)" +
                        "\n Change (Изменить дефект)");
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
                        change(scanner, repository);
                        break;
                    }
                    case ("Quit"): {
                        isRun = false;
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

    public static void change(Scanner scanner, Repository repository) {
        System.out.println("Введите id дефекта");
        long idChange = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Введите Статус дефекта : OPEN, INPROGRESS, TESTING, CLOSE");
        String statusString = scanner.nextLine().toUpperCase();
        Status status = Status.valueOf(statusString);
        //transition.setStringSet(statusString);

        Defect defect = repository.getDefectById(idChange); // возвращается весь дефект по айди
        Status statusOld = defect.getStatus();
        switch (statusOld.toString()){
            case ("OPEN"):
                boolean isChek = transition.checkSet(status.toString());
                if (isChek) {
                    defect.setStatus(status);
            } else System.out.println("Недопустимый статус");

            break;

            default:
                defect.setStatus(status);
            }
        }
        public static void add(Scanner scanner, Repository repository){

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


