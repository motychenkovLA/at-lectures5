package tracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final int MAX_DEFECTS = 3;
        Repository repository = new Repository(MAX_DEFECTS);
        boolean running = true;
        Scanner scan = new Scanner(System.in);

        while (running) {
            // Ввод команды
            System.out.println("Введите команду, чтобы:" + '\n' + '\t'
                    + "Добавить новый дефект: add" + '\n' + '\t'
                    + "Вывести список дефектов: list" + '\n' + '\t'
                    + "Изменить статус дефекта: change" + '\n' + '\t'
                    + "Выйти из программы: quit");
            System.out.print('\n' + "Введите команду: ");
            String command = scan.nextLine().toUpperCase();
            System.out.println();
            switch (command) {
                // Добавление дефекта
                case "ADD":
                    System.out.println();
                    if (!repository.isFull()) {

                        // Ввод резюме
                        System.out.print("Введите резюме дефекта: ");
                        String resume = scan.nextLine();

                        // Ввод критичности
                        System.out.println("Введите кричисность дефекта:" + '\n' + '\t'
                                + "- BLOCKER" + '\n' + '\t'
                                + "- CRITICAL" + '\n' + '\t'
                                + "- MAJOR" + '\n' + '\t'
                                + "- MINOR" + '\n' + '\t'
                                + "- TRIVIAL");

                        System.out.print("Критичность: ");
                        Severity severity = Severity.valueOf(scan.nextLine().toUpperCase());

                        // Ввод количества дней на исправление
                        System.out.print("Ожидаемое кол-во дней на исправление: ");
                        int daysToFix = scan.nextInt();
                        scan.nextLine();
                        System.out.println("Тип вложения:" + '\n' + '\t' + "- Комментарий" + '\n' + '\t' + "- Ссылка");
                        System.out.print("Тип вложения: ");
                        String typeOfAttachment = scan.nextLine().toUpperCase();

                        // Вложение к дефекту
                        Attachment attachment = new Attachment();
                        switch (typeOfAttachment){
                            case "КОММЕНТАРИЙ":
                                System.out.println();
                                System.out.print("Комментарий: ");
                                System.out.println();
                                attachment = new CommentAttachment(scan.nextLine());
                                break;

                            case "ССЫЛКА":
                                System.out.println();
                                System.out.print("Введите Id связанного дефекта: ");
                                System.out.println();
                                attachment = new DefectAttachment(Long.parseLong(scan.nextLine()));
                                break;
                        }
                        Defect defect = new Defect(resume,severity,daysToFix,attachment, Status.OPEN);
                        repository.addDefectInRepo(defect); // созданный дефект добавили в репозиторий
                    }else {
                        System.out.println("ВНИМАНИЕ!!! Достигнуто максимальное количество дефектов. Возврат в главное меню...");
                        System.out.println();
                    }
                    break;

                case "LIST":
                    System.out.println("Список дефектов:");
                    for (long i = 0; i < repository.getRepoIndex(); i++) {
                        System.out.println(repository.getAll()[Math.toIntExact(i)].getDefectInfo());
                    }
                    System.out.println();
                    break;

                // Изменение статуса дефекта
                case "CHANGE":
                    System.out.print("Введите Id дефекта: ");
                    long changingDefectId = scan.nextLong();
                    scan.nextLine();
                    System.out.println();
                    if (changingDefectId < repository.getRepoIndex()) {
                            try {
                                System.out.println("Введите новый статус:" + '\n' + '\t'
                                        + "- OPEN" + '\n' + '\t'
                                        + "- IN_PROGRESS" + '\n' + '\t'
                                        + "- TESTING" + '\n' + '\t'
                                        + "- CLOSED");
                                Status status = Status.valueOf(scan.nextLine().toUpperCase());
                                repository.getDefectById(changingDefectId).setStatus(status);
                                System.out.println("Статус дефекта изменен на " + status);
                            } catch (IllegalArgumentException e) {
                                System.out.println("Некорректное значение! Повторите ввод...");
                                continue;
                            }
                    }else {
                            System.out.println("Дефект не найден");
                        }break;

                case "QUIT":
                    running = false;
                    break;

                default:
                    System.out.println("Неверная команда! Повторите ввод...");
                    System.out.println();
                    break;
            }
        }
        scan.close(); // Закрыть сканнер
    }
}