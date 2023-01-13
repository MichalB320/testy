package sk.uniza.fri;

import sk.uniza.fri.tvary.Obdlznik;

/**
 * Zivoty - Zivoty počítaju koľko životov ti ostáva v hre.
 * Túto triedu som prevzal z minulej semestrálky
 *
 * @author  Michal Bežo
 * @version 8.1.2021
 */
public class Zivoty {
    private final Obdlznik obdlznik1;
    private final Obdlznik obdlznik2;
    private final Obdlznik obdlznik3;
    private int stav;
    
    /**
     * Konštruktor bez prametrov nám vytvorí 3 Obdlzniky červenej farby na pevne danej pozícii a počíta nám počet životov.
     */
    public Zivoty() {
        this.obdlznik1 = new Obdlznik();
        this.obdlznik2 = new Obdlznik();
        this.obdlznik3 = new Obdlznik();
        
        this.obdlznik1.zmenStrany(3, 15);
        this.obdlznik1.posunVodorovne(-50);
        this.obdlznik1.posunZvisle(220);
        
        this.obdlznik2.zmenStrany(3, 15);
        this.obdlznik2.posunVodorovne(-50 + 6);
        this.obdlznik2.posunZvisle(220);
        
        this.obdlznik3.zmenStrany(3, 15);
        this.obdlznik3.posunVodorovne(-50 + 12);
        this.obdlznik3.posunZvisle(220);
        
        this.obdlznik1.zobraz();
        this.obdlznik2.zobraz();
        this.obdlznik3.zobraz();
        
        this.stav = 0;
    }
    
    /**
     * Zivoty - metóda ti získa späť všetky stratené životy.
     */
    public void ziskajZivoty() { 
        this.obdlznik1.zobraz();
        this.obdlznik2.zobraz();
        this.obdlznik3.zobraz();
    }
    
    /**
     * Zivoty - stratíš život.
     *
     * @param   porCislo - o kolko sa strati zivot
     */
    public void stratZivot(int porCislo) {
        switch (porCislo) {
            case 1:
                this.obdlznik1.zobraz();
                this.obdlznik2.zobraz();
                this.obdlznik3.skry();
                this.stav = 1;

                break;
            case 2:
                this.obdlznik1.zobraz();
                this.obdlznik2.skry();
                this.obdlznik3.skry();

                this.stav = 2;
                break;
            case 3:
                this.obdlznik1.skry();
                this.obdlznik2.skry();
                this.obdlznik3.skry();

                this.stav = 3;
                break;
        }
        
    }
    
    /**
     * Zivoty - vráti zostavajúci počet životov.
     * 
     * @return počet životov
     */
    public int getStav() {
        return this.stav;
    }
}