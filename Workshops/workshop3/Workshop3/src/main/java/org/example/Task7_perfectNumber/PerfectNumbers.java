package org.example.Task7_perfectNumber;

import java.math.BigInteger;

public class PerfectNumbers {
    public static void main(String[] args) {

        //if 2n -1 is a prime number, then 2n-1(2n-1) is a perfect number.
        int count = 0;
        int n = 2;
        BigInteger[] perfectNumbers = new BigInteger[10];

        while (count < 10) {
            BigInteger number = BigInteger.valueOf(2).pow(n - 1);
            BigInteger isPrime = BigInteger.valueOf(2).pow(n).subtract(BigInteger.ONE);

            if (isPrime.isProbablePrime(10)) { // Asal sayı kontrolü için isProbablePrime kullanılır
                BigInteger perfectNumber = number.multiply(isPrime);//number*isPrime
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
        int n = 3;
        double number = Math.pow(2,n-1);
        double isPrime = Math.pow(2,n) - 1;
        int count = 0;

        for (int i = 1; i <= isPrime / 2; i++) {
            if (isPrime % i == 0) {
                count++;
            }
        }
        if (count > 1) {
            System.out.println("The number is not prime");
        }
        else {
            System.out.println("The number is prime");
            double perfectNumber = number * isPrime;
            System.out.println(perfectNumber);
        }
*/
        /*for(n = 1; n < 3; n++){
            double number = Math.pow(2,n-1);
            double isPrime = Math.pow(2,n) - 1;

            for (int i = 1; i <= isPrime/ 2; i++) {
                if (n % i == 0) {
                    count++;
                }
            }}
*/
    }
}
