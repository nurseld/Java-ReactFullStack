package org.example.Task3_characterCounts;

import java.util.Scanner;

public class CharacterCounts {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a word:");
        String input = scanner.nextLine();

        char[] charList = input.toCharArray();

        // Her karakteri ayrı bir string olarak saklayacak bir dizi oluştur
        String[] stringArray = new String[charList.length];

        for (int i = 0; i < charList.length; i++) {
            stringArray[i] = String.valueOf(charList[i]);
        }

        // Elemanları karşılaştırıp saymak için bir döngü kullan
        for (int i = 0; i < stringArray.length; i++) {
            int count = 0;

            // Eğer bu karakter daha önce işlendiyse, tekrar işleme
            if (stringArray[i] == null) {
                continue;
            }

            for (int j = i; j < stringArray.length; j++) {
                if (stringArray[i].equals(stringArray[j])) {
                    count++;
                    // İkinci kez gösterilmemesi için diğer işlenen karakterleri null yap
                    if (i != j) {
                        stringArray[j] = null;
                    }
                }
            }

            System.out.println("Karakter: " + stringArray[i] + ", Sayısı: " + count);
        }
    }
}