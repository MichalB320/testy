package sk.uniza.fri.hra.bloky;

import org.junit.jupiter.api.Test;
import sk.uniza.fri.hra.Pad;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 18. 5. 2021 - 8:52
 *
 * @author micha
 */
class BlokTest {

    @Test
    void getRectangleVelkostPat() {
        Blok blok = new Blok("blue", 5) {
            @Override
            public boolean jeRozbijatelny() {
                return false;
            }

            @Override
            public boolean naPrvyUder() {
                return false;
            }

            @Override
            public boolean jeReady() {
                return false;
            }

            @Override
            public void zmenVelkostPadu(Pad pad) {

            }

            @Override
            public int pridajbody() {
                return 0;
            }

            @Override
            public void zmenVelkost() {

            }
        };
        Dimension velkost = blok.getRectangle().getSize();
        assertEquals(5, velkost.getHeight());
    }
}