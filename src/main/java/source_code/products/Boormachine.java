package source_code.products;

public class Boormachine extends Product{

    private String merk;
    private String type;

    public Boormachine(String merk, String type) {
        super(5, 1);
        this.merk = merk;
        this.type = type;
    }

    public String getMerk() {
        return merk;
    }

    public String getType() {
        return type;
    }

    @Override
    public String korteOmschrijvingProduct() {
        return String.format("Merk: %s \nType: %s", merk, type);
    }
}
