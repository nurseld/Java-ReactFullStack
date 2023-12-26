package org.example.Task7_perfectNumber;

import java.math.BigInteger;

public class PerfectNumbers {
    public static void main(String[] args) {

        //A Java program that finds first 10 perfect numbers:

        //if (2^n - 1 ) is a prime number, then Euclid said that 2^(n-1) * (2^n - 1) is a perfect number.
        int count = 0;
        int n = 2;
        BigInteger[] perfectNumbers = new BigInteger[10];

        while (count < 10) {
            BigInteger number = BigInteger.valueOf(2).pow(n - 1);
            BigInteger isPrime = BigInteger.valueOf(2).pow(n).subtract(BigInteger.ONE);

            if (isPrime.isProbablePrime(10)) { // Asal sayı kontrolü için isProbablePrime kullanılır
                BigInteger perfectNumber = number.multiply(isPrime);// number*isPrime
                perfectNumbers[count] = perfectNumber;
                count++;
            }

            n++;
        }

        // Sonuçları göster
        for (BigInteger number : perfectNumbers) {
            System.out.println(number);
        }


        /*

        ============= Another Solution ==============
        int sum = 0;
        long number = 1;
        int counter = 0;
        while (counter <= 10) {
            number++;
            sum = 0;
            for (int i = 1; i < number; i++) {
                if (number % i == 0) {
                    sum += i;
                }
            }
            if (sum == number) {
                System.out.println("girilen sayı perfect "+ number);
                counter++;
            }
        } */
    }
}

