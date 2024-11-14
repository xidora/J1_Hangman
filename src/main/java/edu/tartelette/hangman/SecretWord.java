package edu.tartelette.hangman;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class SecretWord {

  private String secretWord = Dictionary.getRandomWord().toUpperCase();
  private List<Character> visibleWord = getHiddenWord();

  public SecretWord() {}

  public void revealLetter(char letter) {
    for (int i = 0; i < visibleWord.size(); i++) {
      if (secretWord.charAt(i) == letter) {
        visibleWord.set(i, letter);
      }
    }
  }

  public String getVisibleWord() {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < visibleWord.size(); i++) {
      stringBuilder.append(visibleWord.get(i));
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
  private List<Character> getHiddenWord() {
    List<Character> hiddenWord = new LinkedList<>();
    for (int i = 0; i < secretWord.length(); i++) {
      hiddenWord.add('*');
    }
    return hiddenWord;
  }
}
