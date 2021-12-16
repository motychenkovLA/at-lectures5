package tracker;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    final static int MAX_DEFECTS = 10;
    static Repository repository = new Repository(MAX_DEFECTS);

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)){
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Выберите: Add/ Change/ List/ Stats/ Quit");
            String menu = scan.nextLine();
            switch (menu) {
                case ("Add"): {
                    add(scan);
                    break;
                }
                case ("List"): {
                    list();
                    break;
                }
                case ("Change"): {
                    change(scan);
                    break;
                }


                case ("Stats"): {
                    stats ();
                    break;
                }

                case ("Quit"):
                    isRunning = false;
                    System.out.println("До свидания!");
                    break;
                default: {
                    System.out.println("Такого пункта меню нет");
                    break;
                }

            }
        }
    }
}

    private static void add (Scanner scan) {
        if (!repository.isFull()) {
            System.out.println("Введите резюме дефекта:");
            String summary = scan.nextLine();

            System.out.println("Введите критичность дефекта (Low/ Medium/ High/ Highest):");
            String stringSeverity = scan.nextLine().toUpperCase();
            Critical critical = Critical.valueOf(stringSeverity);

            System.out.println("Введите ожидаемое количество дней на исправление:");
            int daysToFix = scan.nextInt();
            scan.nextLine();
            System.out.println("Выберите тип вложения: Комментарий/ Ссылка: ");
            String attachmentType = scan.nextLine();
            Attachment attachment = new Attachment();

            if (attachmentType.equals("Комментарий")) {
                System.out.println("Введите комментарий: ");
                attachment = new CommentAttachment(scan.nextLine());
            } else if (attachmentType.equals("Ссылка")) {
                System.out.println("Введите номер дефекта: ");
                long defectId = scan.nextInt();
                scan.nextLine();
                attachment = new DefectAttachment(defectId);
            } else {
                System.out.println("Такого типа вложения нет");
            }

            Defect defect = new Defect(summary,critical, daysToFix, attachment);
            repository.add(defect); // созданный дефект добавили в репозиторий
        } else {
            System.out.println("Достигнуто максимальное количество дефектов");
        }
    }

    private static void list () {
        for (Map.Entry<Long, Defect> privet: repository.getAll().entrySet()){
            System.out.println(privet.getValue().getInfo());
        }
    }


    private static void change (Scanner scan) {

        System.out.println("Введите id дефекта: ");
        long defId = scan.nextLong();
        scan.nextLine();

        if (defId < repository.getCurrentSize()) {

            while (true) {
                try {
                    Status oldStatus = repository.getDefectById(defId).getStatus();
                    System.out.println("Текущий статус: " + oldStatus+ "  " + "Введите новый статус: OPEN/ FIX/ TEST:");
                    Status newStatus = Status.valueOf(scan.nextLine().toUpperCase());
                    if (Transition.validTransitions(new Transition(oldStatus, newStatus))) {
                        repository.getDefectById(defId).setStatus(newStatus);
                        break;
                    }
                    else {
                        System.out.println("Не валидный статус");
                    }

                } catch (IllegalArgumentException e) {
                    System.out.println("Некорректная критичность, попробуйте ввести снова!");
                }
            }
            } else {
                System.out.println("Такого дефекта нет");
            }

    }

    private static void stats () {
        if (!repository.isEmpty()) {
            IntSummaryStatistics intSummaryStatistics = repository.getDefectList().stream().
                    mapToInt (Defect::getDaysToFix).summaryStatistics ();
            System.out.println("Количество дней для исправления дефекта:");
            System.out.println("Максимальное - " + intSummaryStatistics.getMax());
            System.out.println("Среднее - " + intSummaryStatistics.getAverage());
            System.out.println("Минимальное - " + intSummaryStatistics.getMin());
            System.out.println();
            Map <Status, List <Defect>> result = repository.getDefectList().stream().collect(Collectors.
                    groupingBy(Defect::getStatus));
            for (Status status : Status.values()) {
                if (result.containsKey(status)) {
                    System.out.println("Статус: " + status);
                    System.out.println("Количество дефектов:" + result.get(status).size());
                } else {
                    System.out.println("Статус:" + status);
                    System.out.println("Количество дефектов:" + 0);
                }
            }
        } else System.out.println("В системе нет дефектов");
        System.out.println();
    }
}
