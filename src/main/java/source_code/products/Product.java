package source_code.products;

import source_code.Medewerker;
import source_code.Klant;

public abstract class Product {

    private boolean opVoorraad;
    private Medewerker verhuurdDoor;
    private Klant verhuurdAan;

    private double verhuurPrijs;
    private double verzekeringPrijs;

    public Product(double verhuurPrijs, double verzekeringPrijs) {
        this.opVoorraad = true;
        this.verhuurPrijs = verhuurPrijs;
        this.verzekeringPrijs = verzekeringPrijs;
    }


    public Medewerker getVerhuurdDoor() {
        return verhuurdDoor;
    }
    public Klant getVerhuurdAan() {
        return verhuurdAan;
    }

    public void setVerhuurdDoor(Medewerker verhuurdDoor) {
        this.verhuurdDoor = verhuurdDoor;
    }

    public void setVerhuurdAan(Klant verhuurdAan) {
        this.verhuurdAan = verhuurdAan;
    }

    public boolean getOpVoorraad() {
        return opVoorraad;
    }

    public double getVerhuurPrijs(int aantalDagen, boolean isVerzekerd) {
        double prijs = verhuurPrijs * aantalDagen;
        if (isVerzekerd) {
            prijs += getVerzekeringPrijs(aantalDagen);
        }
        return prijs;
    }

    public double getVerzekeringPrijs(int aantalDagen) {
        return verzekeringPrijs * aantalDagen;
    }

    @Override
    public String toString() {
        return "Product{" +
                "naam='" + getClass() + '\'' +
                ", opVoorraad=" + opVoorraad +
                '}';
    }

    public void retourProduct() {
        opVoorraad = true;
    }

    public abstract String korteOmschrijvingProduct();
}