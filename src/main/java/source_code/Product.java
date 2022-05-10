package source_code;

public abstract class Product {

    private String naam;
    private boolean opVoorraad;
    private double verhuurPrijs;
    private double verzekeringPrijs;

    public Product(String naam, double verhuurPrijs, double verzekeringPrijs) {
        this.naam = naam;
        this.opVoorraad = true;
        this.verhuurPrijs = verhuurPrijs;
        this.verzekeringPrijs = verzekeringPrijs;
    }
    public String getNaam() {
        return naam;
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
}