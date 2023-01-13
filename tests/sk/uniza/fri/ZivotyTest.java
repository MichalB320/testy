package sk.uniza.fri;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 18. 5. 2021 - 8:52
 *
 * @author micha
 */
class ZivotyTest {

    @Test
    void stratZivotPrvyKrat() {
        Zivoty zivoty = new Zivoty();
        zivoty.stratZivot(1);

        assertEquals(1, zivoty.getStav());
    }

    @Test
    void stratZivotDruhyKrat() {
        Zivoty zivoty = new Zivoty();
        zivoty.stratZivot(2);

        assertEquals(2, zivoty.getStav());
    }

    @Test
    void stratZivotTretiKrat() {
        Zivoty zivoty = new Zivoty();
        zivoty.stratZivot(3);

        assertEquals(3, zivoty.getStav());
    }

    @Test
    void stratZivotStvrtyKrat() {
        Zivoty zivoty = new Zivoty();
        zivoty.stratZivot(4);

        assertEquals(4, zivoty.getStav());
    }
}