package edu.tartelette.hangman;

import java.util.HashSet;

import static edu.tartelette.hangman.HangmanArt.printHangmanArt;

public class Game {
    private int attemptsLeft = 6;
    private static HashSet<Character> inputtedLetters = new HashSet<>();
    private SecretWord aSecretWord = new SecretWord();
    private HashSet<Character> secretLetters = aSecretWord.getStartLetters();

    private static final String WIN_TEXT = "You won";
    private static final String LOSE_TEXT = "You lose";
    private static final String GUESS_IS_RIGHT_TEXT = "Your guess is right";
    private static final String GUESS_IS_WRONG_TEXT = "Your guess is wrong";
    private static final String ATTEMPT_LEFT_TEXT = "Attempts Left: ";
    private static final String INPUTTED_LETTER_TEXT = "Inputted Letters: ";
    private static final String VISIBLE_LETTER_TEXT = "Visible word: ";
    private static final String LINE_DELIMETER = "====================";
    private static final String SECRET_WORD_IS_TEXT = "Secret Word is: ";
    private static final String DELIMETER = " | ";

    public Game() {
        inputtedLetters = new HashSet<>();
    }

    public void start() {
        while ((attemptsLeft > 0) && (!secretLetters.isEmpty())) {
            System.out.println(LINE_DELIMETER);
            printHangmanArt(attemptsLeft);
            System.out.print(ATTEMPT_LEFT_TEXT + attemptsLeft + DELIMETER);
            System.out.println(INPUTTED_LETTER_TEXT + inputtedLetters);
            System.out.println(VISIBLE_LETTER_TEXT + aSecretWord.getVisibleWord());
            char letter = LetterInput.get();
            inputtedLetters.add(letter);
            if(checkLetter(letter)) {
                aSecretWord.revealLetter(letter);
                System.out.println(GUESS_IS_RIGHT_TEXT);
            } else {
                System.out.println(GUESS_IS_WRONG_TEXT);
                attemptsLeft--;
            }
        }
        System.out.println(LINE_DELIMETER);
        if (attemptsLeft > 0) {
            System.out.println(WIN_TEXT);
        } else {
            System.out.println(LOSE_TEXT);
            printHangmanArt(attemptsLeft);
        }
        System.out.println(SECRET_WORD_IS_TEXT + aSecretWord.getSecretWord());
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
