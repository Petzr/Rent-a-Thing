package source_code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void getVerhuurPrijs() {
        Vrachtwagen vrachtwagen = new Vrachtwagen(50, 100);
        PersonenAuto personenAuto =  new PersonenAuto("merk", 50);

        double expectedVrachtwagenTrue = 30;
        double expectedVrachtwagenFalse = 25;
        double actualVrachtwagenTrue = vrachtwagen.getVerhuurPrijs(5, true);
        double actualVrachtwagenFalse = vrachtwagen.getVerhuurPrijs(5, false);

        double expectedAutoTrue = 252.5;
        double expectedAutoFalse = 250;
        double actualAutoTrue = personenAuto.getVerhuurPrijs(5, true);
        double actualAutoFalse = personenAuto.getVerhuurPrijs(5, false);

        assertEquals(expectedAutoTrue, actualAutoTrue);
        assertEquals(expectedAutoFalse, actualAutoFalse);
        assertEquals(expectedVrachtwagenTrue, actualVrachtwagenTrue);
        assertEquals(expectedVrachtwagenFalse, actualVrachtwagenFalse);
    }
}