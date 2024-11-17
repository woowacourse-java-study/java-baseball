package baseball.constant;

public enum GameConstant {
    GAME_SIZE(3),
    GAME_RANGE_START(1),
    GAME_RANGE_END(9);

    private final int value;

    GameConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
