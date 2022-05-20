package source_code;

import source_code.products.Product;

import java.util.ArrayList;

public class Bedrijf {

    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Medewerker> medewerkers = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }
}
