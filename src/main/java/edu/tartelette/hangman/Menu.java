package edu.tartelette.hangman;

import java.util.Scanner;

public class Menu {
    private static final String PLAY = "Н";
    private static final String EXIT = "В";
    private static final String CHOICE = "===\nВведите [%s%s] для начала игры " +
        "или [%s%s] для Выхода";
    private static final String INVALID_CHOICE = "Ввод некорректен";


    private Menu() { }

    public static void start() {
        while (true) {
            System.out.println(CHOICE.formatted(
                PLAY,
                PLAY.toLowerCase(),
                EXIT,
                EXIT.toLowerCase()
            ));

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().toUpperCase();

            switch (input) {
                case PLAY:
                    new Game().start();
                    break;
                case EXIT:
                    System.exit(0);
                    break;
                default:
                    System.out.println(INVALID_CHOICE);
                    break;
            }
        }
    }
}
