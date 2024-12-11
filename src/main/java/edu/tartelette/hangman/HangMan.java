package edu.tartelette.hangman;

public class HangMan {
    private static final int MAX_HANG_STAGE = 6;
    private static final String ERROR_INCREASE_HANG_STAGE =
            "Error increaseHangStage method. Состояние висельника некорректно";
    private int hangStage = 0;

    public HangMan() { }

    public int getHangStage() {
        return hangStage;
    }

    public int getMaxHangStage() {
        return MAX_HANG_STAGE;
    }

    public boolean isAlive() {
        return (hangStage != MAX_HANG_STAGE);
    }

    public void increaseHangStage() throws IllegalHangManStageException {
        if (hangStage >= MAX_HANG_STAGE) {
            throw new IllegalHangManStageException(ERROR_INCREASE_HANG_STAGE);
        }
        hangStage++;
    }
}
