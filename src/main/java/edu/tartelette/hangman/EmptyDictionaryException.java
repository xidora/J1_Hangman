package edu.tartelette.hangman;

public class EmptyDictionaryException extends Exception {
    public EmptyDictionaryException(String errorMessage) {
        super(errorMessage);
    }
}
