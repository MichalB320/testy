package sk.uniza.fri.hra.bloky;

import sk.uniza.fri.hra.Pad;

/**
 * BonusovyBlok
 *
 * @author  Michal Bežo
 * @version 23.5.2021
 */
public class BonusovyBlok extends Blok {

    /**
     * Konštruktor bez prametrov nám vytvorí blok z nadtypu.
     */
    public BonusovyBlok(String farba, int strana) {
        super(farba, strana);
    }

    /**
     * BonusovyBlok - getter na zistenie či je blok rozbitný
     *
     * @return ak je rozbytny = true
     */
    @Override
    public boolean jeRozbijatelny() {
        return true;
    }

    /**
     * BonusovyBlok - getter na zistenie či je blok rozbitný na prvý úder
     *
     * @return ak je rozbytny na prvý úder = true
     */
    @Override
    public boolean naPrvyUder() {
        return true;
    }

    /**
     * BonusovyBlok - getter na zistenie či je blok pripraveny sa rozbiť
     *
     * @return ak je pripravený = true
     */
    @Override
    public boolean jeReady() {
        return true;
    }

    /**
     * BonusovyBlok - dokáže zmeniť veľkosť padu
     *
     * @param pad - pad z hry
     */
    @Override
    public void zmenVelkostPadu(Pad pad) {
        pad.zmenVelkostO(50);
    }

    /**
     * BonusovyBlok - bodová hodnota bloku
     *
     * @return hodnota bloku
     */
    @Override
    public int pridajbody() {
        System.out.println("Pridavam 5 bodov");
        return 5;
    }

    /**
     * BonusovyBlok - zmení sa veľkosť bloku
     */
    public void zmenVelkost() {
        this.zmenVelkost(0);
    }
}
