package source_code;

import java.util.ArrayList;

public class Seeder {

    private ArrayList<Product> products = new ArrayList<>();

    public Seeder () {
        products.add (new Boormachine("merk", "type"));
        products.add (new PersonenAuto("merk", "type"));
    }

    public ArrayList<Meal> getproducts () {
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
