package edu.tartelette.hangman;

import java.util.HashSet;

import static java.lang.Character.toUpperCase;

public class Validator {

    private static final String NOT_SINGLE_LETTER = "Вы ввели не одину букву";
    private static final String NOT_RANGE = "Введенная буква в некорректном диапазоне [а-яА-Я]";
    private static final String USED_LETTER = "Эта буква уже вводилась ранее";

    public static boolean isValid(String inputString) {
        HashSet<Character> inputtedLetters = Game.getInputtedLetters();
        try {
            if (inputString.length() != 1) {
                throw new InputException(NOT_SINGLE_LETTER);
            }

            char letter = toUpperCase(inputString.charAt(0));
            if (!((letter >= 'А') && (letter <= 'Я'))) {
                throw new InputException(NOT_RANGE);
            }

            if (inputtedLetters.contains(letter)) {
                throw new InputException(USED_LETTER);
            }
            return true;
        } catch (InputException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
