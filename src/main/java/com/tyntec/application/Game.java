package com.tyntec.application;

import static com.tyntec.application.Game.Turn;

/* This class encapsulates the game logic for Rock, Paper, Scissors */
class Game {

    public enum Turn { Rock, Paper, Scissors };

    private int Player1Score;
    private int Player2Score;
    private int NumberOfDraws;

    public Game() {
        Player1Score = 0;
        Player2Score = 0;
        NumberOfDraws = 0;
    }

    public int getPlayer1Score() {
        return Player1Score;
    }

    public int getPlayer2Score() {
        return Player2Score;
    }

    public int getNumberOfDraws() {
        return NumberOfDraws;
    }

    /**
     * Here is where the turns are evaluated. Player 1's turn determines which
     * of the 3 functions with the Player 2 logic in is called.
     * @param Player1Turn
     * @param Player2Turn
     */
    public void playOneTurn(Turn Player1Turn, Turn Player2Turn) {
        switch (Player1Turn){
            case Rock:
                evaluatePlayer1RockTurn(Player2Turn);
                break;
            case Paper:
                evaluatePlayer1PaperTurn(Player2Turn);
                break;
            case Scissors:
                evaluatePlayer1ScissorsTurn(Player2Turn);
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
                Player2Score++;
                break;
            case Paper:
                Player1Score++;
                break;
            case Scissors:
                NumberOfDraws++;
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
                Player1Score++;
                break;
            case Paper:
                NumberOfDraws++;
                break;
            case Scissors:
                Player2Score++;
                break;
        }

    }

    /**
     * If Player 1 chooses Rock, what is the result?
     * @param player2Turn
     */
    private void evaluatePlayer1RockTurn(Turn player2Turn) {
        switch(player2Turn){
            case Rock:
                NumberOfDraws++;
                break;
            case Paper:
                Player2Score++;
                break;
            case Scissors:
                Player1Score++;
                break;
        }

    }
}
