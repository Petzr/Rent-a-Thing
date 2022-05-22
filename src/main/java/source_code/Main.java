package source_code;

import source_code.people.Medewerker;
import source_code.products.Boormachine;
import source_code.products.Product;
import source_code.products.Vrachtwagen;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Bedrijf bedrijf = new Bedrijf();

        setBedrijf(bedrijf);

        Medewerker medewerker = bedrijf.login("123", "123");

        medewerker.addVerhuurdeProducten(new Seeder().getProduct(5));
        for (Product product : medewerker.getVerhuurdeProducten()) {
            System.out.println(product);
            System.out.println(product.getVerhuurPrijs(4, true));
        }
    }

    private static void setBedrijf(Bedrijf bedrijf) {
        Seeder seeder = new Seeder();
        for (Product product : seeder.getProducts()) {
            bedrijf.addProduct(product);
        }
        for (Medewerker medewerker : seeder.getMedewerkers()) {
            bedrijf.addMedewerker(medewerker);
        }
    }
}
