package edu.tartelette.hangman.input;

import java.util.Scanner;

public abstract class LetterInput {
    private final String title;
    private final Validator validator;

    private final Scanner scanner = new Scanner(System.in);

    protected LetterInput(String title, Validator validator) {
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
            } catch (NotSingleLetterException e) {
                System.out.println(notSingleLetterMessage());
            } catch (NotInRangeException e) {
                System.out.println(notInRangeMessage());
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    protected abstract String notSingleLetterMessage();

    protected abstract String notInRangeMessage();
}
