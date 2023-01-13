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
    void stratZivotTretiKrat() {
        Zivoty zivoty = new Zivoty();
        zivoty.stratZivot(1);
        zivoty.stratZivot(2);
        zivoty.stratZivot(3);

        assertEquals(3, zivoty.getStav());
    }

    @Test
    void stratZivotStvrtyKrat() {
        Zivoty zivoty = new Zivoty();
        zivoty.stratZivot(1);
        zivoty.stratZivot(2);
        zivoty.stratZivot(3);
        zivoty.stratZivot(4);

        assertEquals(4, zivoty.getStav());
    }

    @Test
    void ziskajZivoty() {
        Zivoty zivoty = new Zivoty();
        zivoty.stratZivot(1);
        zivoty.stratZivot(2);

        zivoty.ziskajZivoty();
        assertEquals(0, zivoty.getStav());
    }
}