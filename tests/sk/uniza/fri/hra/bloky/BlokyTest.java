package sk.uniza.fri.hra.bloky;

import org.junit.jupiter.api.Test;
import sk.uniza.fri.hra.Hra;
import sk.uniza.fri.hra.Lopticka;
import sk.uniza.fri.hra.Pad;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 18. 5. 2021 - 8:52
 *
 * @author micha
 */
class BlokyTest {

    @Test
    void intersectionHorny() {
        Bloky bloky = new Bloky();
        Lopticka lopticka = new Lopticka(50, 50, 0, 0);

        if (bloky.intersectionHorny(lopticka)) {
            assertTrue(true);
        } else {
            assertFalse(false);
        }
    }

    @Test
    void intersectionHornyN() {
        Bloky bloky = new Bloky();
        Lopticka lopticka = new Lopticka(50, 200, 0, 0);

        if (bloky.intersectionHorny(lopticka)) {
            assertTrue(true);
        } else {
            assertFalse(false);
        }
    }

    @Test
    void intersectionPravy() {
        Bloky bloky = new Bloky();
        Lopticka lopticka = new Lopticka(50, 50, 0, 0);

        if (bloky.intersectionPravy(lopticka)) {
            assertTrue(true);
        } else {
            assertFalse(false);
        }
    }

    @Test
    void intersectionPravyN() {
        Bloky bloky = new Bloky();
        Lopticka lopticka = new Lopticka(50, 200, 0, 0);

        if (bloky.intersectionPravy(lopticka)) {
            assertTrue(true);
        } else {
            assertFalse(false);
        }
    }

    @Test
    void intersectionLavy() {
        Bloky bloky = new Bloky();
        Lopticka lopticka = new Lopticka(50, 50, 0, 0);

        if (bloky.intersectionLavy(lopticka)) {
            assertTrue(true);
        } else {
            assertFalse(false);
        }
    }

    @Test
    void intersectionLavyN() {
        Bloky bloky = new Bloky();
        Lopticka lopticka = new Lopticka(50, 200, 0, 0);

        if (bloky.intersectionLavy(lopticka)) {
            assertTrue(true);
        } else {
            assertFalse(false);
        }
    }

    @Test
    void intersectionSpodny() {
        Bloky bloky = new Bloky();
        Lopticka lopticka = new Lopticka(50, 50, 0, 0);

        if (bloky.intersectionSpodny(lopticka)) {
            assertTrue(true);
        } else {
            assertFalse(false);
        }
    }

    @Test
    void intersectionSpodnyN() {
        Bloky bloky = new Bloky();
        Lopticka lopticka = new Lopticka(50, 500, 0, 0);

        if (bloky.intersectionSpodny(lopticka)) {
            assertTrue(true);
        } else {
            assertFalse(false);
        }
    }

    @Test
    void getBodovac() {
        Bloky bloky = new Bloky();
        assertEquals(0, bloky.getBodovac());
    }

    @Test
    void isRozbite() {
        Bloky bloky = new Bloky();
        assertFalse(bloky.isRozbite());
    }
}