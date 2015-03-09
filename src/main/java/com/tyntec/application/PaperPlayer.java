package com.tyntec.application;

/**
 * This player is obsessed with playing Paper.
 * Created by rich on 09/03/15.
 */
public class PaperPlayer implements Player {
    @Override
    public Game.Turn makeOneMove() {
        return Game.Turn.Paper;
    }
}
