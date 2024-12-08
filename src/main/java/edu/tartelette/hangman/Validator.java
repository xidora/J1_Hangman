package edu.tartelette.hangman;

import static java.lang.Character.toUpperCase;

public final class Validator {
    private static final String NOT_SINGLE_LETTER = "Вы ввели не одну букву";
    private static final String NOT_RANGE = "Введенная буква в некорректном диапазоне [%c-%c%c-%c]";

    private final char firstLetter;
    private final char lastLetter;

    public Validator(char firstLetter, char lastLetter) {
        this.firstLetter = firstLetter;
        this.lastLetter = lastLetter;
    }

    public void validate(String inputString) {
        if (inputString.length() != 1) {
            throw new InputException(NOT_SINGLE_LETTER);
        }
        char letter = toUpperCase(inputString.charAt(0));
        if ((letter < firstLetter) || (letter > lastLetter)) {
            String message = NOT_RANGE.formatted(
                    firstLetter,
                    lastLetter,
                    toUpperCase(firstLetter),
                    toUpperCase(lastLetter));
            throw new InputException(message);
        }
    }

    public static class NotSingleLetterException extends IllegalArgumentException {
        public NotSingleLetterException(String message) {
            super(message);
        }
    }

    public static class NotInRangeException extends IllegalArgumentException {
        public NotInRangeException(String message) {
            super(message);
        }
    }

}
