package source_code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KlantTest {

    @Test
    void createKlant() {
        Klant klant = new Klant("Peter", "Jansen");

        assertEquals("Peter", klant.naam());
        assertEquals("Jansen", klant.achternaam());
    }

}