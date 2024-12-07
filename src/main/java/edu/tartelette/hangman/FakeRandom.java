package edu.tartelette.hangman;

import java.util.Random;

public class FakeRandom extends Random {
    int fakeRandom = 0;

    public FakeRandom() {
        super();
    }

    @Override
    public int nextInt() {
        return fakeRandom++;
    }
}
