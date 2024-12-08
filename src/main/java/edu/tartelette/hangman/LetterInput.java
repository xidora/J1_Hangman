package edu.tartelette.hangman;

import java.util.Scanner;

public abstract class LetterInput {
    private static final String INPUT_LETTER = "Введите новую невведенную буквы "
            + RussianLanguage.RANGE_TEXT + " :";

    private final String title;
    private final Validator validator;

    private final Scanner scanner = new Scanner(System.in);

    private LetterInput(String title, Validator validator) {
        this.title = title;
        this.validator = validator;
    }

    public char get() {
        while (true) {
            System.out.println(title);
            String text = scanner.nextLine();
            try {
                validator.validate(text);
                return text.charAt(0);
            } catch (Validator.NotSingleLetterException e) {
                System.out.println(notSingleLetterMessage());
            } catch (Validator.NotInRangeException e) {
                System.out.println(notInRangeMessage());
            }
        }
    }
}
