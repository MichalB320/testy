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

    @Test
    void prava3KolidujeS() {
        Hra hra = new Hra("jozko");
        Lopticka lopticka = hra.getLopticka();
        Pad pad = hra.getPad();

        if (pad.prava3KolidujeS(lopticka)) {
            assertTrue(pad.prava3KolidujeS(lopticka));
        } else {
            assertFalse(pad.prava3KolidujeS(lopticka));
        }
    }

    @Test
    void lava3KolidujeS() {
        Hra hra = new Hra("jozko");
        Lopticka lopticka = hra.getLopticka();
        Pad pad = hra.getPad();

        if (pad.lava3KolidujeS(lopticka)) {
            assertTrue(pad.lava3KolidujeS(lopticka));
        } else {
            assertFalse(pad.lava3KolidujeS(lopticka));
        }
    }

    @Test
    void prava2KolidujeS() {
        Hra hra = new Hra("jozko");
        Lopticka lopticka = hra.getLopticka();
        Pad pad = hra.getPad();

        if (pad.prava2KolidujeS(lopticka)) {
            assertTrue(pad.prava2KolidujeS(lopticka));
        } else {
            assertFalse(pad.prava2KolidujeS(lopticka));
        }
    }

    @Test
    void prava1KolidujeS() {
        Hra hra = new Hra("jozko");
        Lopticka lopticka = hra.getLopticka();
        Pad pad = hra.getPad();

        if (pad.prava1KolidujeS(lopticka)) {
            assertTrue(pad.prava1KolidujeS(lopticka));
        } else {
            assertFalse(pad.prava1KolidujeS(lopticka));
        }
    }

    @Test
    void lava2KolidujeS() {
        Hra hra = new Hra("jozko");
        Lopticka lopticka = hra.getLopticka();
        Pad pad = hra.getPad();

        if (pad.lava2KolidujeS(lopticka)) {
            assertTrue(pad.lava2KolidujeS(lopticka));
        } else {
            assertFalse(pad.lava2KolidujeS(lopticka));
        }
    }

    @Test
    void lava1KolidujeS() {
        Hra hra = new Hra("jozko");
        Lopticka lopticka = hra.getLopticka();
        Pad pad = hra.getPad();

        if (pad.lava1KolidujeS(lopticka)) {
            assertTrue(pad.lava1KolidujeS(lopticka));
        } else {
            assertFalse(pad.lava1KolidujeS(lopticka));
        }
    }

    @Test
    void zmenVelkostO() {
        Pad pad = new Pad(50, 50);
        pad.zmenVelkostO(100);
        int ocakavane = 50 + 100;
        assertEquals(ocakavane, pad.getAktualnaVelkost());
    }
}