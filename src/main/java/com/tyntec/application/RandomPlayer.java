package com.tyntec.application;

import java.util.Random;
import com.tyntec.application.Game.*;

/**
 * Class to represent a player who makes random moves.
 * Created by rich on 09/03/15.
 */
public class RandomPlayer implements Player {

    private Random randomIntGenerator;
    private final Turn[] turnValues = Turn.values();

    /**
     * Seeding with current time, so that we don't get the same numbers each time.
     */
    public RandomPlayer() {
        randomIntGenerator = new Random(System.currentTimeMillis());
    }

    @Override
    public Game.Turn makeOneMove() {
        return turnValues[randomIntGenerator.nextInt(3)];
    }
}
