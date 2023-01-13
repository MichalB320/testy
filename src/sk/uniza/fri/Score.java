package sk.uniza.fri;

/**
 * Score - pocíta aké vysoké skóre si nahral.
 * Túto triedu som prevzal z minulej semestrálky
 * 
 * @author  Michal Bežo
 * @version 23.5.2021
 */
public class Score {
    private int score;
    
    /**
     * Konštruktor bez prametrov nám nastaví skóre na nulu.
     */
    public Score() {
        this.score = 0;
    }
    
    /**
     * Score - pridá skóre o jedno.
     */
    public void pridajScore(int oKolko) {
        //this.score++;
        this.score = this.score + oKolko;
    }
    
    /**
     * Score - vráti nám dosiahnuté skóre.
     * 
     * @return  score
     */
    public int getScore() {
        return this.score;
    }
    
    /**
     * Score - vymaže dosiahnuté skóre.
     */
    public void vyresetuj() {
        this.score = 0;
    }
}