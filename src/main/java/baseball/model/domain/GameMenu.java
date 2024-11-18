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

    private boolean isCountinue() {
        return countinue;
    }

    public static boolean from(String input) {
        return Arrays.stream(GameMenu.values())
                .filter(menu -> menu.code.equals(input))
                .findFirst()
                .map(GameMenu::isCountinue)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 메뉴 선택입니다."));
    }
}