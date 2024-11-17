package baseball.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BaseballNumbersTest {
	
	@ParameterizedTest
	@CsvSource({
			"1, 2, 3, 3, 0",
			"1, 2, 4, 2, 0",
			"1, 5, 6, 1, 0",
			"3, 2, 1, 1, 2",
			"3, 2, 4, 1, 1",
	})
	void 야구_숫자들을_정상적으로_비교한다(int num1, int num2, int num3, int strikeCount, int ballCount) {
		//given
		BaseballNumbers tryBaseballNumbers = BaseballNumbers.from(List.of(num1, num2, num3));
		BaseballNumbers targetBaseballNumbers = BaseballNumbers.from(List.of(1, 2, 3));
		
		//when
		BaseballRoundResult result = targetBaseballNumbers.calculateStrikeBall(tryBaseballNumbers);
		
		//then
		assertThat(result).extracting(
				"strikeCount", "ballCount"
		).containsExactly(
				strikeCount, ballCount
		);
	}
}