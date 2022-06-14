package source_code.products;

import source_code.Verhuur;
import source_code.people.Klant;
import source_code.people.Medewerker;

import java.util.Observable;
import java.util.Observer;

public abstract class Product extends Observable {

    private boolean opVoorraad;
    private Verhuur verhuur;

    private final double verhuurPrijs;
    private final double verzekeringPrijs;

    public Product(double verhuurPrijs, double verzekeringPrijs) {
        this.opVoorraad = true;
        this.verhuurPrijs = verhuurPrijs;
        this.verzekeringPrijs = verzekeringPrijs;
    }

    public boolean setOpVoorraad(boolean opVoorraad) {
        this.opVoorraad = opVoorraad;
        updateObservers();
        return opVoorraad;
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

    public Verhuur huurProduct(Medewerker verhuurdDoor, Klant verhuurdAan) {
        if (verhuur != null) {
            verhuur = new Verhuur(this, verhuurdDoor, verhuurdAan);
            return verhuur;
        } else return verhuur
    }

    public abstract String korteOmschrijvingProduct();

    @Override
    public String toString() {
        String line = String.format("%s, %s", getClass(), korteOmschrijvingProduct());
        return line.substring(27);
    }

    public void addObserverToProduct(Observer o) {
        addObserver(o);
    }
    private void updateObservers() {
        setChanged();
        notifyObservers();
    }
}