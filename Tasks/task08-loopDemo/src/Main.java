public class Main {
    public static void main(String[] args) {
        // for
        for (int i = 1; i < 10; i += 2) {
            System.out.println(i);
        }
        System.out.println("For Döngüsü Bitti");

        // while
        int i = 0;
        while (i < 10) {
            System.out.println(i);
            i += 2;
        }
        System.out.println("While Döngüsü Bitti");

        // do-while
        int j = 100;
        do {
            System.out.println(j);
            j++;
        } while (j < 10);
        System.out.println("Do-While Döngüsü Bitti");
    }
}