package source_code.products;

import java.util.Observable;

public abstract class Product extends Observable {

    private boolean opVoorraad;

    private double verhuurPrijs;
    private double verzekeringPrijs;

    public Product(double verhuurPrijs, double verzekeringPrijs) {
        this.opVoorraad = true;
        this.verhuurPrijs = verhuurPrijs;
        this.verzekeringPrijs = verzekeringPrijs;
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