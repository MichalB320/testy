package sk.uniza.fri.hra.bloky;

import sk.uniza.fri.hra.Pad;

/**
 * NerozbijatelnyBlok
 *
 * @author  Michal Bežo
 * @version 23.5.2021
 */
public class NerozbijatelnyBlok extends Blok {
    private boolean udrel;

    /**
     * Konštruktor bez prametrov nám vytvorí blok z nadtypu.
     */
    public NerozbijatelnyBlok(String farba, int strana) {
        super(farba, strana);
        this.udrel = false;
    }

    /**
     * NerozbijatelnyBlok - getter na zistenie či je blok rozbitný
     *
     * @return ak je rozbytny = true
     */
    @Override
    public boolean jeRozbijatelny() {
        return false;
    }

    /**
     * NerozbijatelnyBlok - getter na zistenie či je blok rozbitný na prvý úder
     *
     * @return ak je rozbytny na prvý úder = true
     */
    @Override
    public boolean naPrvyUder() {
        return false;
    }

    /**
     * NerozbijatelnyBlok - getter na zistenie či je blok pripraveny sa rozbiť
     *
     * @return ak je pripravený = true
     */
    @Override
    public boolean jeReady() {
        return false;
    }

    /**
     * NerozbijatelnyBlok - dokáže zmeniť veľkosť padu
     *
     * @param pad - pad z hry
     */
    @Override
    public void zmenVelkostPadu(Pad pad) {
        pad.zmenVelkostO(-25);
    }

    /**
     * NerozbijatelnyBlok - bodová hodnota bloku
     *
     * @return hodnota bloku
     */
    @Override
    public int pridajbody() {
        //score.pridajScore(-1);

        if (this.udrel) {
            System.out.println("odoberam bod");
            return -1;
        } else {
            System.out.println("odoberam 5 bodov");
            return -5;
        }

    }

    /**
     * NerozbijatelnyBlok - zmení sa veľkosť bloku
     */
    public void zmenVelkost() {
        int aktualnaVelkost = this.getStrana();

        if (!this.udrel) {
            this.skry();
            this.zmenVelkost(aktualnaVelkost + 2);
            this.posunVodorovne(-1);
            this.posunZvisle(-1);
            this.zobraz();

            this.moveR(this.getX() - 1, this.getY() - 1);

            this.zmenFarbu();

            this.udrel = !this.udrel;
        }

    }

    /**
     * NerozbijatelnyBlok - zmení farbu bloku
     */
    private void zmenFarbu() {
        this.getGrafika().zmenFarbu("red");
    }
}
