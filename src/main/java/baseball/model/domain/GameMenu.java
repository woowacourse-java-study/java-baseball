package baseball.model.domain;

import java.util.Arrays;

public enum GameMenu {
    RESTART("1", true),
    QUIT("2", false);

    private final String code;
    private final boolean countinue;

    GameMenu(String code, boolean countinue) {
        this.code = code;
        this.countinue = countinue;
    }

    public static GameMenu from(String input) {
        return Arrays.stream(GameMenu.values())
                .filter(menu -> menu.code.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 메뉴 선택입니다."));
    }
}