package sk.uniza.fri;

import sk.uniza.fri.tvary.Obdlznik;

/**
 * Túto triedu som prevzial z cvičení.
 */
public class Segment {
    private final Obdlznik obdlznik;
    
    public Segment(int dlzkaSegmentu, int hrubkaSegmentu, int poziciaX, int poziciaY) {
        this.obdlznik = new Obdlznik();
        this.obdlznik.zmenStrany(dlzkaSegmentu, hrubkaSegmentu);
        this.obdlznik.posunVodorovne(poziciaX - 60);
        this.obdlznik.posunZvisle(poziciaY - 50);
    }
    
    public void rozsviet() {
        this.obdlznik.zobraz();
    }
    
    public void zhasni() {
        this.obdlznik.skry();
    }
}
