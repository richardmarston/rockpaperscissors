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

    /*
       See also the list of Turns in Game.java
     */
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

        /*
           To generate a unique key, each move is assigned a power
           of 2, which means that they take a place in a bit-field:

           0 0 0 0 1 - player 1 chooses rock
           0 0 0 1 0 - player 1 chooses paper
           0 0 1 0 0 - player 1 chooses scissors
           0 1 0 0 0 - player 2 chooses rock

           etc. To make an entry in the methodMap, the two turn values which
           together make a move are added together. For example:

           0 1 0 1 0 - player 1 chooses paper, player 2 chooses rock.

           The key for the methodMap is therefore 2^1 + 2^3 which is 2+8 or 10.
           There is no other way to make 10 so the key is unique.

           */

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
        /*
           This line of code combines the two Turn variables into a lookup key in
           the methodMap. Each Turn has an ordinal value (1,2,3 etc) which we turn
           into the bit-field key described above by shifting 1 the required number
           of spaces to the left. For the second player, we must also shift by the
           total number of spaces that represent the player 1 moves.
         */
        int theTurn = (1 << player1Turn.ordinal()) + (1 << (player2Turn.ordinal() + Game.Turn.values().length));
        methodMap.get(theTurn).runCommand();
    }
}
