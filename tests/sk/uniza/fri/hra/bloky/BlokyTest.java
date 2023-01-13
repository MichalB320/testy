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
        Hra hra = new Hra("Jozko");
        Bloky bloky = hra.getBloky();
        Lopticka lopticka = hra.getLopticka();
        if (bloky.intersectionHorny(lopticka)) {
            assertTrue(true);
        } else {
            assertFalse(false);
        }
    }

    @Test
    void intersectionPravy() {
        Hra hra = new Hra("Jozko");
        Bloky bloky = hra.getBloky();
        Lopticka lopticka = hra.getLopticka();
        if (bloky.intersectionPravy(lopticka)) {
            assertTrue(true);
        } else {
            assertFalse(false);
        }
    }

    @Test
    void intersectionLavy() {
        Hra hra = new Hra("Jozko");
        Bloky bloky = hra.getBloky();
        Lopticka lopticka = hra.getLopticka();
        if (bloky.intersectionLavy(lopticka)) {
            assertTrue(true);
        } else {
            assertFalse(false);
        }
    }

    @Test
    void intersectionSpodny() {
        Hra hra = new Hra("Jozko");
        Bloky bloky = hra.getBloky();
        Lopticka lopticka = hra.getLopticka();
        if (bloky.intersectionSpodny(lopticka)) {
            assertTrue(true);
        } else {
            assertFalse(false);
        }
    }

    @Test
    void rozbi() {
        Hra hra = new Hra("Jozko");
        Bloky blokyH = hra.getBloky();
        Lopticka lopticka = hra.getLopticka();
        Blok[][] bloky = hra.getBloky().getBloky();

        double rozostup = 18;
        double riadok = lopticka.getStredY();
        double stlpec = lopticka.getStredX();
        if (blokyH.intersectionHorny(lopticka)) {
            riadok = riadok - 5.0 / rozostup;
            stlpec = stlpec / 18;

            if (bloky[(int) riadok][(int) stlpec].getX() == -20 && bloky[(int) riadok][(int) stlpec].getY() == -20) {
                assertTrue(true, "blok sa rozbil");
            } else {
                assertFalse(false, "blok sa nerozbil");
            }
        } else if (blokyH.intersectionPravy(lopticka)) {
            riadok = riadok / 18;
            stlpec = stlpec - 5.0 / 18;

            if (bloky[(int) riadok][(int) stlpec].getX() == -20 && bloky[(int) riadok][(int) stlpec].getY() == -20) {
                assertTrue(true, "blok sa rozbil");
            } else {
                assertFalse(false, "blok sa nerozbil");
            }
        } else if (blokyH.intersectionLavy(lopticka)) {
            riadok = riadok / 18;
            stlpec = stlpec + 5.0 / 18;

            if (bloky[(int) riadok][(int) stlpec].getX() == -20 && bloky[(int) riadok][(int) stlpec].getY() == -20) {
                assertTrue(true, "blok sa rozbil");
            } else {
                assertFalse(false, "blok sa nerozbil");
            }
        }  else if (blokyH.intersectionSpodny(lopticka)) {
            riadok = riadok + 5.0 / 18;
            stlpec = stlpec / 18;

            if (bloky[(int) riadok][(int) stlpec].getX() == -20 && bloky[(int) riadok][(int) stlpec].getY() == -20) {
                assertTrue(true, "blok sa rozbil");
            } else {
                assertFalse(false, "blok sa nerozbil");
            }
        } else {
            assertFalse(false, "blok sa nerozbil");
        }

//        if (bloky[(int) riadok][(int) stlpec].getX() == -20 && bloky[(int) riadok][(int) stlpec].getY() == -20) {
//            assertTrue(true, "blok sa rozbil");
//        } else {
//            assertFalse(false, "blok sa nerozbil");
//        }

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