package source_code.products;

import source_code.people.Klant;
import source_code.people.Medewerker;

public class Verhuur {

    private Product verhuurdProduct;
    private Medewerker verhuurdDoor;
    private Klant verhuurdAan;

    public Verhuur(Product verhuurdProduct, Medewerker verhuurdDoor, Klant verhuurdAan) {
        this.verhuurdProduct = verhuurdProduct;
        this.verhuurdDoor = verhuurdDoor;
        this.verhuurdAan = verhuurdAan;
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

}
