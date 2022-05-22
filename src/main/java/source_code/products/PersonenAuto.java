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

    public String getMerk() {
        return merk;
    }

    public double getGewichtInKG() {
        return gewichtInKG;
    }
}
