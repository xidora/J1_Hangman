package edu.tartelette.hangman;

public class InputExeption extends IllegalArgumentException {

  public InputExeption(String errorMessage) {
    super(errorMessage);
  }
}