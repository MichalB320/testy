package sk.uniza.fri;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 18. 5. 2021 - 8:52
 *
 * @author micha
 */
class ScoreTest {

    @Test
    void pridajScore() {
        Score score = new Score();
        score.pridajScore(50);
        score.pridajScore(30);

        assertEquals(80, score.getScore());
    }

    @Test
    void vyresetuj() {
        Score score = new Score();
        score.pridajScore(50);
        score.pridajScore(30);
        score.vyresetuj();

        assertEquals(0, score.getScore());
    }
}