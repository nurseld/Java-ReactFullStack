public class Main {
    public static void main(String[] args) {

        sayiBulmaca();

    }

    public static void sayiBulmaca() {

        int[] sayilar = new int[]{1, 2, 5, 7, 9, 0};
        int aranacak = 6;
        boolean varMi = false;

        for (int sayi : sayilar) {
            if (sayi == aranacak) {
                varMi = true;
                break;
            }
        }

        String mesaj = "";
        String mesaj2 = "";
        if (varMi) {
            mesaj = "Sayı mevcuttur : " + aranacak;
            mesajVer(mesaj);
        } else {
            mesaj2 = "Sayı mevcut değildir : " + aranacak;
            mesajVer(mesaj2);
        }
    }

    public static void mesajVer(String message) {
        System.out.println(message);
    }
}