package source_code.products;

import source_code.people.Medewerker;
import source_code.people.Klant;

import java.util.Observable;

public abstract class Product extends Observable {

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

    public void retourProduct() {
        opVoorraad = true;
    }

    public abstract String korteOmschrijvingProduct();

    private void updateObservers() {
        setChanged();
        notifyObservers();
    }
}