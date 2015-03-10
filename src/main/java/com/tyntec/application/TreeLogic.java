package com.tyntec.application;

import com.tyntec.application.Game.*;

/**
 * This class encapsulates the game logic for Rock, Paper, Scissors.
 * Created by rich on 10/03/15.
 */
public class TreeLogic implements TurnLogic{

    private Game theGame;

    public TreeLogic(Game game) {
        theGame = game;
    }

    /**
     * Here is where the turns are evaluated. Player 1's turn determines which
     * of the 3 functions with the Player 2 logic in is called.
     * @param player1Turn
     * @param player2Turn
     */
    @Override
    public void evaluateOneTurn(Turn player1Turn, Turn player2Turn) {
        switch (player1Turn){
            case Rock:
                evaluatePlayer1RockTurn(player2Turn);
                break;
            case Paper:
                evaluatePlayer1PaperTurn(player2Turn);
                break;
            case Scissors:
                evaluatePlayer1ScissorsTurn(player2Turn);
                break;
        }
    }

    /**
     * Given that Player 1 chose Scissors, what is the result?
     * @param player2Turn
     */
    private void evaluatePlayer1ScissorsTurn(Turn player2Turn) {
        switch(player2Turn){
            case Rock:
                theGame.incPlayer2Score();
                break;
            case Paper:
                theGame.incPlayer1Score();
                break;
            case Scissors:
                theGame.incNumberOfDraws();
                break;
        }
    }

    /**
     * Assuming that Player 1 chose Paper, what is the result?
     * @param player2Turn
     */
    private void evaluatePlayer1PaperTurn(Turn player2Turn) {
        switch(player2Turn){
            case Rock:
                theGame.incPlayer1Score();
                break;
            case Paper:
                theGame.incNumberOfDraws();
                break;
            case Scissors:
                theGame.incPlayer2Score();
                break;
        }

    }

    /**
     * If Player 1 chooses Rock, what is the result?
     * @param player2Turn
     */
    private void evaluatePlayer1RockTurn(Turn player2Turn) {
        switch (player2Turn) {
            case Rock:
                theGame.incNumberOfDraws();
                break;
            case Paper:
                theGame.incPlayer2Score();
                break;
            case Scissors:
                theGame.incPlayer1Score();
                break;
        }

    }
}
