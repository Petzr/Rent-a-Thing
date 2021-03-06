package source_code;

import source_code.people.Medewerker;
import source_code.products.Boormachine;
import source_code.products.PersonenAuto;
import source_code.products.Product;
import source_code.products.Vrachtwagen;
import source_code.products.factory.ProductFactory;

import java.util.ArrayList;

public class Seeder {

    private final ArrayList<Product> products = new ArrayList<>();
    private final ArrayList<Medewerker> medewerkers = new ArrayList<>();

    public Seeder () {
        createProducts();
        createMedewerkers();
    }

    private void createMedewerkers() {
        medewerkers.add(new Medewerker("123", "123", "123"));
        medewerkers.add(new Medewerker("Peter", "Petzr", "asdf"));
        medewerkers.add(new Medewerker("Karel", "Karel", "asdf"));
        medewerkers.add(new Medewerker("Daner", "Daner", "asdf"));
        medewerkers.add(new Medewerker("Yorik", "Yorik", "asdf"));
    }

    private void createProducts() {
        products.add (ProductFactory.createBoormachine("Bosch", "GSB 18V-55 Professional"));
        products.add (new Boormachine("Makita", "HP457DWE"));
        products.add (new Boormachine("Hitachi", "DS18DJLWC "));
        products.add (ProductFactory.createPersonenAuto("Audi", 1200));
        products.add (new PersonenAuto("Volkswagen", 1300));
        products.add (new PersonenAuto("Ford", 1050));
        products.add (ProductFactory.createVrachtwagen(22000, 3000));
        products.add (new Vrachtwagen(18000, 2700));
        products.add (new Vrachtwagen(15000, 2500));
    }

    public ArrayList<Product> getProducts () {
        return products;
    }

    public Product getProduct (int index) {
        if (index >= 0 && index < products.size ()) {
            return products.get(index);
        }
        else {
            return null;
        }
    }

    public ArrayList<Medewerker> getMedewerkers() {
        return medewerkers;
    }
    public Medewerker getMedewerker (int index) {
        if (index > 0 && index < medewerkers.size()) {
            return medewerkers.get(index);
        } else {
            return null;
        }
    }
}
