package org.example;

public class Main {
    public static void main(String[] args) {

        int[] numbers = new int[]{1, 2, 3};

        Product product1 = new Product();
        product1.setName("Laptop");

        Product product2 = new Product();
        product2.setName("Mouse");

        Product[] products = new Product[]{product1, product2};


        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i].getName());
        }



        /*
        //ArrayList<CreditManager> credits = new ArrayList<CreditManager>();
        //credits.add(new MortgageManager());
        //credits.add(new VehicleManager());

        CreditManager[] credits = new CreditManager[3];
        credits[0] = new MortgageManager();
        credits[1] = new VehicleManager();


        for (int i = 0; i < credits.length; i++) {
            credits[i].calculate();

        }*/


        }

    }


