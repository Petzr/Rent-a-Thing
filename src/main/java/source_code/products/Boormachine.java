package source_code.products;

public class Boormachine extends Product{

    private String merk;
    private String type;

    public Boormachine(String merk, String type) {
        super(5, 1);
        this.merk = merk;
        this.type = type;
    }
}
