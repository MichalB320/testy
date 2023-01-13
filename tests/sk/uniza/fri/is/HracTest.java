package sk.uniza.fri.is;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 18. 5. 2021 - 8:52
 *
 * @author micha
 */
class HracTest {

    @Test
    void premenuj() {
        Hrac hrac = new Hrac("Koloman", "Kudlacek");

        assertEquals("Koloman", hrac.getMeno());
        assertEquals("Kudlacek", hrac.getPriezvisko());

        hrac.premenuj("Maria", "Bystra");

        assertEquals("Maria", hrac.getMeno());
        assertEquals("Bystra", hrac.getPriezvisko());
    }
}