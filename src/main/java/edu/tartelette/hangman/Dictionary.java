package edu.tartelette.hangman;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public final class Dictionary {

  private static final String FILE_NAME = "dictionary.txt";
  private static final String GAME_EXIT = "Can't read dictionary file\\nGame is over";
  private static final String ERROR_READ_DICTIONARY = "Error: Couldn't read dictionary file ";
  private static final String CAUGHT = "Caught Exception: ";

  private Dictionary() {}

  public static String getRandomWord() {
    ArrayList<String> libraryOfWords = getLibraryOfWords(FILE_NAME);

    Random random = new Random();
    int wordsNumber = random.nextInt(libraryOfWords.size());
    return libraryOfWords.get(wordsNumber);
  }

  public static ArrayList<String> getLibraryOfWords(String fileName) {
    ArrayList<String> libraryOfWords = new ArrayList<>();
    if (isFileExist(FILE_NAME)) {
      Scanner scanner = new Scanner(ClassLoader.getSystemResourceAsStream(fileName));
      while (scanner.hasNext()) {
        libraryOfWords.add(scanner.nextLine());
      }
    } else {
      System.out.println(GAME_EXIT);
      System.exit(0);
    }

    return libraryOfWords;
  }

  private static boolean isFileExist(String fileName) {
    try {
      if (ClassLoader.getSystemResourceAsStream(fileName) == null) {
        throw new FileNotFoundException(ERROR_READ_DICTIONARY + fileName);
      }
      return true;
    } catch (FileNotFoundException e) {
      System.out.println(CAUGHT + e.getMessage());
      return false;
    }
  }
}
