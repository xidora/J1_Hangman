package edu.tartelette.hangman;

  public class LetterNotInWordException extends Exception {
    public LetterNotInWordException(String errorMessage) {
      super(errorMessage);
    }
  }
