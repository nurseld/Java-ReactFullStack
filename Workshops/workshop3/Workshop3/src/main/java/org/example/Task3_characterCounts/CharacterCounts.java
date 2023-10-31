package org.example.Task3_characterCounts;

import java.util.Arrays;
import java.util.Scanner;

public class CharacterCounts {
    public static void main(String[] args) {

        // A Java program that gives character counts in a string (Ex: Tobeto -> t:2, o:2, b:1, e:1)
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a word:");
        String word = scanner.nextLine();


        word = word.toLowerCase(); // Reassign the lowercase value back to 'metin'
        int counter = 0;

        char[] wordToChar = word.toCharArray();
        Arrays.sort(wordToChar);

        for (int i = 0; i < wordToChar.length; i++) {
            counter = 0;
            if (i == 0 || wordToChar[i] != wordToChar[i - 1]) {
                for (int j = i; j < wordToChar.length; j++) {
                    if (wordToChar[i] == wordToChar[j]) {
                        counter++;
                    }
                }
                System.out.println(wordToChar[i] + " : " + counter);
            }
        }
    }
}

/*
//============= Another Solution ==================

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a word:");
        String input = scanner.nextLine();

        metin = metin.toLowerCase();
        char[] charList = input.toCharArray();

        // Her kaakteri ayrı bir string olarak saklayacak bir dizi oluştur
        String[] stringArray = new String[charList.length];


        //["t","o"...]
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
        }*/

