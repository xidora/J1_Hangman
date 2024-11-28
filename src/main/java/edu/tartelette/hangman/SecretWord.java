package edu.tartelette.hangman;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class SecretWord {
  private String secretWord = Dictionary.getRandomWord().toUpperCase();
  private List<Character> displayWord = getInitialDisplayWord();

  public SecretWord() {}

  public void revealLetter(char letter) {
    for (int i = 0; i < displayWord.size(); i++) {
      if (secretWord.charAt(i) == letter) {
        displayWord.set(i, letter);
      }
    }
  }

  public String getVisibleWord() {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < displayWord.size(); i++) {
      stringBuilder.append(displayWord.get(i));
    }
    return stringBuilder.toString();
  }

  public String getSecretWord() {
    return secretWord;
  }

  public Set<Character> getStartLetters() {
    Set<Character> secretLetters = new HashSet<>();
    for (int i = 0; i < secretWord.length(); i++) {
      secretLetters.add(secretWord.charAt(i));
    }
    return secretLetters;
  }

  //return hidden Secret word under "*"
  private List<Character> getInitialDisplayWord() {
    List<Character> hiddenWord = new LinkedList<>();
    for (int i = 0; i < secretWord.length(); i++) {
      hiddenWord.add('*');
    }
    return hiddenWord;
  }
}
