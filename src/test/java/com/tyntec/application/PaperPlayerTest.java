package com.tyntec.application;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import com.tyntec.application.Game.Turn;

/**
 * Test the PaperPlayer class.
 * Created by rich on 09/03/15.
 */
public class PaperPlayerTest {
    @Test
    public void test20Moves() {
        PaperPlayer player = new PaperPlayer();
        for (int i = 0; i < 20; i++) {
            Game.Turn turn = player.makeOneMove();
            assertTrue(Game.Turn.Paper == turn);
        }
    }
}
