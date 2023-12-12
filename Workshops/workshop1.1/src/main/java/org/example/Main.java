package org.example;

public class Main {
    public static void main(String[] args) {

        String message = "Vade Oranı";

        //an object(product1) is created from a class(Product)
        Product product1 = new Product();
        product1.setName("Delionghi Kahve Makinesi");
        product1.setDiscount(7);
        product1.setUnitPrice(7500);
        product1.setUnitsInStock(3);
        product1.setImageUrl("blabla1.jpg");

        /*
        product1.name = "Delonghi Kahve Makinesi";
        product1.unitPrice = 7500;
        product1.discount = 7;
        product1.unitsInStock = 3;
        product1.imageUrl = "blabla1.jpg";
        */

        Product product2 = new Product();

        product2.setName("Delionghi Kahve Makinesi");
        product2.setDiscount(8);
        product2.setUnitPrice(6500);
        product2.setUnitsInStock(2);
        product2.setImageUrl("blabla2.jpg");

        /*
        product2.name = "Smeg Kahve Makinesi";
        product2.unitPrice = 6500;
        product2.discount = 8;
        product2.unitsInStock = 2;
        product2.imageUrl = "blabla2.jpg";
         */


        Product product3 = new Product();

        product3.setName("Delionghi Kahve Makinesi");
        product3.setDiscount(9);
        product3.setUnitPrice(4500);
        product3.setUnitsInStock(4);
        product3.setImageUrl("blabla3.jpg");

        /*
        product3.name = "Kitchen Aid Kahve Makinesi";
        product3.unitPrice = 4500;
        product3.discount = 9;
        product3.unitsInStock = 4;
        product3.imageUrl = "blabla3.jpg";
         */

        Product [] products = {product1, product2, product3};

        System.out.println("<ul>");
        for (Product product : products) {

            System.out.println("<li>" + product.getName() + "</li>");
        }
        System.out.println("</ul>");

        IndividualCustomer individualCustomer = new IndividualCustomer();
        individualCustomer.setId(1);
        individualCustomer.setPhone("05222223344");
        individualCustomer.setCustomerNumber("23445");
        individualCustomer.setFirstName("Nursel");
        individualCustomer.setLastName("Demirkıran");

        CorporateCustomer corporateCustomer = new CorporateCustomer();
        corporateCustomer.setId(4);
        corporateCustomer.setCompanyName("Tobeto");
        corporateCustomer.setPhone("05333333345");
        corporateCustomer.setTaxNumber("2344567");
        corporateCustomer.setCustomerNumber("34566");

        Customer[] customers = {individualCustomer,corporateCustomer};

        //System.out.println(individualCustomer.getFirstName());

    }
}