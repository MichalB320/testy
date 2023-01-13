package sk.uniza.fri.is;

import sk.uniza.fri.hra.Hra;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Dimension;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * HlavneOkno - túto triedu som prevzal z cvičení a upravil ju.
 */
public class HlavneOkno {
    private final DefaultListModel<Hrac> zoznamHracov;
    private JPanel isHrac;
    private JList<Hrac> hraci;
    private JTextField meno;
    private JTextField priezvisko;
    private JButton novy;
    private JButton editovat;
    private JButton vymazat;
    private JButton hraj;
    private JButton uloz;
    private JFrame okno;


    private static final int SAVE_MAGIC_NUMBER = 0x72951413;
    private static final int SAVE_VERZIA = 2;

    public HlavneOkno() {
        this.zoznamHracov = new DefaultListModel<>();

        this.hraci.setModel(this.zoznamHracov);

        this.novy.addActionListener(e -> this.novyHrac());
        this.editovat.addActionListener(e -> this.editujHraca());
        this.vymazat.addActionListener(e -> this.vymazHraca());

        DocumentListener kontrolaZmeny = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                HlavneOkno.this.aktualizujPovoleniaTlacitok();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                HlavneOkno.this.aktualizujPovoleniaTlacitok();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                HlavneOkno.this.aktualizujPovoleniaTlacitok();
            }
        };

        this.hraci.addListSelectionListener(e -> this.zmenaOznaceniaHraca());

        this.priezvisko.getDocument().addDocumentListener(kontrolaZmeny);
        this.meno.getDocument().addDocumentListener(kontrolaZmeny);

        this.hraj.addActionListener(e -> this.spustiHru());
        this.uloz.addActionListener(e -> this.ulozHracov());

        this.nacitajHracov();

        this.aktualizujPovoleniaTlacitok();
    }

    private void nacitajHracov() {
        File suborPozicie = new File("hraci" + ".arksave");

        if (!suborPozicie.exists()) {
            System.out.println("Taky save nemas");
            return;
        }

        try (DataInputStream vstup = new DataInputStream(new FileInputStream(suborPozicie))) {
            int magicNumber = vstup.readInt();
            if (magicNumber != HlavneOkno.SAVE_MAGIC_NUMBER) {
                System.out.println("Tento subor nie je platnou poziciou hry WOF");
                return;
            }
            int saveVerzia = vstup.readInt();
            if (saveVerzia > HlavneOkno.SAVE_VERZIA) {
                System.out.println("Tento save bol vyprodukovany v novsej verzii hry");
                return;
            }
            int velkost = vstup.readInt();

            for (int i = 0; i < velkost; i++) {
                String menoHraca = vstup.readUTF();
                String priezviskoHraca = vstup.readUTF();

                Hrac hrac = new Hrac(menoHraca, priezviskoHraca);

                this.zoznamHracov.addElement(hrac);
            }
        } catch (IOException e) {
            System.out.println("Nepodarilo sa nacitat poziciu");
            e.printStackTrace();
        }
    }

    private void ulozHracov() {
        File suborPozicie = new File("hraci" + ".arksave");
        try (DataOutputStream vystup = new DataOutputStream(new FileOutputStream(suborPozicie))) {
            vystup.writeInt(HlavneOkno.SAVE_MAGIC_NUMBER);
            vystup.writeInt(HlavneOkno.SAVE_VERZIA);
            int velkost = this.zoznamHracov.getSize();
            vystup.writeInt(velkost);

            for (int i = 0; i < this.zoznamHracov.getSize(); i++) {
                vystup.writeUTF(this.zoznamHracov.get(i).getMeno());
                vystup.writeUTF(this.zoznamHracov.get(i).getPriezvisko());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nepodarilo sa ulozit poziciu, asi zly nazov saveu");
        } catch (IOException e) {
            System.out.println("Nepodarilo sa ulozit poziciu");
            e.printStackTrace();
        }
    }

    private void aktualizujPovoleniaTlacitok() {
        Hrac oznacenyHrac = this.hraci.getSelectedValue();
        boolean menoPriezviskoZadane = !this.meno.getText().isEmpty() && !this.priezvisko.getText().isEmpty();

        this.novy.setEnabled(menoPriezviskoZadane);
        this.vymazat.setEnabled(oznacenyHrac != null);

        if (oznacenyHrac == null || !menoPriezviskoZadane) {
            this.editovat.setEnabled(false);
            this.hraj.setEnabled(false);
        } else {
            boolean menoPriezviskoZmenene = !this.meno.getText().equals(oznacenyHrac.getMeno())
                    || !this.priezvisko.getText().equals(oznacenyHrac.getPriezvisko());

            this.editovat.setEnabled(menoPriezviskoZmenene);

            this.hraj.setEnabled(true);
        }
    }

    private void zmenaOznaceniaHraca() {
        Hrac oznacenyHrac = this.hraci.getSelectedValue();
        if (oznacenyHrac != null) {
            this.meno.setText(oznacenyHrac.getMeno());
            this.priezvisko.setText(oznacenyHrac.getPriezvisko());
        }

        this.aktualizujPovoleniaTlacitok();
    }

    private void novyHrac() {
        String menoHraca = this.meno.getText();
        String priezviskoHraca = this.priezvisko.getText();

        Hrac hrac = new Hrac(menoHraca, priezviskoHraca);
        this.zoznamHracov.addElement(hrac);
    }

    private void editujHraca() {
        Hrac oznacenyHrac = this.hraci.getSelectedValue();

        String menoHraca = this.meno.getText();
        String priezviskoHraca = this.priezvisko.getText();

        oznacenyHrac.premenuj(menoHraca, priezviskoHraca);

        this.hraci.updateUI();

        this.aktualizujPovoleniaTlacitok();
    }

    private void vymazHraca() {
        Hrac oznacenyHrac = this.hraci.getSelectedValue();
        this.zoznamHracov.removeElement(oznacenyHrac);
    }

    public void zobraz() {
        this.okno = new JFrame("Arkanoid");
        this.okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.okno.add(this.isHrac);
        this.okno.pack();
        this.okno.setMinimumSize(new Dimension(350, 250));
        this.okno.setVisible(true);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            System.out.println("sorry!");
        }
    }

    public void spustiHru() {
        Hrac oznacenyHrac = this.hraci.getSelectedValue();
        String menoL = oznacenyHrac.getMeno();
        this.okno.setVisible(false);
        Hra hra = new Hra(menoL);
        hra.start();
    }
}
