package edu.tartelette.hangman;

import java.util.HashSet;
import java.util.Set;

public class LettersRepository {
    private final Set<Character> Letters = new HashSet<>();

    public LettersRepository() {}

    public Set<Character> getLetters() {
        return Letters;
    }

    public void addLetter(char character) throws LettersRepositoryException {
        if (Letters.contains(character)) {
            throw new LettersRepositoryException("Alphabet already exists");
        }
        Letters.add(character);
    }

    public boolean containsLetter(char character) {
        return Letters.contains(character);
    }
}
