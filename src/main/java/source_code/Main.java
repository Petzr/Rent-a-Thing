package source_code;

import source_code.people.Medewerker;
import source_code.products.Product;


public class Main {
    public static void main(String[] args) {
        Bedrijf bedrijf = new Bedrijf(new Seeder());

        Medewerker medewerker = bedrijf.login("123", "123");

        medewerker.addVerhuurdeProduct(new Seeder().getProduct(5));
        for (Product product : medewerker.getVerhuurdeProducten()) {
            System.out.println(product);
            System.out.println(product.getVerhuurPrijs(4, true));
        }
    }

}
