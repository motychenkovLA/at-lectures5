package lecture_3;

import java.util.Scanner;

public class HomeWork3 {
    public static void main(String[] args) {

        final int NUM_OF_BUGS = 3;

        // todo 3 - в памяти хранится не дефект, а его консольное представление
        //  лучше по массиву на каждое поле
        String[] summaryBugs = new String[NUM_OF_BUGS];
        String[] priorityBugs = new String[NUM_OF_BUGS];
        int[] daysToFixBugs = new int[NUM_OF_BUGS];


        int index = -1;
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop){
            System.out.println("\n---Меню---");
            System.out.println("Добавить дефект: add");
            System.out.println("Вывести список дефектов: list");
            System.out.println("Выйти: quit"); // todo 0 - это quit же ?

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

                        // todo 1 - длинная строчка, вылезает за экран, лучше перенести
                      //

                        // todo 0 - обычно принято обе ветки if-а писать в одном стиле, независим от размера
                        //  если первая в скобках то вторую тоже лучше в них обернуть
                    } else {
                        System.out.println("Ошибка: список полный, нельзя добавить дефект");
                        index--; //уменьшаем, чтобы при выводе полностью заполненного массива не получить ошибку выхода за границы
                    }
                    break;
                case "list":
                    if (index >= 0){
                        System.out.println("\nСписок дефектов");
                        // todo 3 - уже есть index указывающий текущее количество дефектов
                        //  перебирать список целиком, проверяя есть ли дефект, - лишняя работа

                        for (int i = 0; i<=index; i++){
                            System.out.println(String.format("Дефект: %d | Резюме: %s | Критичность: %s | Кол-во дней на исправление: %d",
                                                                    i, summaryBugs[i], priorityBugs[i], daysToFixBugs[i]));
                        }
                    } else {
                        System.out.println("Ошибка: список дефектов пуст");
                    }
                    break;
                case "quit":
                    // todo ? - это верно и работает,
                    //  но хотелось бы чтоб цикл прерывался и просто поток выполнения выходил из main
                   // System.exit(0);
                    loop = false;
                    break;
                default:
                    System.out.println("Ошибка: такой команды нет");
                    break;
            }

        }
    }
}
