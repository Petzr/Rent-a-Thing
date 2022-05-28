package java.source_code;

import org.junit.jupiter.api.Test;
import source_code.people.Klant;

import static org.junit.jupiter.api.Assertions.*;

class KlantTest {

    @Test
    void createKlant() {
        Klant klant = new Klant("Peter", "Jansen");

        assertEquals("Peter", klant.naam());
        assertEquals("Jansen", klant.achternaam());
    }

}