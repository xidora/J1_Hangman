package edu.tartelette.hangman.input;

public class InputException extends IllegalArgumentException {
    public InputException(String errorMessage) {
        super(errorMessage);
    }
}
