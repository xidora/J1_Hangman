package edu.tartelette.hangman;

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

    private final HangMan hangman = new HangMan();
    private final AlphabetRepository alphabetRepository = new AlphabetRepository();
    private SecretWord secretWord;

    {
        try {
            String newWord = Dictionary.getRandomWord(FILE_NAME).toUpperCase();
            secretWord = new SecretWord(newWord);
        } catch (EmptyDictionaryException exception) {
            exception.printStackTrace();
            System.exit(0);
        }
    }

    public Game() {}

    public void start() {
        while (hangman.isAlive() && (secretWord.isMaskCovered())) {
            System.out.println(LINE_DELIMITER);
            printHangmanArt(hangman.getHangStage());
            int attemptsLeft = hangman.getMaxHangStage() - hangman.getHangStage();
            System.out.print(ATTEMPT_LEFT + attemptsLeft + DELIMITER);
            System.out.println(INPUTTED_LETTER + alphabetRepository.getLetters());

            List<Character> mask = secretWord.getMask();
            String maskString = mask.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
            System.out.println(VISIBLE_LETTER + maskString);

            char letter;
            while (true) {
                letter = LetterInput.get();
                if (!alphabetRepository.containsLetter(letter)) {
                    break;
                }
                System.out.println(USED_LETTER);
            }

            try {
                alphabetRepository.addLetter(letter);
            } catch (AlphabetRepositoryException exception) {
                throw new RuntimeException(exception);
            }

            try {
                if (secretWord.isContainLetter(letter)) {
                    secretWord.revealLetter(letter);
                    System.out.println(GUESS_RIGHT);
                } else {
                    System.out.println(GUESS_WRONG);
                    hangman.increaseHangStage();
                }
            } catch (LetterNotInWordException | IllegalHangManStagaException exception) {
                exception.printStackTrace();
            }
        }

        if (hangman.isAlive()) {
            System.out.println(WIN);
        } else {
            System.out.println(LOSE);
            printHangmanArt(hangman.getHangStage());
        }
        System.out.println(SECRET_WORD + secretWord.getSecretWord());
        Menu.start();
    }
}
