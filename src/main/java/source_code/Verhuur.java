package source_code;

import source_code.people.Klant;
import source_code.people.Medewerker;
import source_code.products.Product;

import java.util.Observable;

public class Verhuur extends Observable {

    private Product verhuurdProduct;
    private Medewerker verhuurdDoor;
    private Klant verhuurdAan;

    public Verhuur(Product verhuurdProduct, Medewerker verhuurdDoor, Klant verhuurdAan) {
        this.verhuurdProduct = verhuurdProduct;
        this.verhuurdDoor = verhuurdDoor;
        this.verhuurdAan = verhuurdAan;

        verhuurdProduct.setOpVoorraad(false);
    }

    public Medewerker getVerhuurdDoor() {
        return verhuurdDoor;
    }
    public Klant getVerhuurdAan() {
        return verhuurdAan;
    }
    public Product getVerhuurdProduct() {
        return verhuurdProduct;
    }

    public double verhuurPrijs(int aantaldagen, boolean isVerzekerd) {
        return verhuurdProduct.getVerhuurPrijs(aantaldagen, isVerzekerd);
    }

    public double verzekeringPrijs(int aantaldagen) {
        return verhuurdProduct.getVerzekeringPrijs(aantaldagen);
    }

    public void retourProduct() {
        verhuurdAan = null;
        verhuurdDoor = null;
        verhuurdProduct.setOpVoorraad(true);
    }
}
