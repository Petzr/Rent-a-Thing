package source_code.products;

public class PersonenAuto extends Product{

    private String merk;
    private double gewichtInKG;

    public PersonenAuto(String merk, double gewichtInKG) {
        super(50, 0.01);
        this.merk = merk;
        this.gewichtInKG = gewichtInKG;
    }

    @Override
    public double getVerzekeringPrijs(int aantalDagen) {
        return super.getVerzekeringPrijs(aantalDagen) * gewichtInKG;
    }

    @Override
    public String korteOmschrijvingProduct() {
        return String.format("Merk: %s \nGewicht in KG: %.1f", merk, gewichtInKG);
    }

    public String getMerk() {
        return merk;
    }

    public double getGewichtInKG() {
        return gewichtInKG;
    }
}
