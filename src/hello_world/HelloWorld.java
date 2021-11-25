package hello_world;

public class HelloWorld {

    public static void main(String[] args) {
        Apart apart = new Apart(12);
        apart.setPeople(12);
        apart.printCount();
        System.out.println();
        Seasons seasons = Seasons.valueOf("SPRING");

    }
}
