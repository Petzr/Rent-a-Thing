package source_code;

import source_code.products.Boormachine;
import source_code.products.Product;
import source_code.products.Vrachtwagen;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Seeder seeder = new Seeder();
        ArrayList<Product> products = seeder.getproducts();

        for (Product product : products) {
            System.out.println(product);
        }
    }
}
