package sk.uniza.fri;

import sk.uniza.fri.is.HlavneOkno;

/**
 * Trieda {@code Main} slúži na spúšťanie aplikácie.
 *
 * @author  Michal Bežo
 * @version 23.5.2021
 */
public class Main {

    public static void main(String[] args) {
        HlavneOkno okno = new HlavneOkno();
        okno.zobraz();
    }
}
