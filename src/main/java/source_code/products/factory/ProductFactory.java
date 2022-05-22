package source_code.products.factory;

import source_code.products.Boormachine;
import source_code.products.PersonenAuto;
import source_code.products.Vrachtwagen;

public class ProductFactory {

    public static PersonenAuto createPersonenAuto(String merk, double gewichtInKG) {
        return new PersonenAuto(merk, gewichtInKG);
    }

    public static Vrachtwagen createVrachtwagen(double laadVermogenInKG, double gewichtInKG) {
        return new Vrachtwagen(laadVermogenInKG, gewichtInKG);
    }

    public static Boormachine createBoormachine(String merk, String type) {
        return new Boormachine(merk, type);
    }
}
