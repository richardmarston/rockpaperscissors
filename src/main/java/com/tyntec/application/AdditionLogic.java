package com.tyntec.application;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rich on 10/03/15.
 */
public class AdditionLogic implements TurnLogic {

    private interface Command {
        void runCommand();
    }

    private final int Player1Rock = 1;
    private final int Player1Paper = 2;
    private final int Player1Scissors = 4;
    private final int Player2Rock = 8;
    private final int Player2Paper = 16;
    private final int Player2Scissors = 32;
    Game theGame;

    Map<Integer, Command> methodMap;

    public AdditionLogic(Game game) {
        theGame = game;
        methodMap = new HashMap<Integer, Command>();

        methodMap.put(Player1Rock+Player2Rock, ()-> { theGame.incNumberOfDraws(); });
        methodMap.put(Player1Paper+Player2Paper, ()-> { theGame.incNumberOfDraws(); });
        methodMap.put(Player1Scissors+Player2Scissors, ()-> { theGame.incNumberOfDraws(); });

        methodMap.put(Player1Paper+Player2Rock, ()-> { theGame.incPlayer1Score(); });
        methodMap.put(Player1Rock+Player2Scissors, ()-> { theGame.incPlayer1Score(); });
        methodMap.put(Player1Scissors+Player2Paper, ()-> { theGame.incPlayer1Score(); });

        methodMap.put(Player1Rock+Player2Paper, ()-> { theGame.incPlayer2Score(); });
        methodMap.put(Player1Scissors+Player2Rock, ()->{ theGame.incPlayer2Score(); });
        methodMap.put(Player1Paper+Player2Scissors, ()->{ theGame.incPlayer2Score(); });
    }

    @Override
    public void evaluateOneTurn(Game.Turn player1Turn, Game.Turn player2Turn) {
        int theTurn = (1 << player1Turn.ordinal()) + (1 << (player2Turn.ordinal() + 3));
        methodMap.get(theTurn).runCommand();
    }
}
