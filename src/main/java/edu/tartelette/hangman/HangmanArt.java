package edu.tartelette.hangman;

public class HangmanArt {

  private static final String[] ART = new String[]{
      """
        ═╦═════╦═
         ║     |
         ║     O
         ║    /|\\
         ║    / \\
         ║
        ═╩═══════
        """,
      """
        ═╦═════╦═
         ║     |
         ║     O
         ║    /|\\
         ║    /
         ║
        ═╩═══════
        """,
      """
        ═╦═════╦═
         ║     |
         ║     O
         ║    /|\\
         ║
         ║
        ═╩═══════
        """,
      """
        ═╦═════╦═
         ║     |
         ║     O
         ║    /|
         ║
         ║
        ═╩═══════
        """,
      """
        ═╦═════╦═
         ║     |
         ║     O
         ║    /
         ║
         ║
        ═╩═══════
        """,
      """
        ═╦═════╦═
         ║     |
         ║     O
         ║
         ║
         ║
        ═╩═══════
        """,
      """
        ═╦═════╦═
         ║     |
         ║
         ║
         ║
         ║
        ═╩═══════
        """,
  };

  public static void printHangmanArt(int attemptsLeft) {
    System.out.print(ART[attemptsLeft]);
  }

  private HangmanArt() {}
}
