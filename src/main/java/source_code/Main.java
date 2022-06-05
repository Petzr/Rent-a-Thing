package source_code;

import source_code.people.Medewerker;
import source_code.products.Product;


public class Main {
    public static void main(String[] args) {
        // hier word een bedrijf gemaakt met producten en medewerkers door de seeder
        Bedrijf bedrijf = new Bedrijf(new Seeder());

        // een medewerker wordt bepaald door het inloggen bij het bedrijf
        Medewerker medewerker = bedrijf.login("123", "123");

        // die medewerker huurt een product uit het bedrijf
        medewerker.addVerhuurdeProduct(bedrijf.getProducts().get(1));
        medewerker.addVerhuurdeProduct(bedrijf.getProducts().get(3));

        // en hier wordt per product van de medewerker de verhuurprijs berekent en laten zien
        for (Product product : medewerker.getVerhuurdeProducten()) {
            System.out.println(product);
            System.out.println(product.getVerhuurPrijs(4, true));
        }
    }

}
