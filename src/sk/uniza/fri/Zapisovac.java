package sk.uniza.fri;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Zapisovac - slúži na zapisovanie štatistík hráčov do súboru.
 * Túto triedu som prevzal z minulej semetrálky
 * 
 * @author  Michal Bežo
 * @version 10.1.2021
 */
public class Zapisovac {
    private final ArrayList<String> diar;
    private final File subor;
    
    /**
     * Koštruktor vytvorí súbor.
     */
    public Zapisovac () {
        this.diar = new ArrayList<>();
        this.subor = new File("statistikyHracov.txt");
    }
    
    /**
     * Zapisovac - číta zo súboru.
     */
    public void citaj() throws IOException {
        Scanner citaj = new Scanner(this.subor);
        this.diar.clear();
        while (citaj.hasNextLine()) {
            String riadok = citaj.nextLine();
            this.diar.add(riadok);
        }
        citaj.close();
    }

    
    /**
     * Zapisovac - zapisuje do súboru.
     */
    public void uloz(String meno, String stavHry, int score) throws IOException {
        this.citaj();
        PrintWriter zapis = new PrintWriter(this.subor);
        this.diar.add(meno + " skončil/-a s dosiahnutým skóre: " + score + " " + stavHry + "/-a. ");

        for (String riadok : this.diar) {
            zapis.println(riadok);
        }
        zapis.close();
    }

}