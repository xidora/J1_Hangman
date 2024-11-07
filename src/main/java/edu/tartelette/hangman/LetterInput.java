package edu.tartelette.hangman;

import java.util.Scanner;

import static java.lang.Character.toUpperCase;

public class LetterInput {

    private static final String INPUT_LETTER_TEXT = "Type single new russian letter [а-яА-Я] :";

    public static char get() {
        Scanner aScanner = new Scanner(System.in);
        while (true) {
            System.out.println(INPUT_LETTER_TEXT);
            String input = aScanner.nextLine();
            if (Validator.isValid(input)) {
                return toUpperCase(input.charAt(0));
            }
        }
    }

    private LetterInput() {}
}
