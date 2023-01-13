package sk.uniza.fri.hra;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 18. 5. 2021 - 8:52
 *
 * @author micha
 */
class PadTest {

    @Test
    void posunVpravo() {
        Pad pad = new Pad(50, 50);
        int pozX = pad.getPoziciaX() + 5;
        pad.posunVpravo();

        assertEquals(pozX, pad.getPoziciaX());
    }

    @Test
    void posunVlavo() {
        Pad pad = new Pad(50, 50);
        int pozX = pad.getPoziciaX() - 5;
        pad.posunVlavo();

        assertEquals(pozX, pad.getPoziciaX());
    }

    @Test
    void stredKolidujeS() {
        Hra hra = new Hra("jozko");
        Lopticka lopticka = hra.getLopticka();
        Pad pad = hra.getPad();

        if (pad.stredKolidujeS(lopticka)) {
            assertTrue(pad.stredKolidujeS(lopticka));
        } else {
            assertFalse(pad.stredKolidujeS(lopticka));
        }
    }
}