package source_code;

public class Boormachine extends Product{

    private String merk;
    private String type;

    public Boormachine(String naam, String merk, String type) {
        super(naam, 5, 1);
        this.merk = merk;
        this.type = type;
    }
}
