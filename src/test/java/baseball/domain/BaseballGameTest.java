package baseball.domain;

import baseball.common.dto.BaseballRoundResult;
import baseball.testutil.NumberProviderFake;
import baseball.testutil.RoundResultConsumerFake;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameTest {
	
	private BaseballGame sut;
	
	@BeforeEach
	void setUp() {
		BaseballNumbers baseballNumbers = BaseballNumbers.from(List.of(1, 2, 3));
		BaseballRound baseballRound = new BaseballRound(baseballNumbers);
		sut = new BaseballGame(baseballRound);
	}
	
	@Nested
	class 야구_게임을_플레이_테스트 {
		
		@Test
		void 플레이를_하고_나면_전부_스트라이크이다() {
		    //given
			NumberProviderFake numberProviderFake = new NumberProviderFake();
			RoundResultConsumerFake roundResultConsumerFake = new RoundResultConsumerFake();
			numberProviderFake.setNumbers(
					3, 2, 1,
					2, 3, 1,
					1, 2, 3
			);
			
			//when
			BaseballRoundResult result = sut.play(numberProviderFake, roundResultConsumerFake);
			
			//then
			assertThat(result).extracting(
					"strikeCount", "ballCount"
			).containsExactly(3, 0);
		}
		
		@Test
		void 플레이를_하고_나면_그_기록들이_반환된다() {
			//given
			NumberProviderFake numberProviderFake = new NumberProviderFake();
			RoundResultConsumerFake roundResultConsumerFake = new RoundResultConsumerFake();
			numberProviderFake.setNumbers(
					3, 2, 1,
					2, 3, 1,
					1, 2, 3
			);
			
			//when
			sut.play(numberProviderFake, roundResultConsumerFake);
			
			//then
			assertThat(roundResultConsumerFake.getResults()).extracting(
					"strikeCount", "ballCount"
			).containsExactly(
					Tuple.tuple(1, 2),
					Tuple.tuple(0, 3),
					Tuple.tuple(3, 0)
			);
		}
	}
}