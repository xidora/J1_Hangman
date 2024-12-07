package edu.tartelette.hangman;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;


public final class Dictionary {

    private static final String ERROR_READ_DICTIONARY =
            "Error getLibraryOfWords method. Ошибка при чтении файла словаря ";

    private Dictionary() {}

    public static String getRandomWord(String fileName, Random random) throws EmptyDictionaryException {
        final List<String> libraryOfWords = getLibraryOfWords(fileName);
        int wordsNumber = random.nextInt(libraryOfWords.size());
        return libraryOfWords.get(wordsNumber);
    }

    private static List<String> getLibraryOfWords(String fileName) throws EmptyDictionaryException {
        ClassLoader classLoader = Dictionary.class.getClassLoader();
        if (classLoader.getResource(fileName) == null) {
            throw new EmptyDictionaryException(ERROR_READ_DICTIONARY);
        }
        List<String> fileLines = null;
        URL resource = classLoader.getResource(fileName);
        Path path = null;
        try {
            path = Paths.get(resource.toURI());
            fileLines = Files.readAllLines(path);
        } catch (IOException | URISyntaxException exception) {
            exception.printStackTrace();
        }
        return fileLines;
    }
}