public class Main {
    public static void main(String[] args) {
        String ogrenci1 = "Nursel";
        String ogrenci2 = "Sezen";
        String ogrenci3 = "Zeki";
        String ogrenci4 = "Almina";

        System.out.println(ogrenci1);
        System.out.println(ogrenci2);
        System.out.println(ogrenci3);
        System.out.println(ogrenci4);

        System.out.println("-------------------");

        String[] ogrenciler = new String[4];
        ogrenciler[0] = "Nursel";
        ogrenciler[1] = "Sezen";
        ogrenciler[2] = "Zeki";
        ogrenciler[3] = "Almina";

        for (int i = 0; i < ogrenciler.length; i++) {
            System.out.println(ogrenciler[i]);
        }

        System.out.println("-------------------");

        for (String ogrenci : ogrenciler) {
            System.out.println(ogrenci);
        }
    }
}