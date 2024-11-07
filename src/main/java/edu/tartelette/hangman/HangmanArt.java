package edu.tartelette.hangman;

public class HangmanArt {

    private static final String[] art = new String[] {
        """
        ═╦═════╦═
         ║     |
         ║
         ║
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
         ║    /|
         ║
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
         ║    / \\
         ║
        ═╩═══════
        """
    };

    public static void printHangmanArt(int i) {
        System.out.print(art[6 - i]);
    }

    private HangmanArt() {
    }
}
