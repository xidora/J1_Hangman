package edu.tartelette.hangman;

import java.util.Scanner;

import static java.lang.Character.toUpperCase;

public class RussianLetterInput {

    private static final String INPUT_LETTER = "Введите новую невведенную буквы [а-яА-Я] :";

    public static char get() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(INPUT_LETTER);
            String input = scanner.nextLine();
            if (Validator.isValid(input)) {
                return toUpperCase(input.charAt(0));
            }
        }
    }

    private RussianLetterInput() {}
}
