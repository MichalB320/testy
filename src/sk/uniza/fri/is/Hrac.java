package sk.uniza.fri.is;

/**
 * Hrac - túto triedu som prevzal z cvičení a upravil ju
 */
public class Hrac {
    private String meno;
    private String priezvisko;

    public Hrac(String meno, String priezvisko) {
        this.meno = meno;
        this.priezvisko = priezvisko;
    }

    public String getMeno() {
        return this.meno;
    }

    public String getPriezvisko() {
        return this.priezvisko;
    }

    public void premenuj(String meno, String priezvisko) {
        this.meno = meno;
        this.priezvisko = priezvisko;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.meno, this.priezvisko);
    }
}
