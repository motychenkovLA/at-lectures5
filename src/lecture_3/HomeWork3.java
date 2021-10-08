package lecture_3;

import java.util.Scanner;

public class HomeWork3 {
    public static void main(String[] args) {

        final int NUM_OF_BUGS = 3;

        String[] summaryBugs = new String[NUM_OF_BUGS];
        String[] priorityBugs = new String[NUM_OF_BUGS];
        int[] daysToFixBugs = new int[NUM_OF_BUGS];

        // todo 1 - сейчас индекс указывает на [последний добавленный элемент],
        //  поэтому приходится при добавлении увеличить на 1 до проверки на заполненность,
        //  уменьшать на 1 если проверка не пройдена,
        //  и в выводе на консоль использовать <= , хотя как правило пишут < .
        //  ;
        //  Если заменить на [следующий добавляемый элемент], т.е. начинать с 0,
        //  можно будет проверять заполненность не трогая счетчик,
        //  увеличивать счетчик только после самого добавления,
        //  не изменять больше нигде
        //  и при выводе использовать < .
        //  При этом index будет хранить именно текущее количество дефектов.
        int index = -1;
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop){
            System.out.println("\n---Меню---");
            System.out.println("Добавить дефект: add");
            System.out.println("Вывести список дефектов: list");
            System.out.println("Выйти: quit");

            System.out.print("Введите команду: ");
            String action = scanner.nextLine();

            switch (action){
                case "add":
                    index++;
                    if (index < NUM_OF_BUGS){

                        System.out.println("\nДобавление дефекта");
                        System.out.print("Введите резюме дефекта: ");
                        summaryBugs[index] = scanner.nextLine();

                        System.out.print("Введите критичность дефекта: блокирующий, высокий, средний, низкий: ");
                        priorityBugs[index] = scanner.nextLine();

                        System.out.print("Введите количество дней на исправление дефекта: ");
                        daysToFixBugs[index] = scanner.nextInt();
                        scanner.nextLine();
                    } else {
                        System.out.println("Ошибка: список полный, нельзя добавить дефект");
                        index--; //уменьшаем, чтобы при выводе полностью заполненного массива не получить ошибку выхода за границы
                    }
                    break;
                case "list":
                    if (index >= 0){
                        System.out.println("\nСписок дефектов");
                        for (int i = 0; i<=index; i++){
                            // todo 1 - всё ещё вылезает за экран, можно перенести в формате
                            //  а(
                            //      s,
                            //      x, y, z
                            //  );
                            //  + System.out.format объединяет сразу sout и format
                            System.out.println(String.format("Дефект: %d | Резюме: %s | Критичность: %s | Кол-во дней на исправление: %d",
                                                                    i, summaryBugs[i], priorityBugs[i], daysToFixBugs[i]));
                        }
                    } else {
                        System.out.println("Ошибка: список дефектов пуст");
                    }
                    break;
                case "quit":
                   // System.exit(0); // todo 0 - закомменченный код лучше не оставлять в коммитах
                    loop = false;
                    break;
                default:
                    System.out.println("Ошибка: такой команды нет");
                    break;
            }

        }
    }
}
