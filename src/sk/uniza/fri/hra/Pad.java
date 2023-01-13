package sk.uniza.fri.hra;

import sk.uniza.fri.tvary.Obdlznik;

/**
 * 18. 5. 2021 - 8:52
 *
 * @author micha
 */
public class Pad {
    private final Obdlznik grafika;
    private int poziciaX;
    private final int poziciaY;
    private int aktualnaVelkost;

    private static final int SIRKA = 50;
    private static final int VYSKA = 5;
    private final int[] intervaly;

    /**
     * Konštruktor bez prametrov nám vytvorí Pad čiernej farby na pevne danej pozícii.
     */
    public Pad(int pozX, int pozY) {
        this.grafika = new Obdlznik();
        this.aktualnaVelkost = 50;
        this.intervaly = new int[7];

        for (int i = 0; i < this.intervaly.length; i++) {
            if (i == 0 || i == 3 || i == 6) {
                this.intervaly[i] = 10;
            } else {
                this.intervaly[i] = 5;
            }
        }

        this.grafika.zmenStrany(SIRKA, VYSKA);

        this.poziciaY = pozY;
        this.poziciaX = pozX;

        this.grafika.posunZvisle(this.poziciaY - 50);
        this.grafika.posunVodorovne(this.poziciaX - 60);

        this.grafika.zmenFarbu("black");

        this.grafika.zobraz();
    }

    /**
     *  Pad - posúva sa vpravo až po okraj platna.
     */
    public void posunVpravo() {
        if (this.poziciaX < (300 - this.aktualnaVelkost)) {          // 250
            this.grafika.posunVodorovne(5);
            this.poziciaX = this.poziciaX + 5;
        }
    }

    /**
     * Pad - posúva sa vlavo až po okraj platna.
     */
    public void posunVlavo() {
        if (this.poziciaX > 0 ) {
            this.grafika.posunVodorovne(-5);
            this.poziciaX = this.poziciaX - 5;
        }
    }

    /**
     * boolean metóda
     * Pad - stred Padu detekuje či je v kolizií s Loptickou.
     *
     * @param   lopticka - lopticka z hry
     * @return  true - ak lopticka koliduje so stredom padu
     */
    public boolean stredKolidujeS(Lopticka lopticka) {
        int loptickaX = lopticka.getStredX();
        int loptickaY = lopticka.getStredY() + 5;

        int padHornyX = this.poziciaX + this.intervaly[0] + this.intervaly[1] + this.intervaly[2];//+17 , + 20
        int padHornyY = this.poziciaY;

        int padDolnyX = this.poziciaX + this.intervaly[0] + this.intervaly[1] + this.intervaly[2] + this.intervaly[3];//+33 , + 30
        int padDolnyY = this.poziciaY + 5;

        return padHornyX <= loptickaX && loptickaX <= padDolnyX && padHornyY <= loptickaY && loptickaY <= padDolnyY;
    }

    /**
     * boolean metóda
     * Pad - pravá strana Padu detekuje či je v kolízií s Loptickou.
     *
     * @param lopticka - lopticka z hry
     * @return true - ak lopticka koliduje s pravou stranou padu
     */
    public boolean prava3KolidujeS(Lopticka lopticka) {
        //this.intervaly[0] = this.aktualnaVelkost / 5;

        int loptickaX = lopticka.getStredX();
        int loptickaY = lopticka.getStredY() + 5;

        int padHornyX = this.poziciaX;
        int padHornyY = this.poziciaY;

        int padDolnyX = this.poziciaX + this.intervaly[0]; // + 10
        int padDolnyY = this.poziciaY + 5;

        return padHornyX <= loptickaX && loptickaX <= padDolnyX && padHornyY <= loptickaY && loptickaY <= padDolnyY;
    }

    /**
     * boolean metóda
     * Pad - pravá strana Padu detekuje či je v kolízií s Loptickou.
     *
     * @param lopticka - lopticka z hry
     * @return true - ak lopticka koliduje s pravou stranou padu
     */
    public boolean prava2KolidujeS(Lopticka lopticka) {


        int loptickaX = lopticka.getStredX();
        int loptickaY = lopticka.getStredY() + 5;

        int padHornyX = this.poziciaX + this.intervaly[0]; // + 10
        int padHornyY = this.poziciaY;

        int padDolnyX = this.poziciaX + this.intervaly[0] + this.intervaly[1]; // 15
        int padDolnyY = this.poziciaY + 5;

        return padHornyX <= loptickaX && loptickaX <= padDolnyX && padHornyY <= loptickaY && loptickaY <= padDolnyY;
    }

    /**
     * boolean metóda
     * Pad - pravá strana Padu detekuje či je v kolízií s Loptickou.
     *
     * @param lopticka - lopticka z hry
     * @return true - ak lopticka koliduje s pravou stranou padu
     */
    public boolean prava1KolidujeS(Lopticka lopticka) {
        int loptickaX = lopticka.getStredX();
        int loptickaY = lopticka.getStredY() + 5;

        int padHornyX = this.poziciaX + this.intervaly[0] + this.intervaly[1]; // + 15
        int padHornyY = this.poziciaY;

        int padDolnyX = this.poziciaX + this.intervaly[0] + this.intervaly[1] + this.intervaly[2]; // + 20
        int padDolnyY = this.poziciaY + 5;

        return padHornyX <= loptickaX && loptickaX <= padDolnyX && padHornyY <= loptickaY && loptickaY <= padDolnyY;
    }

    /**
     * boolean metóda
     * Pad - lavá strana Padu detekuje či je v kolízií s Loptickou.
     *
     * @param lopticka - lopticka z hry
     * @return true - ak lopticka koliduje s lavou stranou padu
     */
    public boolean lava3KolidujeS(Lopticka lopticka) {
        int loptickaX = lopticka.getStredX();
        int loptickaY = lopticka.getStredY() + 5;

        int padHornyX = this.poziciaX + this.intervaly[0] + this.intervaly[1] + this.intervaly[2] + this.intervaly[3] + this.intervaly[4] + this.intervaly[5]; // + 40
        int padHornyY = this.poziciaY;

        int padDolnyX = this.poziciaX + this.intervaly[0] + this.intervaly[1] + this.intervaly[2] + this.intervaly[3] + this.intervaly[4] + this.intervaly[5] + this.intervaly[6]; // + 50
        int padDolnyY = this.poziciaY + 5;

        return padHornyX <= loptickaX && loptickaX <= padDolnyX && padHornyY <= loptickaY && loptickaY <= padDolnyY;
    }

    /**
     * boolean metóda
     * Pad - lavá strana Padu detekuje či je v kolízií s Loptickou.
     *
     * @param lopticka - lopticka z hry
     * @return true - ak lopticka koliduje s lavou stranou padu
     */
    public boolean lava2KolidujeS(Lopticka lopticka) {
        int loptickaX = lopticka.getStredX();
        int loptickaY = lopticka.getStredY() + 5;

        int padHornyX = this.poziciaX + this.intervaly[0] + this.intervaly[1] + this.intervaly[2] + this.intervaly[3] + this.intervaly[4]; // + 35
        int padHornyY = this.poziciaY;

        int padDolnyX = this.poziciaX + this.intervaly[0] + this.intervaly[1] + this.intervaly[2] + this.intervaly[3] + this.intervaly[4] + this.intervaly[5]; // + 40
        int padDolnyY = this.poziciaY + 5;

        return padHornyX <= loptickaX && loptickaX <= padDolnyX && padHornyY <= loptickaY && loptickaY <= padDolnyY;
    }

    /**
     * boolean metóda
     * Pad - lavá strana Padu detekuje či je v kolízií s Loptickou.
     *
     * @param lopticka - lopticka z hry
     * @return true - ak lopticka koliduje s lavou stranou padu
     */
    public boolean lava1KolidujeS(Lopticka lopticka) {
        int loptickaX = lopticka.getStredX();
        int loptickaY = lopticka.getStredY() + 5;

        int padHornyX = this.poziciaX + this.intervaly[0] + this.intervaly[1] + this.intervaly[2] + this.intervaly[3]; // + 30
        int padHornyY = this.poziciaY;

        int padDolnyX = this.poziciaX + this.intervaly[0] + this.intervaly[1] + this.intervaly[2] + this.intervaly[3] + this.intervaly[4]; // + 35
        int padDolnyY = this.poziciaY + 5;

        return padHornyX <= loptickaX && loptickaX <= padDolnyX && padHornyY <= loptickaY && loptickaY <= padDolnyY;
    }

    /**
     * zmeni farbu padu
     *
     * @param farba - zadana v parametri
     */
    public void zmenFarbu(String farba) {
        this.grafika.zmenFarbu(farba);
    }

    /**
     * Pad - zmeni sa velksot padu
     *
     * @param i - velksot
     */
    public void zmenVelkostO(int i) {
        this.aktualnaVelkost = SIRKA + i;
        this.grafika.zmenStrany(this.aktualnaVelkost, VYSKA);

        for (int j = 0; j < this.intervaly.length; j++) {
            if (j == 0 || j == 3 || j == 6) {
                this.intervaly[j] = this.aktualnaVelkost / 5;
            } else {
                this.intervaly[j] = this.aktualnaVelkost / 10;
            }
        }
    }

    public int getPoziciaX() {
        return this.poziciaX;
    }
}