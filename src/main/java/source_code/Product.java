package source_code;

public abstract class Product {

    private String naam;    private boolean opVoorraad;
    private double verhuurPrijs;
    private double verzekeringPrijs;

    public Product(double verhuurPrijs, double verzekeringPrijs) {
        this.opVoorraad = true;
        this.verhuurPrijs = verhuurPrijs;
        this.verzekeringPrijs = verzekeringPrijs;
    }

    public boolean isOpVoorraad() {
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
}