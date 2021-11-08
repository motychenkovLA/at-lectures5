package tracker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int NUM_BUG = 10;
        //  Defect[] defects = new Defect[NUM_BUG];
        Repository repository = new Repository(NUM_BUG);


        long countReq = 0; // переменная для количества дефектов
        
        boolean isRun = true; // переменная для бесконечного цикла

        while (isRun) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(" Выберите действие Add (Новый дефект)" +
                    " List (Вывести список дефектов)" +
                    " Quit (Вернуться в главное меню)");
            String action = scanner.nextLine();
            switch (action) {
                case ("Add"): {


                    if (countReq > NUM_BUG - 1) {
                        System.out.println("Невозможно добавить больше 10 дефектов");

                        break;
                    }
                    System.out.println("Введите резюме дефекта:");
                    String resume = scanner.nextLine();

                    System.out.println("Введите критичность дефекта (Высокий, Средний, Низкий ):");
                    String priority = scanner.nextLine();

                    System.out.println("Введите ожидаемое количество дней на исправление дефекта:");
                    int daysToFixed = scanner.nextInt();
                    scanner.nextLine();

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
                            attachment  = new DefectAttachment(Long.parseLong(scanner.nextLine()));
                             break;
                        }
                    }


                    Defect defect = new Defect(resume, priority, daysToFixed, attachment);


                    repository.add(defect);

                    //defects[(int) countReq] = bug;
                    // countReq = countReq + 1;
                    break;
                }
                case ("List"): {

                    Defect[] defects = repository.getALL();
                    for (int i = 0; i < repository.getCurrentDefectCount(); i++) {

                        System.out.println(defects[i].getInfo());
                    }



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
