package source_code;

public class PersonenAuto extends Product{
    private String merk;
    private double gewichtInKG;

    public PersonenAuto(String naam, String merk, double gewichtInKG) {
        super(naam, 50, 0.01);
        this.merk = merk;
        this.gewichtInKG = gewichtInKG;
    }

    @Override
    public double getVerzekeringPrijs(int aantalDagen) {
        return super.getVerzekeringPrijs(aantalDagen) * gewichtInKG;
    }
}
