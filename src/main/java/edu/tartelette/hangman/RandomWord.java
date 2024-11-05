package edu.tartelette.hangman;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RandomWord {

    public static String getRandomWord() {
        ArrayList<String> libraryOfWords = getLibraryOfWords();

        Random aRandom = new Random();
        int wordsNumber = aRandom.nextInt(libraryOfWords.size());
        return libraryOfWords.get(wordsNumber);
    }

    public static ArrayList<String> getLibraryOfWords() {
        ArrayList<String> libraryOfWords = new ArrayList<>();
        try {
            if (ClassLoader.getSystemResourceAsStream("dictionary.txt") == null) {
                throw new FileNotFoundException("File not found ");
            }

            Scanner aScanner = new Scanner(ClassLoader.getSystemResourceAsStream("dictionary.txt"));
            while (aScanner.hasNext()) {
                libraryOfWords.add(aScanner.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
        return libraryOfWords;
    }

    private RandomWord() {}
}
