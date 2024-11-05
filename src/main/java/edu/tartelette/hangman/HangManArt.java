package edu.tartelette.hangman;

public class HangManArt {
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

    public static void printHangManArt(int i) {
        System.out.print(art[6 - i]);
    }

    private HangManArt() {}
}
