package source_code;

public class PersonenAuto extends Product{
    private String merk;
    private double gewichtInKG;

    public PersonenAuto(String merk, double gewichtInKG) {
        super(50, 0.01);
        this.merk = merk;
        this.gewichtInKG = gewichtInKG;
    }

    public PersonenAuto(double verhuurPrijs, double verzekeringPrijs) {
        super(verhuurPrijs, verzekeringPrijs);
    }

    @Override
    public double getVerzekeringPrijs(int aantalDagen) {
        return super.getVerzekeringPrijs(aantalDagen) * gewichtInKG;
    }
}
