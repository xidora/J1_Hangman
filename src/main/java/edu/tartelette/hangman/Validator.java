package edu.tartelette.hangman;

import java.util.HashSet;

import static java.lang.Character.toUpperCase;

public class Validator {

    private static final String NOT_A_SINGLE_LETTER = "Not a single letter";
    private static final String NOT_IN_THE_RANGE = "Isn't in the range [а-яА-Я]";
    private static final String USED_LETTER = "This is used letter";

    public static boolean isValid(String inputString) {
        HashSet<Character> inputtedLetters = Game.getInputtedLetters();

        if (inputString.length() != 1) {
            throw new InputExeption(NOT_A_SINGLE_LETTER);
        }

        char letter = toUpperCase(inputString.charAt(0));
        if (!((letter >= 'А') && (letter <= 'Я'))) {
            throw new InputExeption(NOT_IN_THE_RANGE);
        }

        if (inputtedLetters.contains(letter)) {
            throw new InputExeption(USED_LETTER);
        }

        return true;
    }
}
