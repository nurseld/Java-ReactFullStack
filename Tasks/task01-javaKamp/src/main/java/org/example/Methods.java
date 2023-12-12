package org.example;

public class Methods {
    public static void main(String[] args) {

        mesajVer("Nursel");
        mesajVer("Almina");

        hesapla();
        System.out.println(topla(6,3));
        System.out.println(toplananIkiSayininYuzdesi(10,90));
        topla(5,3);
        topla(9,8);
    }

    public static void mesajVer(String name){
        System.out.println("Merhaba " + name);
    }
    public static void hesapla(){
        System.out.println("Hesaplandı");
    }

    public static int topla(int sayi1, int sayi2) {

        int toplam = sayi1 + sayi2;
        return toplam;

    }

    //toplanan iki sayının %10 bul
    public static double toplananIkiSayininYuzdesi(int sayi1, int sayi2) {

        int toplam =topla(sayi1,sayi2);
        double sonuc = toplam * 10/100;
        return sonuc;

    }

    public static double krediHesapla(double krediMiktari) {
        //hesaplar yapılır...
        return 125000;

    }
}
