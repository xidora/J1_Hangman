package edu.tartelette.hangman.input;

public class NotInRangeException extends IllegalArgumentException {
  public NotInRangeException(String message) {
    super(message);
  }
}
