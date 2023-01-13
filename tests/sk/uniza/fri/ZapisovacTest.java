package sk.uniza.fri;

import org.junit.jupiter.api.Test;
import sk.uniza.fri.hra.StavHry;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 18. 5. 2021 - 8:52
 *
 * @author micha
 */
class ZapisovacTest {

    @Test
    void uloz() throws IOException {
        Zapisovac zapisovac = new Zapisovac();
        zapisovac.uloz("Jozko", "Vyhral", 50);

        zapisovac.citaj();
        ArrayList<String> diar = zapisovac.getDiar();
        assertEquals("Jozko skončil/-a s dosiahnutým skóre: 50 Vyhral/-a. ", diar.get(diar.size() - 1));
    }
}