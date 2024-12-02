package edu.tartelette.hangman;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;


public final class Dictionary {

  private static final String ERROR_READ_DICTIONARY = "Ошибка при чтении файла словаря ";

  private Dictionary() {}

  public static String getRandomWord(String fileName) throws EmptyDictionaryException {
    final List<String> libraryOfWords = getLibraryOfWords(fileName);
    System.out.println("libraryOfWords.size() = " + libraryOfWords.size());
    Random random = new Random();
    int wordsNumber = random.nextInt(libraryOfWords.size());
    return libraryOfWords.get(wordsNumber);
  }

  private static List<String> getLibraryOfWords(String fileName) throws EmptyDictionaryException {
    ClassLoader classLoader = Dictionary.class.getClassLoader();
    if (classLoader.getResource(fileName) == null) {
      throw new EmptyDictionaryException(ERROR_READ_DICTIONARY);
    }
    File file = new File(classLoader.getResource(fileName).getFile());
    System.out.println("2");
    List<String> fileLines;
    try {
      fileLines = Files.readAllLines(file.toPath());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return fileLines;
  }
}