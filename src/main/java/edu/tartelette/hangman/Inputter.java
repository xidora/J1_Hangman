package edu.tartelette.hangman;

import static java.lang.Character.toUpperCase;

import java.util.Scanner;

public final class Inputter {
  private static final String INPUT_LETTER = "Введите новую невведенную буквы "
                                              + RussianLanguage.RANGE_TEXT + " :";
  private Inputter() {}

  public static char get() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println(INPUT_LETTER);
      String input = scanner.nextLine();
      try {
        Validator.validate(input);
        return toUpperCase(input.charAt(0));
      } catch (InputException inputException) {
        inputException.printStackTrace();
      }
    }
  }
}
