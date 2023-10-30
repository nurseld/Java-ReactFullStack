package org.example.Task2_fibonacci;

import java.math.BigInteger;

public class Fibonacci {
    public static void main(String[] args) {
       /* Scanner input = new Scanner(System.in);
        System.out.println("n");
        long n;
        n = input.nextLong();
        int number, a = 0, b=1, c;
        System.out.println(a);
        System.out.println(b);
        for(int i = 2; i <= n ; i++){
            c = a + b;
            a = b;
            b = c;
            System.out.println(c);*/
        //BigInteger a = BigInteger.ZERO;
        //BigInteger b = BigInteger.ONE;


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
