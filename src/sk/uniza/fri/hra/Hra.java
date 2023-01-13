package sk.uniza.fri.hra;

import sk.uniza.fri.SSD;
import sk.uniza.fri.Score;
import sk.uniza.fri.Zapisovac;
import sk.uniza.fri.Zivoty;
import sk.uniza.fri.hra.bloky.Bloky;
import sk.uniza.fri.tvary.Manazer;


import javax.swing.JOptionPane;
import java.io.IOException;

/**
 * Hra
 *
 * @author  Michal Bežo
 * @version 23.5.2021
 */
public class Hra {
    private final Lopticka lopticka;
    private final Pad pad;
    private final Bloky bloky;
    private final Manazer manazer;
    private final Score score;
    private final SSD ssd;
    private final Zivoty zivot;

    private int tiky;
    private boolean start;

    private final Zapisovac zapis;
    private final String meno;
    private StavHry stavHry;

    /**
     * Konštruktor vytvorí pad, lopticku, bloky, manazera, score, SSD, zivoty a zobrazí dialogové okno s krátkou informaciou o hre a bude si pýtať tvoje meno.
     */
    public Hra(String meno) {
        this.pad = new Pad(125, 280);
        this.lopticka = new Lopticka(145, 250, 0, 0);
        this.bloky = new Bloky();
        this.manazer = new Manazer();

        this.score = new Score();
        this.ssd = new SSD(12, 6, 130, 125);

        this.ssd.zobraz3();
        this.tiky = 3 * 9;

        this.zapis = new Zapisovac();
        this.stavHry = StavHry.NEROZHODNUTA;

        this.zivot = new Zivoty();
        this.zivot.ziskajZivoty();

        this.meno = meno;
        //JOptionPane.showMessageDialog(null, "Máš 3 životy. Káždým padnútím loptičky mimo padu sa ti jeden odoberie. \nKeď budeš mat 0 životov hru si prehral.\nKeď rozibješ všetky bloky alebo získaš 130 bodov hru si vyhral.");
    }

    /**
     * Hra - automatické posuvanie loptikčky.
     */
    public void tik() throws IOException {

        this.tiky = this.tiky - 1;

        if (!this.start) {
            if (this.tiky % 9 == 0) {
                this.ssd.zobrazCifra(this.tiky / 9);
                String sf = String.format("\n %d", this.tiky / 9 + 1);
                System.out.println(sf);
                if (this.tiky / 9 == 0) {
                    this.ssd.zhasniVsetko();
                    this.start = true;

                }
            }
        }

        if (this.start) {
            this.lopticka.posunSa();

            int x = this.lopticka.getStredX();
            int y = this.lopticka.getStredY();

            if (this.pad.prava3KolidujeS(this.lopticka)) {
                this.lopticka.odrazVlavo3();
                //this.score.pridajScore();
                this.pad.zmenFarbu("black");
            } else if (this.pad.prava2KolidujeS(this.lopticka)) {
                this.lopticka.odrazVlavo2();
                //this.score.pridajScore();
                this.pad.zmenFarbu("black");
            } else if (this.pad.prava1KolidujeS(this.lopticka)) {
                this.lopticka.odrazVlavo1();
                //this.score.pridajScore();
                this.pad.zmenFarbu("black");
            } else if (this.pad.stredKolidujeS(this.lopticka)) {
                this.lopticka.odrazRovno();
                //this.score.pridajScore();
                this.pad.zmenFarbu("black");
            } else if (this.pad.lava1KolidujeS(this.lopticka)) {
                this.lopticka.odrazVpravo1();
                //this.score.pridajScore();
                this.pad.zmenFarbu("black");
            } else if (this.pad.lava2KolidujeS(this.lopticka)) {
                this.lopticka.odrazVpravo2();
                //this.score.pridajScore();
                this.pad.zmenFarbu("black");
            } else if (this.pad.lava3KolidujeS(this.lopticka)) {
                this.lopticka.odrazVpravo3();
                //this.score.pridajScore();
                this.pad.zmenFarbu("black");
            }  else if (this.bloky.intersectionHorny(this.lopticka)) {
                this.lopticka.odrazY();
                this.bloky.rozbi(x, y - 5, this.pad);
                this.score.pridajScore(this.bloky.getBodovac());
                //this.score.pridajScore();
                this.pad.zmenFarbu("red");
            } else if (this.bloky.intersectionPravy(this.lopticka)) {
                this.lopticka.odrazX();
                this.bloky.rozbi(x - 5, y, this.pad);
                this.score.pridajScore(this.bloky.getBodovac());
                //this.score.pridajScore();
                this.pad.zmenFarbu("red");
            } else if (this.bloky.intersectionLavy(this.lopticka)) {
                this.lopticka.odrazX();
                this.bloky.rozbi(x + 5, y, this.pad);
                this.score.pridajScore(this.bloky.getBodovac());
                //this.score.pridajScore();
                this.pad.zmenFarbu("red");
            }  else if (this.bloky.intersectionSpodny(this.lopticka)) {
                this.lopticka.odrazY();
                this.bloky.rozbi(x, y + 5, this.pad);
                this.score.pridajScore(this.bloky.getBodovac());
                //this.score.pridajScore();
                this.pad.zmenFarbu("red");
            }

            if (this.lopticka.jeMimoObrazovky()) {
                //int moznost = JOptionPane.showConfirmDialog(null, "Prehral si s počtom score " + this.score.getScore() + ". Chceš hrať odznova?");
                int pocetZivotov = 2 - this.zivot.getStav();
                if (pocetZivotov == 0) {
                    JOptionPane.showMessageDialog(null, "Prehral si, hra sa skonči. \nTvoje získane score je " + this.score.getScore() + " .");
                    this.stavHry = StavHry.PREHRA;
                    this.zapis.uloz(this.meno, "PREHRA", this.score.getScore());
                    this.zrus();

                }
                int moznost = JOptionPane.showConfirmDialog(null, "Ešte máš " + pocetZivotov + " životy. Chceš pokračovať v hre? \nTvoje score je " + this.score.getScore() + " .");

                switch (moznost) {
                    case 0:
                        int i = this.zivot.getStav();
                        this.lopticka.vratDoStredu();
                        if (i == 0) {
                            i = i + 1;
                            this.zivot.stratZivot(i);
                        } else if (i == 1) {
                            i = i + 1;
                            this.zivot.stratZivot(i);
                        } else if (i == 2) {
                            i = i + 1;
                            this.zivot.stratZivot(i);
                        }
                        break;
                    case 1:
                        this.stavHry = StavHry.NEROZHODNUTA;
                        this.zapis.uloz(this.meno, "NEDOKONCIL", this.score.getScore());
                        this.zrus();
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Hra sa skonči.");
                        this.zrus();
                        break;
                }
            }

            if (this.score.getScore() == 130 || this.bloky.isRozbite()) {

                int moznost = JOptionPane.showConfirmDialog(null, "Vyhral/-a si. Tvoje score je " + this.score.getScore() + ". Chceč hrať odznova?");

                switch (moznost) {
                    case 0:
                        this.stavHry = StavHry.VYHRA;
                        this.zapis.uloz(this.meno, "VYHRAL", this.score.getScore());
                        this.lopticka.vratDoStredu();
                        this.bloky.znovaSpojVsetkyBloky();
                        this.score.vyresetuj();
                        this.zivot.ziskajZivoty();
                        break;
                    case 1:
                        this.stavHry = StavHry.VYHRA;
                        this.zapis.uloz(this.meno, "VYHRAL", this.score.getScore());
                        this.zrus();
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Hra sa skonči. ");
                        this.stavHry = StavHry.VYHRA;
                        this.zapis.uloz(this.meno, "VYHRAL", this.score.getScore());
                        this.zrus();
                        break;
                }
            }
        }
    }

    /**
     * Hra - posunie sa Pad vpravo.
     */
    public void posunVpravo() {
        this.pad.posunVpravo();
    }

    /**
     * Hra - posunie sa Pad vlavo.
     */
    public void posunVlavo() {
        this.pad.posunVlavo();
    }

    /**
     * Hra - začiatok hry.
     */
    public void start() {
        this.manazer.spravujObjekt(this);
    }

    /**
     * Hra - koniec hry.
     */
    public void zrus() throws IOException {
        this.zapis.uloz(this.meno, "NEDOKONCIL", this.score.getScore());
        System.exit(0);
    }

    public Lopticka getLopticka() {
        return this.lopticka;
    }

    public Bloky getBloky() {
        return this.bloky;
    }

    public Pad getPad() {
        return this.pad;
    }
}