package sk.uniza.fri.hra;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 18. 5. 2021 - 8:52
 *
 * @author micha
 */
class HraTest {

    @Test
    void posunVpravo() {
        Hra hra = new Hra("jozko");
        int x = hra.getPad().getPoziciaX() + 5;
        hra.posunVpravo();

        assertEquals(x, hra.getPad().getPoziciaX());
    }

    @Test
    void posunVlavo() {
        Hra hra = new Hra("jozko");
        int x = hra.getPad().getPoziciaX() - 5;
        hra.posunVlavo();

        assertEquals(x, hra.getPad().getPoziciaX());
    }
}