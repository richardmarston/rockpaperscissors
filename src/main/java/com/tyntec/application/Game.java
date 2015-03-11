package com.tyntec.application;

class Game {

    // See also the list of player moves in AdditionLogic.java
    public enum Turn { Rock, Paper, Scissors };

    private int Player1Score;
    private int Player2Score;
    private int NumberOfDraws;
    private TurnLogic turnLogic;

    public Game() {
        Player1Score = 0;
        Player2Score = 0;
        NumberOfDraws = 0;
        turnLogic = new AdditionLogic(this);
    }

    public void playOneTurn(Turn player1Turn, Turn player2Turn) {
        turnLogic.evaluateOneTurn(player1Turn, player2Turn);
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

    public void incPlayer1Score() {
        Player1Score++;
    }

    public void incPlayer2Score() {
        Player2Score++;
    }

    public void incNumberOfDraws() {
        NumberOfDraws++;
    }
}
