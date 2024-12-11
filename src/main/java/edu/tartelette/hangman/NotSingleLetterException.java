package edu.tartelette.hangman;

public class NotSingleLetterException extends IllegalArgumentException {
  public NotSingleLetterException(String message) {
    super(message);
  }
}
