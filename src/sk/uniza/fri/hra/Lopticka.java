package sk.uniza.fri.hra;

import sk.uniza.fri.tvary.Kruh;

import java.awt.Rectangle;
import java.util.Random;

/**
 * RozbijatelnyBlok
 *
 * @author  Michal Bežo
 * @version 23.5.2021
 */
public class Lopticka  {
    private final Kruh grafika;
//    private final Rectangle horny;
//    private final Rectangle pravy;
//    private final Rectangle lavy;
//    private final Rectangle spodny;

    private final Rectangle[] rects;
    private int poziciaX;
    private int poziciaY;
    private int smerX;
    private int smerY;

    private static final int PRIEMER_LOPTY = 11;

    /**
     * Konštruktor bez prametrov nám vytvorí Loptičku čiernej farby na pevne danej pozícii.
     * Vytvorý nám neviditelný štvorec na vrchu loptičky, pravej, lavej strane loptičky a na spodu nej. Štvorec má dôležitú úlohu pri kolízii.
     * Tento konštruktor nám určí smer padania Loptičky.
     */
    public Lopticka(int pozX, int pozY, int smerX, int smerY) {
        this.grafika = new Kruh();

        this.rects = new Rectangle[4];

//        this.horny = new Rectangle();
//        this.pravy = new Rectangle();
//        this.lavy = new Rectangle();
//        this.spodny = new Rectangle();
        Random nahodneCisla = new Random();

        this.grafika.zmenFarbu("black");
        this.grafika.zmenPriemer(PRIEMER_LOPTY);
        //this.grafika.posunVodorovne(125);
        //this.grafika.posunZvisle(160 + 35);
        this.grafika.posunVodorovne(pozX);
        this.grafika.posunZvisle(pozY);
        //this.poziciaX = 145;
        //this.poziciaY = 220 + 35;
        this.poziciaX = pozX;
        this.poziciaY = pozY;

        for (int i = 0; i < this.rects.length; i++) {
            Rectangle r = new Rectangle();
            this.rects[i] = r;
        }

        this.rects[0].move(this.poziciaX + 4, this.poziciaY);
        this.rects[0].resize(3, 3);
        //this.horny.move(this.poziciaX + 4, this.poziciaY);
        //this.horny.resize(3, 3);

        this.rects[1].move(this.poziciaX, this.poziciaY + 5);
        this.rects[1].resize(3, 1);
        //this.pravy.move(this.poziciaX, this.poziciaY + 5);
        //this.pravy.resize(3, 1);

        this.rects[2].move(this.poziciaX + 9, this.poziciaY + 5);
        this.rects[2].resize(3, 1);
        //this.lavy.move(this.poziciaX + 9, this.poziciaY + 5);
        //this.lavy.resize(3, 1);

        this.rects[3].move(this.poziciaX + 4, this.poziciaY + 9);
        this.rects[3].resize(3, 3);
        //this.spodny.move(this.poziciaX + 4, this.poziciaY + 9);
        //this.spodny.resize(3, 3);

        this.grafika.zobraz();

        switch (nahodneCisla.nextInt(2)) {
            case 0:
                this.smerX = -5;
                this.smerY = 5;
                break;

            case 1:
                this.smerX = 5;
                this.smerY = 5;
                break;
        }
    }

    /**
     * Lopticka - Pri prvom posunutí na začiatku hry sa rozhoduje ktorým smerom bude Lopticka padať. Pri ostatných posunoch padá rovnakým smerom.
     */
    public void posunSa() {
        if (this.poziciaX <= 0 || this.poziciaX >= 290) {
            this.smerX = -this.smerX;

        } else if (this.poziciaY <= 0) {
            this.smerY = -this.smerY;
        }

        this.grafika.skry();


        this.grafika.posunVodorovne(this.smerX);
        this.grafika.posunZvisle(this.smerY);

        this.poziciaY += this.smerY;
        this.poziciaX += this.smerX;

        //this.horny.move(this.poziciaX + 4, this.poziciaY);
        this.rects[0].move(this.poziciaX + 4, this.poziciaY);

        //this.pravy.move(this.poziciaX, this.poziciaY + 5);
        this.rects[1].move(this.poziciaX , this.poziciaY + 5);

        //this.lavy.move(this.poziciaX + 9, this.poziciaY + 5);
        this.rects[2].move(this.poziciaX + 9, this.poziciaY + 5);

        //this.spodny.move(this.poziciaX + 4, this.poziciaY + 9);
        this.rects[3].move(this.poziciaX + 4, this.poziciaY + 9);

        this.grafika.zobraz();
    }

    /**
     * Lopticka - odrazí sa smer padania Lopticky smerom hore alebo dole po y-ovej osi.
     */
    public void odrazY() {
        this.smerY = -this.smerY;
    }

    /**
     * Lopticka - odrazí sa smer padania Lopticky smerom vpravo alebo vlavo po x-ovej osi.
     */
    public void odrazX() {
        this.smerX = -this.smerX;
    }

    /**
     * Lopticka - Lopticka zmení smer padania po y-ovej osi a po x-ovej osi sa nebude pohybovať.
     */
    public void odrazRovno() {
        this.smerX = 0;
        this.smerY = -this.smerY;
    }

    /**
     * Lopticka - zmení smer padania po y-ovej osi a smer padania po x-ovej osi smerom vpravo bude padať najrýchlejšie.
     */
    public void odrazVpravo3() {
        this.smerX = 5;
        this.smerY = -5;
    }

    /**
     * Lopticka - zmení smer padania po y-ovej osi a smer padania po x-ovej osi smerom vpravo.
     */
    public void odrazVpravo2() {
        this.smerX = 2;
        this.smerY = -7;
    }

    /**
     * Lopticka - zmení smer padania po y-ovej osi a smer padania po x-ovej osi smerom vpravo bude padať pomaly.
     */
    public void odrazVpravo1() {
        this.smerX = 1;
        this.smerY = -7;
    }

    /**
     * Lopticka - zmení smer padanie po y-ovej osi a smer padania po x-ovej osi smerom vlavo bude padať pomaly.
     */
    public void odrazVlavo1() {
        this.smerX = -1;
        this.smerY = -7;
    }

    /**
     * Lopticka - zmení smer padanie po y-ovej osi a smer padania po x-ovej osi smerom vlavo.
     */
    public void odrazVlavo2() {
        this.smerX = -2;
        this.smerY = -7;
    }

    /**
     * Lopticka - zmení smer padanie po y-ovej osi a smer padania po x-ovej osi smerom vlavo bude padať najrýchlejšie.
     */
    public void odrazVlavo3() {
        this.smerX = -5;
        this.smerY = -5;
    }

    /**
     * boolean metóda
     * Lopticka - detekuje či sa Lopticka nachádza mimo plátna.
     * @return  ak je poziciaY väčšia ako 300.
     */
    public boolean jeMimoObrazovky() {
        return this.poziciaY > 300;
    }

    /**
     * Lopticka - ak vyjde z obrazovky vrati sa naspäť.
     */
    public void vratDoStredu() {
        Random nahodneCisla = new Random();

        int staraPoziciaX = this.poziciaX;
        int staraPoziciaY = this.poziciaY;

        this.poziciaX = nahodneCisla.nextInt(261) + 20;
        this.poziciaY = 143;

        this.grafika.skry();
        this.grafika.posunVodorovne(this.poziciaX - staraPoziciaX);
        this.grafika.posunZvisle(this.poziciaY - staraPoziciaY);
        this.grafika.zobraz();

        switch (nahodneCisla.nextInt(4)) {
            case 0:
                this.smerX = -5;
                this.smerY = 5;
                break;
            case 1:
                this.smerX = 5;
                this.smerY = 5;
                break;
            case 2:
                this.smerX = -5;
                this.smerY = -5;
                break;
            default:
                this.smerX = 5;
                this.smerY = -5;
                break;
        }
    }

    /**
     * Lopticka - vráti stred x-ovej súradnice Lopticky.
     * @return  pozicia x-ovej súradnice + 6.
     */
    public int getStredX() {
        return this.poziciaX + 6;
    }

    /**
     * Lopticka - vráti stred y-ovej súradnice Lopticky.
     * @return  pozicia y-ovej súradnice +6.
     */
    public int getStredY() {
        return this.poziciaY + 6;
    }

    /**
     * Lopticka - vráti hranice štvorca okolo Lopticky.
     *
     * @param   i - index
     * @return  dostaneme hranice spodneho bodu v lopticke.
     */
    public Rectangle getBounds(int i) {
        return this.rects[i].getBounds();
    }

    public void zmenFarbu(String farba) {
        this.grafika.zmenFarbu(farba);
    }

    public int getPoziciaX() {
        return this.poziciaX;
    }

    public int getPoziciaY() {
        return this.poziciaY;
    }

    public int getSmerX() {
        return this.smerX;
    }

    public int getSmerY() {
        return this.smerY;
    }
}