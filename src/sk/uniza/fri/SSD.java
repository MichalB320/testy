package sk.uniza.fri;

/**
 * Túto triedu som prevzial z cvičení.
 */

public class SSD { 
    private final Segment segmentA;
    private final Segment segmentB;
    private final Segment segmentC;
    private final Segment segmentD;
    private final Segment segmentE;
    private final Segment segmentF;
    private final Segment segmentG;
    
    public SSD(int dlzkaSegmentu, int hrubkaSegmentu, int poziciaDisplejaX, int poziciaDisplejaY) {
        this.segmentA = new Segment(dlzkaSegmentu, hrubkaSegmentu, poziciaDisplejaX + hrubkaSegmentu, poziciaDisplejaY);
        this.segmentB = new Segment(hrubkaSegmentu, dlzkaSegmentu, poziciaDisplejaX + hrubkaSegmentu + dlzkaSegmentu, poziciaDisplejaY + hrubkaSegmentu);
        this.segmentC = new Segment(hrubkaSegmentu, dlzkaSegmentu, poziciaDisplejaX + hrubkaSegmentu + dlzkaSegmentu, poziciaDisplejaY + hrubkaSegmentu + hrubkaSegmentu + dlzkaSegmentu);
        this.segmentD = new Segment(dlzkaSegmentu, hrubkaSegmentu, poziciaDisplejaX + hrubkaSegmentu, poziciaDisplejaY + hrubkaSegmentu + hrubkaSegmentu + dlzkaSegmentu + dlzkaSegmentu);
        this.segmentE = new Segment(hrubkaSegmentu, dlzkaSegmentu, poziciaDisplejaX, poziciaDisplejaY + hrubkaSegmentu + hrubkaSegmentu + dlzkaSegmentu);
        this.segmentF = new Segment(hrubkaSegmentu, dlzkaSegmentu, poziciaDisplejaX, poziciaDisplejaY + hrubkaSegmentu);
        this.segmentG = new Segment(dlzkaSegmentu, hrubkaSegmentu, poziciaDisplejaX + hrubkaSegmentu, poziciaDisplejaY + hrubkaSegmentu + dlzkaSegmentu);
    }

    private void zobraz0() {
        this.segmentA.rozsviet();
        this.segmentB.rozsviet();
        this.segmentC.rozsviet();
        this.segmentD.rozsviet();
        this.segmentE.rozsviet();
        this.segmentF.rozsviet();
        this.segmentG.zhasni();
    }

    private void zobraz1() {
        this.segmentA.zhasni();
        this.segmentB.rozsviet();
        this.segmentC.rozsviet();
        this.segmentD.zhasni();
        this.segmentE.zhasni();
        this.segmentF.zhasni();
        this.segmentG.zhasni();
    }

    private void zobraz2() {
        this.segmentA.rozsviet();
        this.segmentB.rozsviet();
        this.segmentC.zhasni();
        this.segmentD.rozsviet();
        this.segmentE.rozsviet();
        this.segmentF.zhasni();
        this.segmentG.rozsviet();
    }

    public void zobraz3() {
        this.segmentA.rozsviet();
        this.segmentB.rozsviet();
        this.segmentC.rozsviet();
        this.segmentD.rozsviet();
        this.segmentE.zhasni();
        this.segmentF.zhasni();
        this.segmentG.rozsviet();
    }

    private void zobraz4() {
        this.segmentA.zhasni();
        this.segmentB.rozsviet();
        this.segmentC.rozsviet();
        this.segmentD.zhasni();
        this.segmentE.zhasni();
        this.segmentF.rozsviet();
        this.segmentG.rozsviet();
    }

    private void zobraz5() {
        this.segmentA.rozsviet();
        this.segmentB.zhasni();
        this.segmentC.rozsviet();
        this.segmentD.rozsviet();
        this.segmentE.zhasni();
        this.segmentF.rozsviet();
        this.segmentG.rozsviet();
    }

    private void zobraz6() {
        this.segmentA.rozsviet();
        this.segmentB.zhasni();
        this.segmentC.rozsviet();
        this.segmentD.rozsviet();
        this.segmentE.rozsviet();
        this.segmentF.rozsviet();
        this.segmentG.rozsviet();
    }

    private void zobraz7() {
        this.segmentA.rozsviet();
        this.segmentB.rozsviet();
        this.segmentC.rozsviet();
        this.segmentD.zhasni();
        this.segmentE.zhasni();
        this.segmentF.zhasni();
        this.segmentG.zhasni();
    }

    private void zobraz8() {
        this.segmentA.rozsviet();
        this.segmentB.rozsviet();
        this.segmentC.rozsviet();
        this.segmentD.rozsviet();
        this.segmentE.rozsviet();
        this.segmentF.rozsviet();
        this.segmentG.rozsviet();
    }

    private void zobraz9() {
        this.segmentA.rozsviet();
        this.segmentB.rozsviet();
        this.segmentC.rozsviet();
        this.segmentD.rozsviet();
        this.segmentE.zhasni();
        this.segmentF.rozsviet();
        this.segmentG.rozsviet();
    }
    
    public void zobrazCifra(int cifra) {
        
        switch (cifra) {
            case 0:
                this.zobraz0();
                break;
            case 1:
                this.zobraz1();
                break;
            case 2:
                this.zobraz2();
                break;
            case 3:
                this.zobraz3();
                break;
            case 4:
                this.zobraz4();
                break;
            case 5:
                this.zobraz5();
                break;
            case 6:
                this.zobraz6();
                break;
            case 7:
                this.zobraz7();
                break;
            case 8:
                this.zobraz8();
                break;
            case 9:
                this.zobraz9();
                break;
            default:
                System.out.println("Zle zadane cislo");
                return;
        }
    }

    public void rozsvietVsetko() {
        this.segmentA.rozsviet();
        this.segmentB.rozsviet();
        this.segmentC.rozsviet();
        this.segmentD.rozsviet();
        this.segmentE.rozsviet();
        this.segmentF.rozsviet();
        this.segmentG.rozsviet();
    }

    public void zhasniVsetko() {
        this.segmentA.zhasni();
        this.segmentB.zhasni();
        this.segmentC.zhasni();
        this.segmentD.zhasni();
        this.segmentE.zhasni();
        this.segmentF.zhasni();
        this.segmentG.zhasni();
    }
}
