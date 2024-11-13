package edu.tartelette.hangman;

import java.util.Scanner;

public class Menu {

  private static final String CHOICE_TEXT = "===\nВведите [н,Н] для начала игры или [в,В] для Выхода";
  private static final String INVALID_CHOICE = "Ввод некорректен";

  private static final String PLAY = "Н";
  private static final String EXIT = "В";

  public static void start() {
    while (true) {
      System.out.println(CHOICE_TEXT);
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

  private Menu() {}
}
