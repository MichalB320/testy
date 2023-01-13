package sk.uniza.fri.hra.bloky;

import sk.uniza.fri.hra.Pad;

/**
 * RozbijatelnyBlok
 *
 * @author  Michal Bežo
 * @version 23.5.2021
 */
public class RozbijatelnyBlok extends Blok {
    private boolean jeReadey;

    /**
     * Konštruktor bez prametrov nám vytvorí blok z nadtypu.
     */
    public RozbijatelnyBlok(String farba, int velkost) {
        super(farba, velkost);
        this.jeReadey = true;
    }

    /**
     * NerozbijatelnyBlok - getter na zistenie či je blok rozbitný
     *
     * @return ak je rozbytny = true
     */
    @Override
    public boolean jeRozbijatelny() {
        return true;
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
        return this.jeReadey;
    }

    /**
     * NerozbijatelnyBlok - dokáže zmeniť veľkosť padu
     *
     * @param pad - pad z hry
     */
    @Override
    public void zmenVelkostPadu(Pad pad) {
        pad.zmenVelkostO(25);
    }

    /**
     * NerozbijatelnyBlok - bodová hodnota bloku
     *
     * @return hodnota bloku
     */
    @Override
    public int pridajbody() {
        System.out.println("pridavam 1 bodov");
        return 1;
    }

    /**
     * NerozbijatelnyBlok - zmení sa veľkosť bloku
     */
    public void zmenVelkost() {
        int aktualnaVelkost = this.getStrana();

        this.skry();
        this.zmenVelkost(aktualnaVelkost - 5);
        this.posunZvisle(3);
        this.posunVodorovne(3);
        this.zobraz();


        this.moveR(this.getX() + 3, this.getY() + 3);

        this.jeReadey = !this.jeReadey;
    }
}
