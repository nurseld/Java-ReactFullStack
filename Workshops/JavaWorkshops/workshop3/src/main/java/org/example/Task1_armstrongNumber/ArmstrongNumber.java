package org.example.Task1_armstrongNumber;

import java.util.Scanner;



public class ArmstrongNumber {
    public static void main(String[] args) {

        //  A Java program to check if the entered number is Armstrong number:

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number to check if it's an Armstrong number: ");
        int number = input.nextInt();

        int originalNumber = number;
        int changeNumber;
        int counter = 0;
        int numberMod;
        double numberPow = 0;

        while (number > 0) {
            number /= 10;
            counter++;
        }

       changeNumber = originalNumber;

        while (changeNumber != 0) {
            numberMod = changeNumber % 10;
            numberPow += Math.pow(numberMod, counter);
            changeNumber /= 10;
        }

        if (numberPow == originalNumber) {
            System.out.println(originalNumber + " is an Armstrong number. ");
        } else {
            System.out.println(originalNumber + " is not an Armstrong number. ");


        }

    }

    }
