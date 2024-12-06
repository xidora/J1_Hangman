package edu.tartelette.hangman;

public class IllegalHangManStagaException extends Exception {
    public IllegalHangManStagaException(String errorMessage) {
        super(errorMessage);
    }
}
