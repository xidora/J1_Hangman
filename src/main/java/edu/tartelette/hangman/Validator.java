package edu.tartelette.hangman;

import static java.lang.Character.toUpperCase;

import java.util.Set;

public final class Validator {
  private static final String NOT_SINGLE_LETTER = "Вы ввели не одину букву";
  private static final String NOT_RANGE = "Введенная буква в некорректном диапазоне "
                                          + RussianLanguage.RANGE_TEXT;
  private static final String USED_LETTER = "Эта буква уже вводилась ранее";

  private Validator() {}

  public static boolean isValid(String inputString) {
    Set<Character> inputtedLetters = Game.getInputtedLetters();
    try {
      if (inputString.length() != 1) {
        throw new InputException(NOT_SINGLE_LETTER);
      }

      char letter = toUpperCase(inputString.charAt(0));
      if (!((letter >= RussianLanguage.FIRST_LETTER)
          && (letter <= RussianLanguage.LAST_LETTER))) {
        throw new InputException(NOT_RANGE);
      }

      if (inputtedLetters.contains(letter)) {
        throw new InputException(USED_LETTER);
      }
      return true;
    } catch (InputException e) {
      System.out.println(e.getMessage());
      return false;
    }
  }
}
