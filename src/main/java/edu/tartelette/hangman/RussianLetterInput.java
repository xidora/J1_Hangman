package edu.tartelette.hangman;

public class RussianLetterInput extends LetterInput {
  private final static char FIRST_LETTER = 'А';
  private final static char LAST_LETTER = 'Я';
  private final static String TITLE_TEMPLATE = "Введите букву [%c-%c%c-%c]";

  private static final String NOT_A_SINGLE_LETTER = "Введите одну букву";
  private static final String NOT_IN_THE_RANGE_TEMPLATE = "Введите русскую букву";

  public RussianLetterInput() {
    super(getTitle(), new Validator(FIRST_LETTER, LAST_LETTER));
  }

  private static String getTitle() {
    return TITLE_TEMPLATE.formatted(
        Character.toLowerCase(FIRST_LETTER),
        Character.toLowerCase(LAST_LETTER),
        FIRST_LETTER,
        LAST_LETTER
    );
  }

  @Override
  protected String notSingleLetterMessage() {
    return NOT_A_SINGLE_LETTER;
  }

  @Override
  protected String notInRangeMessage() {
    return NOT_IN_THE_RANGE_TEMPLATE;
  }
}
