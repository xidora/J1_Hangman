package edu.tartelette.hangman;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Random;


public final class Dictionary {

    private static final String ERROR_READ_DICTIONARY =
            "Error getLibraryOfWords method. Ошибка при чтении файла словаря ";

    private Dictionary() {
    }

    public static String getRandomWord(String fileName) throws EmptyDictionaryException {
        final List<String> libraryOfWords = getLibraryOfWords(fileName);
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
        List<String> fileLines = null;
        try {
            fileLines = Files.readAllLines(file.toPath());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return fileLines;
    }
}