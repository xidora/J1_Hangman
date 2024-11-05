package edu.tartelette.hangman;

import java.util.HashSet;
import java.util.LinkedList;

public class SecretWord {

    private String secretWord = RandomWord.getRandomWord().toUpperCase();
    private LinkedList<Character> visibleWord = getHiddenWord();

    public SecretWord() {}

    public void revealLetter(char letter) {
        for (int i = 0; i < visibleWord.size(); i++) {
            if (secretWord.charAt(i) == letter) {
                visibleWord.set(i, letter);
            }
        }
    }

    public String getVisibleWord() {
        StringBuilder aStringBuilder = new StringBuilder();
        for (int i = 0; i < visibleWord.size(); i++) {
            aStringBuilder.append(visibleWord.get(i));
        }
        return aStringBuilder.toString();
    }

    public String getSecretWord() {
        return secretWord;
    }

    public HashSet<Character> getStartLetters() {
        HashSet<Character> secretLetters = new HashSet<>();
        for (int i = 0; i < secretWord.length(); i++) {
            secretLetters.add(secretWord.charAt(i));
        }
        return secretLetters;
    }

    //return hidden Secret word under "*"
    private LinkedList<Character> getHiddenWord() {
        LinkedList<Character> hiddenWord = new LinkedList<>();
        for(int i = 0; i < secretWord.length(); i++) {
            hiddenWord.add('*');
        }
        return hiddenWord;
    }
}
