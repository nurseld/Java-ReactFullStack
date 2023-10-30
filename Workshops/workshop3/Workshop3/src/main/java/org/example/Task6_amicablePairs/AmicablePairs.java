package org.example.Task6_amicablePairs;

public class AmicablePairs {
    public static void main(String[] args) {
        int pairCount = 0;
        int number1 = 1;

        while (pairCount < 3) {
            int number2 = getSumOfDivisors(number1);
            if (number2 > number1 && number1 == getSumOfDivisors(number2)) {
                System.out.println("Amicable Pair " + (pairCount + 1) + ": " + number1 + " - " + number2);
                pairCount++;
            }
            number1++;
        }
    }

    public static int getSumOfDivisors(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    }

