package edu.tartelette.hangman;

import edu.tartelette.hangman.input.LetterInput;
import edu.tartelette.hangman.input.RussianLetterInput;

import static edu.tartelette.hangman.HangmanArt.printHangmanArt;

import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private static final String WIN = "Вы выиграли";
    private static final String LOSE = "Вы проиграли";
    private static final String GUESS_RIGHT = "Ваша догадка верна";
    private static final String GUESS_WRONG = "Ваша догадка ошибочна";
    private static final String ATTEMPT_LEFT = "Оставшихся попыток: ";
    private static final String INPUTTED_LETTER = "Введенные буквы: ";
    private static final String VISIBLE_LETTER = "Отгаданная часть слова: ";
    private static final String LINE_DELIMITER = "====================";
    private static final String SECRET_WORD = "Загаданное слово: ";
    private static final String DELIMITER = " | ";
    private static final String USED_LETTER = "Эта буква уже вводилась ранее";

    private static final String FILE_NAME = "dictionary.txt";

    private static final LetterInput letterInput = new RussianLetterInput();

    private final HangMan hangman = new HangMan();
    private final LettersRepository lettersRepository = new LettersRepository();
    private SecretWord secretWord;

    {
        try {
            String newWord = Dictionary.getRandomWord(FILE_NAME).toUpperCase();
            secretWord = new SecretWord(newWord);
        } catch (EmptyDictionaryException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public Game() { }

    public void start() {
        while (hangman.isAlive() && (secretWord.isMaskCovered())) {
            printGameStatus();
            printMask();

            char letter = getNewLetter();
            addToRepository(letter);

            try {
                if (secretWord.isContainLetter(letter)) {
                    secretWord.revealLetter(letter);
                    System.out.println(GUESS_RIGHT);
                } else {
                    System.out.println(GUESS_WRONG);
                    hangman.increaseHangStage();
                }
            } catch (LetterNotInWordException | IllegalHangManStageException e) {
                e.printStackTrace();
            }
        }

        printResult();
        Menu.start();
    }

    private void printGameStatus() {
        System.out.println(LINE_DELIMITER);
        printHangmanArt(hangman.getHangStage());
        int attemptsLeft = hangman.getMaxHangStage() - hangman.getHangStage();
        System.out.print(ATTEMPT_LEFT + attemptsLeft + DELIMITER);
        System.out.println(INPUTTED_LETTER + lettersRepository.getLetters());
    }

    private void printMask() {
        List<Character> mask = secretWord.getMask();
        String maskString = mask.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(VISIBLE_LETTER + maskString);
    }

    private void printResult() {
        if (hangman.isAlive()) {
            System.out.println(WIN);
        } else {
            System.out.println(LOSE);
            printHangmanArt(hangman.getHangStage());
        }
        System.out.println(SECRET_WORD + secretWord.getSecretWord());
    }

    private char getNewLetter() {
        char letter;
        while (true) {
            letter = Character.toUpperCase(letterInput.get());
            if (!lettersRepository.containsLetter(letter)) {
                break;
            }
            System.out.println(USED_LETTER);
        }
        return letter;
    }

    private void addToRepository(final char letter) {
        try {
            lettersRepository.addLetter(letter);
        } catch (LettersRepositoryException e) {
            throw new RuntimeException(e);
        }
    }
}
