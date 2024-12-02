package edu.tartelette.hangman;

import static java.lang.Character.toUpperCase;

public final class Validator {
  private static final String NOT_SINGLE_LETTER = "Вы ввели не одну букву";
  private static final String NOT_RANGE = "Введенная буква в некорректном диапазоне "
                                          + RussianLanguage.RANGE_TEXT;

  private Validator() {}

  public static void validate(String inputString) {
      if (inputString.length() != 1) {
        throw new InputException(NOT_SINGLE_LETTER);
      }
      char letter = toUpperCase(inputString.charAt(0));
      if (!((letter >= RussianLanguage.FIRST_LETTER)
          && (letter <= RussianLanguage.LAST_LETTER))) {
        throw new InputException(NOT_RANGE);
      }

  }
}
