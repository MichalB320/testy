package sk.uniza.fri.hra;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 18. 5. 2021 - 8:52
 *
 * @author micha
 */
class LoptickaTest {

    @Test
    void posunSa() {
        Lopticka lopticka = new Lopticka(50, 50, 5, -5);
        int pozX = lopticka.getPoziciaX() + 5;
        lopticka.posunSa();

        assertEquals(pozX, lopticka.getPoziciaX());
    }

    @Test
    void odrazY() {
        Lopticka lopticka = new Lopticka(50, 50, 5, -5);
        int smerY = -lopticka.getSmerY();
        lopticka.odrazY();

        assertEquals(smerY, lopticka.getSmerY());
    }

    @Test
    void odrazX() {
        Lopticka lopticka = new Lopticka(50, 50, 5, -5);
        int smerX = -lopticka.getSmerX();
        lopticka.odrazX();

        assertEquals(smerX, lopticka.getSmerX());
    }

    @Test
    void odrazRovno() {
        Lopticka lopticka = new Lopticka(50, 50, 5, -5);
        int smerX = 0;
        int smerY = -lopticka.getSmerY();
        lopticka.odrazRovno();

        assertEquals(smerX, lopticka.getSmerX());
        assertEquals(smerY, lopticka.getSmerY());
    }

    @Test
    void jeMimoObrazovky() {
        Lopticka lopticka = new Lopticka(50, 500, 5, -5);

        assertTrue(lopticka.jeMimoObrazovky());
    }

    @Test
    void nieJeMimoObrazovky() {
        Lopticka lopticka = new Lopticka(50, 50, 5, -5);

        assertFalse(lopticka.jeMimoObrazovky());
    }

    @Test
    void vratDoStredu() {
        Lopticka lopticka = new Lopticka(20, 20, 5, -5);
        boolean pozX = false;
        int pozY = 143;
        lopticka.vratDoStredu();
        if (lopticka.getPoziciaX() > 20 && lopticka.getPoziciaX() < 261) {
            pozX = true;
        }

        assertEquals(pozY, lopticka.getPoziciaY());
        assertTrue(pozX);
    }
}