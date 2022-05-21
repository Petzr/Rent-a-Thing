package source_code;

import source_code.products.Product;

import java.util.ArrayList;

public class Bedrijf {

    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Medewerker> medewerkers = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }
    public void addMedewerker(Medewerker medewerker) {
        medewerkers.add(medewerker);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Medewerker> getMedewerkers() {
        return medewerkers;
    }

    public Medewerker login(String username, String password) {

    }
}
