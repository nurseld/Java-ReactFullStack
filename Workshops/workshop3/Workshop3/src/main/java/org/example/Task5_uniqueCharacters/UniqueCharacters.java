package org.example.Task5_uniqueCharacters;

import java.util.Scanner;

public class UniqueCharacters {
    public static void main(String[] args) {

        //A Java program to determine if the string has all unique characters:

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word : ");
        String word = scanner.nextLine();

        boolean isUniqe = true;

        char[] wordCharArray = word.toCharArray();
        for (int i = 0; i < wordCharArray.length; i++){
            for (int j = i +1; j < wordCharArray.length; j++){
                if(wordCharArray[i] == wordCharArray[j]){
                    isUniqe = false;
                }
            }
        }
        if(isUniqe){
            System.out.println("In " + "'" + word + "'" + " all characters are unique.");
        }
        else {
            System.out.println("In " + "'" + word + "'" + " all characters are not unique.");
        }
    }

    }

