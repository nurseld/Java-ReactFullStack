package org.example;

public class Arrays {
    public static void main(String[] args) {

        String[] cities = new String[]{"Tekirdağ", "İstanbul", "İzmir"};

        for (String city : cities) {
            System.out.println(city);
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(cities[i]);
        }



        String[] cities1 = new String[]{"Tekirdağ", "İstanbul", "İzmir"};
        String[] cities2 = new String[]{"Malatya", "Mersin", "Manisa"};

        cities1 = cities2;
        cities1[0] = "Adana";
        System.out.println(cities2[0]); //Adana

        int number1 = 10;
        int number2 = 20;
        number1 = number2;
        number2 = 30;
        System.out.println(number1);

        //Value Types : bool,int,double...
        //Reference Types: array,class,abstract,interface
    }
}
