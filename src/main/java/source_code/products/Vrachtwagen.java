package source_code.products;

public class Vrachtwagen extends Product{

    private double laadVermogenInKG;
    private double gewichtInKG;

    public Vrachtwagen(double laadVermogenInKG, double gewichtInKG) {
        super(0.1, 0.01);
        this.laadVermogenInKG = laadVermogenInKG;
        this.gewichtInKG = gewichtInKG;
    }

    @Override
    public double getVerhuurPrijs(int aantalDagen, boolean isVerzekerd) {
        double prijs = 0.1 * laadVermogenInKG * aantalDagen;
        if (isVerzekerd) {
            prijs += getVerzekeringPrijs(aantalDagen);
        }
        return prijs;
    }

    @Override
    public double getVerzekeringPrijs(int aantalDagen) {
        return super.getVerzekeringPrijs(aantalDagen) * gewichtInKG;
    }

    @Override
    public String korteOmschrijvingProduct() {
        return String.format("Laadvermogen in KG: %.1f \nGewicht in KG: %.1f", getLaadVermogenInKG(), getGewichtInKG());
    }

    public double getLaadVermogenInKG() {
        return laadVermogenInKG;
    }

    public double getGewichtInKG() {
        return gewichtInKG;
    }
}
