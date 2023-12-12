package org.example;

public class Loops {
    public static void main(String[] args) {

        String urun = "Laptop";
        for (int i = 0; i < 10; i++) {
            System.out.println(urun + i);

        }

        for (int i = 0; i < 10; i++) {
            System.out.println(i);

        }

        int sayi = 10;
        while (sayi <= 100){
            System.out.println(sayi);
            sayi += 10;
        }

        int sayi2 = 11;
        do{
            System.out.println(sayi2);
            sayi2 += 10;
        }while (sayi2 > 100);
    }
}
