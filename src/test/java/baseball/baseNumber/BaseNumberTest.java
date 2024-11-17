package baseball.baseNumber;

import baseball.guessNumber.GuessNumber;
import baseball.guessResult.GuessResult;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseNumberTest {

    @Test
    void from_베이스숫자갯수_예외처리() {
        Set<Integer> randomDistinctNumbers = new HashSet<>(List.of(1, 2, 3, 4));
        assertThatThrownBy(
                ()-> {
                    BaseNumber baseNumber = BaseNumber.from(randomDistinctNumbers);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void match_3스트라이크() {
        Set<Integer> randomDistinctNumbers = new HashSet<>(List.of(1, 2, 3));
        BaseNumber baseNumber = BaseNumber.from(randomDistinctNumbers);
        GuessNumber guessNumber = GuessNumber.from(randomDistinctNumbers.stream().toList());
        GuessResult guessResult = baseNumber.match(guessNumber);

        assertThat(guessResult.fullStrike()).isTrue();
        assertThat(guessResult.toString().contains("3스트라이크")).isTrue();
    }

    @Test
    void match_낫싱() {
        Set<Integer> randomDistinctNumbers = new HashSet<>(List.of(1, 2, 3));
        BaseNumber baseNumber = BaseNumber.from(randomDistinctNumbers);
        GuessNumber guessNumber = GuessNumber.from(List.of(4,5,6));
        GuessResult guessResult = baseNumber.match(guessNumber);

        assertThat(guessResult.toString().contains("낫싱")).isTrue();
    }

    @Test
    void match_1볼_1스트라이크() {
        Set<Integer> randomDistinctNumbers = new HashSet<>(List.of(1, 2, 3));
        BaseNumber baseNumber = BaseNumber.from(randomDistinctNumbers);
        GuessNumber guessNumber = GuessNumber.from(List.of(1,5,2));
        GuessResult guessResult = baseNumber.match(guessNumber);

        assertThat(guessResult.toString().contains("1볼 1스트라이크")).isTrue();
    }
}