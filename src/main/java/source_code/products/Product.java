package source_code.products;

import source_code.people.Medewerker;

import java.util.Observable;
import java.util.Observer;

public abstract class Product extends Observable implements Observer {

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

    public boolean retourProduct() {
        opVoorraad = true;
        return opVoorraad;
    }

    public abstract String korteOmschrijvingProduct();

    @Override
    public String toString() {
        String line = String.format("%s, %s", getClass(), korteOmschrijvingProduct());
        return line.substring(27);
    }

    @Override
    public void update(Observable o, Object medewerker) {
        opVoorraad = !opVoorraad;
    }
}