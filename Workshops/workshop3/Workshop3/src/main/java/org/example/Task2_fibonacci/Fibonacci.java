package org.example.Task2_fibonacci;

import java.math.BigInteger;

public class Fibonacci {
    public static void main(String[] args) {

        // A Java function to print first 100 numbers in Fibonacci series:

        BigInteger A = BigInteger.valueOf(0);
        BigInteger B = BigInteger.valueOf(1);

        System.out.println("The first 100 Fibonacci numbers are:");
        System.out.println(A);
        System.out.println(B);

        for (int i = 2; i < 100; i++) {
            BigInteger C = A.add(B); // ==> int c = a + b;
            A = B;
            B = C;
            System.out.println(C);

    }



    }

    }
