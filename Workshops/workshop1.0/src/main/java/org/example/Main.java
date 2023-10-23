package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        //Java follows the camel-case syntax for naming the classes, interfaces, methods, and variables.
        //If the name is combined with two words, the second word will start with uppercase letter always
        String midText = "İlginizi çekebilir";
        String bottomText = "Vade süresi";

        System.out.println("bottomText"); // ==> print bottomText
        System.out.println(bottomText); // ==> print Vade süresi

        int vade = 12;

        /*
        double dollarYesterday = 18.14;
        double dollarToday = 18.20;

        boolean isDollarDecrease = false;

        String arrowDirection = "";

        if ( dollarToday < dollarYesterday ){

            arrowDirection = "down.svg";
            System.out.println(arrowDirection);

        } else {

            arrowDirection = "up.svg";
            System.out.println(arrowDirection);

        } */

        double dollarYesterday2 = 18.20;
        double dollarToday2 = 18.20;

        boolean isDollarDecrease2 = false;

        String arrowDirection2 = "";

        if (dollarToday2 < dollarYesterday2) {

            arrowDirection2 = "down.svg";
            System.out.println(arrowDirection2);

        } else if (dollarToday2 > dollarYesterday2) {

            arrowDirection2 = "up.svg";
            System.out.println(arrowDirection2);

        } else {

            arrowDirection2 = "equal.svg";
            System.out.println(arrowDirection2);

        }

        //Array

        String[] credits = {"Hızlı Kredi", "Maaşını Halkbanktan", "Mutlu Emekli"};

        //System.out.println(credits[0]);
        //System.out.println(credits[1]);
        //System.out.println(credits[2]);

        for (int i = 0; i < credits.length; i++) {

            System.out.println(credits[i]);
        }
    }
}