package source_code;

import source_code.products.Boormachine;
import source_code.products.PersonenAuto;
import source_code.products.Product;
import source_code.products.Vrachtwagen;

import java.util.ArrayList;

public class Seeder {

    private ArrayList<Product> products = new ArrayList<>();

    public Seeder () {
        products.add (new Boormachine("Bosch", "GSB 18V-55 Professional"));
        products.add (new Boormachine("Makita", "HP457DWE"));
        products.add (new Boormachine("Hitachi", "DS18DJLWC "));
        products.add (new PersonenAuto("Audi", 1200));
        products.add (new PersonenAuto("Volkswagen", 1300));
        products.add (new PersonenAuto("Ford", 1050));
        products.add (new Vrachtwagen(22000, 3000));
        products.add (new Vrachtwagen(18000, 2700));
        products.add (new Vrachtwagen(15000, 2500));
    }

    public ArrayList<Product> getproducts () {
        return products;
    }

    public Product getProduct (int index) {
        if (index < products.size ()) {
            return products.get(index);
        }
        else {
            return null;
        }
    }

}
