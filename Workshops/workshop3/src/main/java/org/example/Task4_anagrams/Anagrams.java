package org.example.Task4_anagrams;

import java.util.Arrays;

public class Anagrams {
    public static void main(String[] args) {

        //A Java program to check if two Strings are anagrams of each other:

        String word1 = "listen";
        String word2 = "silent";
        boolean isUniqe = true;

        char[] word1CharArray = word1.toCharArray();
        char[] word2CharArray =word2.toCharArray();

        Arrays.sort(word1CharArray);
        Arrays.sort(word2CharArray);

        if(word1CharArray.length == word2CharArray.length) {
            for (int i = 0; i < word1CharArray.length; i++) {
                if (word1CharArray[i] != word2CharArray[i]) {
                    isUniqe = false;
                }
            }
            if (isUniqe) {
                System.out.println("'" + word1 + "'" + " and " + "'" + word2 + "'" + " are anagram words.");
            } else {
                System.out.println("'" + word1 + "'" + " and " + "'" + word2 + "'" + " are not anagram words.");
            }
        }
        else {
            System.out.println("'" + word1 + "'" + " and " + "'" + word2 + "'" + " are not anagram words.");
        }
    }


    }

