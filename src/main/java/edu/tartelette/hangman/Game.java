package edu.tartelette.hangman;

import java.util.HashSet;
import java.util.Set;

import static edu.tartelette.hangman.HangmanArt.printHangmanArt;

public class Game {
    private int attemptsLeft = 6;
    private static HashSet<Character> inputtedLetters = new HashSet<>();
    private SecretWord secretWord = new SecretWord();
    private Set<Character> secretLetters = secretWord.getStartLetters();

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

    public Game() {
        inputtedLetters = new HashSet<>();
    }

    public void start() {
        while ((attemptsLeft > 0) && (!secretLetters.isEmpty())) {
            System.out.println(LINE_DELIMETER);
            printHangmanArt(attemptsLeft);
            System.out.print(ATTEMPT_LEFT + attemptsLeft + DELIMETER);
            System.out.println(INPUTTED_LETTER + inputtedLetters);
            System.out.println(VISIBLE_LETTER + secretWord.getVisibleWord());
            char letter = RussianLetterInput.get();
            inputtedLetters.add(letter);
            if(checkLetter(letter)) {
                secretWord.revealLetter(letter);
                System.out.println(GUESS_RIGHT);
            } else {
                System.out.println(GUESS_WRONG);
                attemptsLeft--;
            }
        }
        System.out.println(LINE_DELIMETER);
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
        } else {
            return false;
        }
    }

    public static HashSet<Character> getInputtedLetters() {
        return inputtedLetters;
    }
}
