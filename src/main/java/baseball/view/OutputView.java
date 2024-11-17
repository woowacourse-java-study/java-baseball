package baseball.view;

import baseball.dto.MatchDto;

public class OutputView {
    public void responseGameIntro() {
        System.out.println("숫자 야구 게임을 시작합니다");
    }

    public void responseGameNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void responseGameRetry() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
    }

    public void responseGameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void responseMatchResult(MatchDto matchDto) {
        if (matchDto.getBall().equals(0) && matchDto.getStrike().equals(0)) {
            System.out.println("낫싱");
            return;
        }
        if (matchDto.getStrike().equals(0)) {
            System.out.println(matchDto.getBall() + "볼");
            return;
        }
        if (matchDto.getBall().equals(0)) {
            System.out.println(matchDto.getStrike() + "스트라이크");
            return;
        }
        System.out.println(matchDto.getBall() + "볼 " + matchDto.getStrike() + "스트라이크");
    }
}
