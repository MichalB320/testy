package sk.uniza.fri.hra.bloky;

import sk.uniza.fri.hra.Lopticka;
import sk.uniza.fri.hra.Pad;

import java.awt.Rectangle;
import java.util.Random;

/**
 * Bloky - Bloky sa nakreslia na Platno a rozbíjajú sa.
 *
 * @author  Michal Bežo
 * @version 23.5.2021
 */
public class Bloky {
    private final Blok[][] bloky;
    private int bodovac;

    private static final int SIRKA = 21;
    private static final int VYSKA = 6;
    private static final int STRANA = 16;
    private static final int ROZOSTUP = 18;

    /**
     * Konštruktor bez prametrov nám vytvorí Bloky rôznych typov na pevne danej pozícii a uložia sa do dvojrozmerného pola bloky.
     */
    public Bloky() {
        this.bloky = new Blok[VYSKA][SIRKA];
        Random nahoda = new Random();

        this.bodovac = 0;

        int yB = nahoda.nextInt(VYSKA);
        int xB = nahoda.nextInt(SIRKA);

        for (int y = 0; y < VYSKA; y++) {
            for (int x = 0; x < SIRKA; x++) {
                if ((y == 5 && x <= 7) || (y == 2 && x >= 10)) {
                    NerozbijatelnyBlok blok = new NerozbijatelnyBlok("black", STRANA);
                    blok.posunVodorovne(x * ROZOSTUP - 60);
                    blok.posunZvisle(y * ROZOSTUP - 50);
                    blok.moveR(x * ROZOSTUP, y * ROZOSTUP);
                    //blok.zmenFarbu("red");
                    blok.zobraz();
                    this.bloky[y][x] = blok;
                } else if (y == yB && x == xB) {
                    BonusovyBlok blok = new BonusovyBlok("blue", STRANA);
                    blok.posunVodorovne(x * ROZOSTUP - 60);
                    blok.posunZvisle(y * ROZOSTUP - 50);
                    blok.moveR(x * ROZOSTUP, y * ROZOSTUP);
                    blok.zobraz();
                    this.bloky[y][x] = blok;
                } else {
                    RozbijatelnyBlok blok = new RozbijatelnyBlok("black", STRANA);
                    blok.posunVodorovne(x * ROZOSTUP - 60);
                    blok.posunZvisle(y * ROZOSTUP - 50);
                    blok.moveR(x * ROZOSTUP, y * ROZOSTUP);
                    blok.zobraz();
                    this.bloky[y][x] = blok;
                }

            }
        }

    }

    /**
     * boolean metóda
     * Bloky - detekuje či dochádza ku kolízii lopticky s blokmi.
     *
     * @param   lopticka - lopticka z hry
     * @return  ak vrch lopticky koliduje s blokmi = true
     */
    public boolean intersectionHorny(Lopticka lopticka) {
        //Rectangle r1 = lopticka.getBoundsHorny();
        Rectangle r1 = lopticka.getBounds(0);

        for (int y = 0; y < VYSKA; y++) {
            for (int x = 0; x < SIRKA; x++) {
                Rectangle rect = this.bloky[y][x].getRectangle();

                if (rect.intersects(r1)) {
                    this.bloky[y][x].zmenVelkost();
                    this.bodovac = this.bloky[y][x].pridajbody();
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * boolean metóda
     * Bloky - detekuje či dochádza ku kolízii lopticky s blokmki.
     *
     * @param   lopticka - lopticka z hry
     * @return  ak prava strana lopticky koliduje s blokmi = true
     */
    public boolean intersectionPravy(Lopticka lopticka) {
        //Rectangle r1 = lopticka.getBoundsPravy();
        Rectangle r1 = lopticka.getBounds(1);

        for (int y = 0; y < VYSKA; y++) {
            for (int x = 0; x < SIRKA; x++) {
                Rectangle rect = this.bloky[y][x].getRectangle();

                if (rect.intersects(r1)) {
                    this.bloky[y][x].zmenVelkost();
                    this.bodovac = this.bloky[y][x].pridajbody();
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * boolean metóda
     * Bloky - detekuje či dochádza ku kolízii lopticky s blokmki.
     *
     * @param   lopticka - lopticka z hry
     * @return  ak lavá strana lopticky koliduje s blokmi = true
     */
    public boolean intersectionLavy(Lopticka lopticka) {
        //Rectangle r1 = lopticka.getBoundsLavy();
        Rectangle r1 = lopticka.getBounds(2);

        for (int y = 0; y < VYSKA; y++) {
            for (int x = 0; x < SIRKA; x++) {
                Rectangle rect = this.bloky[y][x].getRectangle();

                if (rect.intersects(r1)) {
                    this.bloky[y][x].zmenVelkost();
                    this.bodovac = this.bloky[y][x].pridajbody();
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * boolean metóda
     * Bloky - detekuje či dochádza ku kolízii lopticky s blokmki.
     *
     * @param   lopticka - lopticka z hry
     * @return  ak spod lopticky koliduje s blokmi = true
     */
    public boolean intersectionSpodny(Lopticka lopticka) {
        //Rectangle r1 = lopticka.getBoundsSpodny();
        Rectangle r1 = lopticka.getBounds(3);

        for (int y = 0; y < VYSKA; y++) {
            for (int x = 0; x < SIRKA; x++) {
                Rectangle rect = this.bloky[y][x].getRectangle();

                if (rect.intersects(r1)) {
                    this.bloky[y][x].zmenVelkost();
                    this.bodovac = this.bloky[y][x].pridajbody();
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Bloky - v určitom bloku sa blok skryje a štvorec okolo bloku zmení pozíciu mimo plátna.
     *
     * @param   x, y
     */
    public void rozbi(int x, int y, Pad pad) {
        int riadok = y / ROZOSTUP;
        int stlpec = x / ROZOSTUP;

        //pre bonusovy
        if (this.bloky[riadok][stlpec].jeRozbijatelny() && this.bloky[riadok][stlpec].naPrvyUder() && this.bloky[riadok][stlpec].jeReady()) {
            this.bloky[riadok][stlpec].skry();
            this.bloky[riadok][stlpec].moveR(-20, -20);
            this.bloky[riadok][stlpec].zmenVelkostPadu(pad);
            //pre rozbijatelne
        } else if (this.bloky[riadok][stlpec].jeRozbijatelny() && !this.bloky[riadok][stlpec].naPrvyUder() && this.bloky[riadok][stlpec].jeReady()) {
            this.bloky[riadok][stlpec].skry();
            this.bloky[riadok][stlpec].moveR(-20, -20);
            this.bloky[riadok][stlpec].zmenVelkostPadu(pad);
            //pre nerozbitelny
        } else {
            this.bloky[riadok][stlpec].zmenVelkostPadu(pad);
        }
        System.out.format("%d, %d (%d, %d)%n", x, y, stlpec, riadok);
    }

    /**
     * Bloky - bloky sa zobrazia na svojej pôvodnej pozícii.
     */
    public void znovaSpojVsetkyBloky() {
        for (int y = 0; y < VYSKA; y++) {
            for (int x = 0; x < SIRKA; x++) {
                this.bloky[y][x].zobraz();
                this.bloky[y][x].moveR(x * ROZOSTUP, y * ROZOSTUP);
                this.bloky[y][x].zmenVelkost(STRANA);
            }
        }
    }

    /**
     * int metóda
     * Bloky - veáti počet bodov.
     *
     * @return  vráti počet bodov
     */
    public int getBodovac() {
        return this.bodovac;
    }

    /**
     * boolean metóda
     * Bloky - detekuje či je blok robity.
     *
     * @return  ak je blok rozbity = true
     */
    public boolean isRozbite() {
        boolean jeMimo = false;

        for (int y = 0; y < VYSKA; y++) {
            for (int x = 0; x < SIRKA; x++) {
                jeMimo = this.bloky[y][x].getX() == -20;
            }
        }
        return jeMimo;
    }

    public Blok[][] getBloky() {
        return this.bloky;
    }

}