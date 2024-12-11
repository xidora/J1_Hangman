package edu.tartelette.hangman;

import java.util.LinkedList;
import java.util.List;

public class SecretWord {
    private static final String ERROR_REVEAL_LETTER =
            "Error revealLetter method. В маске нет такой буквы";

    private final String secretWord;
    private final List<Character> mask;

    public SecretWord(final String newWord) throws EmptyDictionaryException {
        this.secretWord = newWord;
        mask = getInitialMask();
    }

    public String getSecretWord() {
        return secretWord;
    }

    public List<Character> getMask() {
        return mask;
    }

    public boolean isContainLetter(char letter) {
        for (int i = 0; i < secretWord.length(); i++) {
            if (letter == secretWord.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    public boolean isMaskCovered() {
        for (Character character : mask) {
            if (character == '*') {
                return true;
            }
        }
        return false;
    }

    public void revealLetter(char letter) throws LetterNotInWordException {
        boolean foundLetter = false;
        for (int i = 0; i < mask.size(); i++) {
            if (secretWord.charAt(i) == letter) {
                mask.set(i, letter);
                foundLetter = true;
            }
        }
        if (!foundLetter) {
            throw new LetterNotInWordException(ERROR_REVEAL_LETTER);
        }
    }

    private List<Character> getInitialMask() {
        List<Character> hiddenWord = new LinkedList<>();
        for (int i = 0; i < secretWord.length(); i++) {
            hiddenWord.add('*');
        }
        return hiddenWord;
    }
}
