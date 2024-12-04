package edu.tartelette.hangman;

import static edu.tartelette.hangman.HangmanArt.printHangmanArt;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Game {
  private static final String WIN = "Вы выиграли";
  private static final String LOSE = "Вы проиграли";
  private static final String GUESS_RIGHT = "Ваша догадка верна";
  private static final String GUESS_WRONG = "Ваша догадка ошибочна";
  private static final String ATTEMPT_LEFT = "Оставшихся попыток: ";
  private static final String INPUTTED_LETTER = "Введенные буквы: ";
  private static final String VISIBLE_LETTER = "Отгаданная часть слова: ";
  private static final String LINE_DELIMETER = "====================";
  private static final String SECRET_WORD = "Загаданное слово: ";
  private static final String DELIMETER = " | ";
  private static final String USED_LETTER = "Эта буква уже вводилась ранее";

  private static final String FILE_NAME = "dictionary.txt";

  private int attemptsLeft = 6;
  private static Set<Character> inputtedLetters = new HashSet<>();
  private SecretWord secretWord;
  private final Set<Character> secretLetters;

  {
    try {
      String newWord = Dictionary.getRandomWord(FILE_NAME).toUpperCase();
      secretWord = new SecretWord(newWord);
      System.out.println(newWord);
    } catch (EmptyDictionaryException emptyDictionaryException) {
      emptyDictionaryException.printStackTrace();
      System.exit(0);
    }
    secretLetters = secretWord.getStartLetters();
  }

  public Game() {
    inputtedLetters = new HashSet<>();
  }

  public void start() {
    while ((attemptsLeft > 0) || (secretWord.isMaskOpened())) {
      System.out.println(LINE_DELIMETER);
      printHangmanArt(attemptsLeft);
      System.out.print(ATTEMPT_LEFT + attemptsLeft + DELIMETER);
      System.out.println(INPUTTED_LETTER + inputtedLetters);
      List<Character> mask = secretWord.getMask();

      String maskString = mask.stream()
          .map(String::valueOf)
          .collect(Collectors.joining());

      System.out.println(VISIBLE_LETTER + maskString);
      char letter;
      while (true) {
        letter = Inputter.get();
        if (!inputtedLetters.contains(letter)) {
          break;
        }
        System.out.println(USED_LETTER);
      }
      inputtedLetters.add(letter);
      try {
        if (secretWord.isContainLetter(letter)) {
          secretWord.revealLetter(letter);
          System.out.println(GUESS_RIGHT);
        } else {
          System.out.println(GUESS_WRONG);
          attemptsLeft--;
        }
      } catch (LetterNotInWordException error) {
        error.printStackTrace();
      }
      //System.out.println(LINE_DELIMETER);
    }
    if (attemptsLeft > 0) {
      System.out.println(WIN);
    } else {
      System.out.println(LOSE);
      printHangmanArt(attemptsLeft);
    }
    System.out.println(SECRET_WORD + secretWord.getSecretWord());
    Menu.start();
  }

  private boolean checkLetter(char letter) {
    if (secretLetters.contains(letter)) {
      secretLetters.remove(letter);
      return true;
    }
    return false;
  }
}
