package com.tyntec.application;

import com.tyntec.application.Game.Turn;

/**
 * Created by rich on 10/03/15.
 */
public interface TurnLogic {
    public void evaluateOneTurn(Turn player1Turn, Turn player2Turn);
}
