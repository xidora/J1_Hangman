package edu.tartelette.hangman;

public class NotInRangeException extends IllegalArgumentException {
  public NotInRangeException(String message) {
    super(message);
  }
}
