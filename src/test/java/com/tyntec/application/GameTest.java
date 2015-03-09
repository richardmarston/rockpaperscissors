
package com.tyntec.application;

import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;
import com.tyntec.application.Game.Turn;

/* This class tests the game logic for Rock, Paper, Scissors */
public class GameTest {

    /**
     * Test that the game begins with all players on zero points.
     */
    @Test
    public void newGameHasZeroScores() {
        Game testGame = new Game();
        assertTrue(testGame.getPlayer1Score() == 0);
        assertTrue(testGame.getPlayer2Score() == 0);
        assertTrue(testGame.getNumberOfDraws() == 0);
    }

    /**
     * Utility class for checking that both players will
     * succeed if the combination is correct for them.
     * This test should not be called with losing combinations.
     * @param Winner - the chosen winning turn.
     * @param Loser - the chosen losing turn.
     */
    public void winningCombinationWins(Turn Winner, Turn Loser) {
        Game testGame = new Game();
        testGame.playOneTurn(Winner, Loser);
        assertTrue(testGame.getPlayer1Score() == 1);
        assertTrue(testGame.getPlayer2Score() == 0);
        assertTrue(testGame.getNumberOfDraws() == 0);
        testGame.playOneTurn(Loser, Winner);
        assertTrue(testGame.getPlayer1Score() == 1);
        assertTrue(testGame.getPlayer2Score() == 1);
        assertTrue(testGame.getNumberOfDraws() == 0);
    }

    /**
     * Utility class that checks a draw is the result
     * if both players play the same turn.
     * @param Drawer - the turn that is played.
     */
    public void drawingCombinationDraws(Turn Drawer) {
        Game testGame = new Game();
        assertTrue(testGame.getNumberOfDraws() == 0);
        testGame.playOneTurn(Drawer, Drawer);
        assertTrue(testGame.getNumberOfDraws() == 1);
    }

    @Test
    public void rockBeatsScissors() {
        winningCombinationWins(Turn.Rock, Turn.Scissors);
    }

    @Test
    public void scissorsBeatPaper() {
        winningCombinationWins(Turn.Scissors, Turn.Paper);
    }

    @Test
    public void paperBeatsRock() {
        winningCombinationWins(Turn.Paper, Turn.Rock);
    }

    @Test
    public void sameTurnDraws() {
        drawingCombinationDraws(Turn.Rock);
        drawingCombinationDraws(Turn.Paper);
        drawingCombinationDraws(Turn.Scissors);
    }

}