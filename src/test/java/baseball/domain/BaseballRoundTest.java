package baseball.domain;

import baseball.common.dto.BaseballRoundResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballRoundTest {
	
	private BaseballRound sut;
	
	@BeforeEach
	void setUp() {
		BaseballNumbers baseballNumbers = BaseballNumbers.from(List.of(1, 2, 3));
		sut = new BaseballRound(baseballNumbers);
	}
	
	@Nested
	class 라운드_테스트 {
		
		@ParameterizedTest
		@CsvSource({
				"1, 2, 3, 3, 0",
				"1, 2, 4, 2, 0",
				"1, 4, 5, 1, 0",
				"1, 3, 5, 1, 1",
				"1, 3, 2, 1, 2",
		})
		void 정상적으로_스트라이크_볼_개수를_계산한다(int num1, int num2, int num3, int strikeCount, int ballCount) {
			//given
			
			//when
			BaseballRoundResult result = sut.playOneRound(() -> List.of(num1, num2, num3));
			
			//then
			assertThat(result).extracting(
					"strikeCount", "ballCount"
			).containsExactly(
					strikeCount, ballCount
			);
		}
	}
}
