package java.source_code;

import org.junit.jupiter.api.Test;
import source_code.Seeder;
import source_code.products.Boormachine;
import source_code.products.Product;
import source_code.products.factory.ProductFactory;

import static org.junit.jupiter.api.Assertions.*;

class SeederTest {

    @Test
    void initializeSeederWithFirstProduct() {
        Seeder seeder = new Seeder();
        Boormachine sut = ProductFactory.createBoormachine("Bosch", "GSB 18V-55 Professional");
        String expected = sut.getMerk();

        Product product = seeder.getProduct(0);
        Boormachine boormachine = (Boormachine) product;

        assertEquals(expected, boormachine.getMerk());

    }

}