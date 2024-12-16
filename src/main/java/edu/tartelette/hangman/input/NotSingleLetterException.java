package edu.tartelette.hangman.input;

public class NotSingleLetterException extends IllegalArgumentException {
  public NotSingleLetterException(String message) {
    super(message);
  }
}
