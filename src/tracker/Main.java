package tracker;

import java.util.Scanner;

public class Main {

    final static int MAX_DEFECTS = 10;
    static Repository repository = new Repository(MAX_DEFECTS);

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)){
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Выберите: Add/ Change/ List/ Quit");
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
        for (int i = 0; i < repository.getCurrentSize(); i++) {
            System.out.println(repository.getAll()[i].getInfo());//вывод списка дефектов
        }
    }

    private static void change (Scanner scan) {
        System.out.println("Введите id дефекта: ");
        long defId = scan.nextLong();
        scan.nextLine();
        Status status = null;
        while (status == null) {
            try {
                System.out.println("Введите новый статус: OPEN/ FIX/ TEST:");
                String stringStatus = scan.nextLine().toUpperCase();
                status = Status.valueOf(stringStatus);
                repository.getDefectById(defId).setStatus(status);
            } catch (IllegalArgumentException e) {
                System.out.println("Некорректная критичность, попробуйте ввести снова!");
            }
        }
    }
}
