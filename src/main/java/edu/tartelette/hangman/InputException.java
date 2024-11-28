package edu.tartelette.hangman;

public class InputException extends IllegalArgumentException {
  public InputException(String errorMessage) {
    super(errorMessage);
  }
}
