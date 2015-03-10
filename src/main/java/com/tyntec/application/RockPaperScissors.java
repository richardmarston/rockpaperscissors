package com.tyntec.application;

/**
 * Created by rich on 09/03/15.
 */
public class RockPaperScissors {
    public static void main(String[] args) {

        Game theGame = new Game();
        Player PlayerA = new PaperPlayer();
        Player PlayerB = new RandomPlayer();

        for (int i = 0; i < 100; i++) {
            theGame.playOneTurn(PlayerA.makeOneMove(), PlayerB.makeOneMove());
        }

        System.out.println("Player A wins " + theGame.getPlayer1Score() + " of 100 games");
        System.out.println("Player B wins " + theGame.getPlayer2Score() + " of 100 games");
        System.out.println("Tie " + theGame.getNumberOfDraws() + " of 100 games");
    }
}
