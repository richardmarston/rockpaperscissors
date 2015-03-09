package com.tyntec.application;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import com.tyntec.application.Game.Turn;

/**
 * Test the Random Player.
 * Created by rich on 09/03/15.
 */
public class RandomPlayerTest {

    /**
     *  This test just makes sure that the distribution of hits is reasonably appropriate.
     *  The expectedMinimumHits variable is only an observed minimum, and minor variation
     *  below this result does not necessarily suggest a problem.
     */
    private final int numberOfIterations = 1000;
    private final int expectedMinimumHits = 300;
    @Test
    public void test1000Moves() {
        RandomPlayer player = new RandomPlayer();
        int Totals[] = new int[3];

        for (int i = 0; i < numberOfIterations; i++) {
            Game.Turn turn = player.makeOneMove();
            Totals[turn.ordinal()]++;
        }

        for (int total : Totals) {
            assertTrue(total > expectedMinimumHits);
        }
    }
}
