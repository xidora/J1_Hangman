package edu.tartelette.hangman;

import java.util.Scanner;

public class Choicer {

    private static final String CHOICE_TEXT = "===\nType [s] to start or [e] to exit";
    private static final String INVALID_CHOICE_TEXT = "Type [s] to start or [e] to exit";

    public static void start() {
        while (true) {
            System.out.println(CHOICE_TEXT);
            Scanner aScanner = new Scanner(System.in);
            String input = aScanner.nextLine().toUpperCase();
            switch (input) {
                case "S":
                    new Game().start();
                    break;
                case "E":
                    System.exit(0);
                    break;
                default:
                    System.out.println(INVALID_CHOICE_TEXT);
                    break;
            }
        }
    }

    private Choicer() {}
}
