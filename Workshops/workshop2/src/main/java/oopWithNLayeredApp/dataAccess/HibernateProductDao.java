package oopWithNLayeredApp.dataAccess;

import oopWithNLayeredApp.entities.Product;

public class HibernateProductDao implements ProductDao {
    public void add(Product product){
        System.out.println("Hibaernate ile veri tabanına eklendi");
    }
}
