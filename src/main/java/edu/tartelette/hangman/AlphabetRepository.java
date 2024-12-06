package edu.tartelette.hangman;

import java.util.HashSet;
import java.util.Set;

public class AlphabetRepository {
    private final Set<Character> Letters = new HashSet<>();

    public AlphabetRepository() {}

    public Set<Character> getLetters() {
        return Letters;
    }

    public void addLetter(char character) throws AlphabetRepositoryException {
        if (Letters.contains(character)) {
            throw new AlphabetRepositoryException("Alphabet already exists");
        }
        Letters.add(character);
    }

    public boolean containsLetter(char character) {
        return Letters.contains(character);
    }
}
