package sk.uniza.fri.hra.bloky;

import sk.uniza.fri.hra.Pad;
import sk.uniza.fri.tvary.Stvorec;

import java.awt.Rectangle;

/**
 * Blok - Abstraktna tireda.
 *
 * @author  Michal Bežo
 * @version 23.5.2021
 */
public abstract class Blok {
    private final Stvorec grafika;
    private final Rectangle rect;
    private final int velkost;
    private int x;
    private int y;

    /**
     * Konštruktor s parametrami farba, strna nám vytvorí blok s velkostou z paramaetra s farbou z parametra.
     */
    public Blok(String farba, int strana) {
        this.grafika = new Stvorec();
        this.rect = new Rectangle();

        this.velkost = strana;

        this.grafika.zmenFarbu(farba);
        this.grafika.zmenStranu(strana);

        //this.rect.resize(strana, strana);
        this.rect.setSize(strana, strana);
    }

    /**
     *  Blok - môže posunúť blok vodorovne o určitú veľkosť z parametra.
     *
     *  @param   velkost - o kolko sa posunie
     */
    public void posunVodorovne(int velkost) {
        this.grafika.posunVodorovne(velkost);
    }

    /**
     *  Blok - môže posunúť blok zvisle o určitú veľkosť z parametra.
     *
     *  @param   velkost - o kolko sa posunie
     */
    public void posunZvisle(int velkost) {
        this.grafika.posunZvisle(velkost);
    }

    /**
     * Blok - môže presunúť rectangle na súradnice z parametra
     *
     * @param x - suradnica
     * @param y - suradnica
     */
    public void moveR(int x, int y) {
        this.x = x;
        this.y = y;
        this.rect.setLocation(x, y);
    }

    /**
     * Blok - zmení veľkosť štvorca
     *
     * @param i - o kolko sa zmensi
     */
    public void zmenVelkost(int i ) {
        this.grafika.zmenStranu(i);
        this.rect.setSize(i, i);
    }

    /**
     * Blok - zobrazí blok
     */
    public void zobraz() {
        this.grafika.zobraz();
    }

    /**
     * Blok - skryje blok
     */
    public void skry() {
        this.grafika.skry();
    }

    /**
     * Blok - vrati rectangle
     *
     * @return Rectangle
     */
    public  Rectangle getRectangle() {
        return this.rect;
    }

    /**
     * Blok - vráti štvorec
     *
     * @return Stvorec
     */
    public Stvorec getGrafika() {
        return this.grafika;
    }

    /**
     * Blok - vráti veľkosť strany štvorca
     *
     * @return velkost strany Stvorca
     */
    public int getStrana() {
        return this.velkost;
    }

    /**
     * Blok - vráti x-ovú súradnicu štvorca
     *
     * @return x
     */
    public int getX() {
        return this.x;
    }

    /**
     * Blok - vráti y-ovú súradnicu štvorca
     *
     * @return y
     */
    public int getY() {
        return this.y;
    }

    /**
     * Blok - abstraktná metóda
     *
     * @return jeRozbitny
     */
    public abstract boolean jeRozbijatelny();

    /**
     * Blok - abstraktná metóda
     *
     * @return naPrvyUder
     */
    public abstract boolean naPrvyUder();

    /**
     * Blok - abstraktná metóda
     *
     * @return jeReady
     */
    public abstract boolean jeReady();

    /**
     * Blok - abstraktná metóda
     *
     * @param pad - pad z hry
     */
    public abstract void zmenVelkostPadu(Pad pad);

    /**
     * Blok - abstraktná metóda
     *
     * @return pridajBody
     */
    public abstract int pridajbody();

    /**
     * Blok - abstraktná metóda
     */
    public abstract void zmenVelkost();

}
