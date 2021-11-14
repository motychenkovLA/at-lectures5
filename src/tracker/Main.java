// Илья Осин
// Задание 4

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
            System.out.println("Введите команду, чтобы:" + '\n' + '\t' + "Добавить новый дефект: add" + '\n' + '\t' + "Вывести список дефектов: list" + '\n' + '\t' + "Выйти из программы: quit");
            System.out.print('\n' + "Введите команду: ");
            String command = scan.nextLine();
            System.out.println();
            switch (command) {
                // Добавление дефекта
                case "add":
                    System.out.println();
                    if (!repository.filled()) {
                        // Ввод резюме
                        System.out.print("Введите резюме дефекта: ");
                        String resume = scan.nextLine();

                        // Ввод критичности
                        System.out.println("Введите кричисность дефекта:" + '\n' + '\t' + "- Blocker" + '\n' + '\t' + "- Critical" + '\n' + '\t' + "- Major" + '\n' + '\t' + "- Minor" + '\n' + '\t' + "- Trivial");
                        System.out.print("Критичность: ");
                        String severity = scan.nextLine();

                        // Ввод количества дней на исправление
                        System.out.print("Ожидаемое кол-во дней на исправление: ");
                        int daysToFix = scan.nextInt();
                        scan.nextLine();
                        System.out.println("Тип вложения:" + '\n' + '\t' + "- Комментарий" + '\n' + '\t' + "- Ссылка");
                        System.out.print("Тип вложения: ");
                        String typeOfAttachment = scan.nextLine();

                        // Вложение к дефекту
                        Attachment attachment = new Attachment();
                        switch (typeOfAttachment){
                            case "Комментарий":
                                System.out.println();
                                System.out.print("Комментарий: ");
                                System.out.println();
                                attachment = new CommentAttachment(scan.nextLine());
                                break;

                            case "Ссылка":
                                System.out.println();
                                System.out.print("Введите Id связанного дефекта: ");
                                System.out.println();
                                attachment = new DefectAttachment(Long.parseLong(scan.nextLine()));
                                break;
                        }
                        Defect defect = new Defect(resume,severity,daysToFix,attachment);
                        repository.addDefectInRepo(defect); // созданный дефект добавили в репозиторий
                    }else {
                        System.out.println("ВНИМАНИЕ!!! Достигнуто максимальное количество дефектов. Возврат в главное меню...");
                        System.out.println();
                    }
                    break;

                case "list":
                    System.out.println("Список дефектов:");
                    for (int i = 0; i < repository.getRepoIndex(); i++) {
                        System.out.println(repository.getAll()[i].getDefectInfo());
                    }
                    System.out.println();
                    break;

                case "quit":
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