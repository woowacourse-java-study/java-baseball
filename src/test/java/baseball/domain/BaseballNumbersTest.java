package baseball.domain;

import baseball.common.dto.BaseballRoundResult;
import baseball.testutil.NumberPickerFake;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumbersTest {
	
	@Nested
	class 생성_테스트 {
		
		@Test
		void 정상적으로_생성한다() {
		    //given
			List<Integer> numbers = List.of(1, 2, 3);
			
			//when
			BaseballNumbers result = BaseballNumbers.from(numbers);
			
			//then
			assertThat(result).extracting(
					"baseballNumbers"
			).isEqualTo(
					List.of(BaseballNumber.from(1), BaseballNumber.from(2), BaseballNumber.from(3))
			);
		}
		
		@Test
		void NumberPicker를_통해_생성한다() {
			//given
			NumberPickerFake numberPickerFake = new NumberPickerFake();
			numberPickerFake.setNumbers(1, 2, 3);
			
			//when
			BaseballNumbers result = BaseballNumbers.from(numberPickerFake);
			
			//then
			assertThat(result).extracting(
					"baseballNumbers"
			).isEqualTo(
					List.of(BaseballNumber.from(1), BaseballNumber.from(2), BaseballNumber.from(3))
			);
		}
		
		@Test
		void 개수가_초과하게_생성하면_예외가_발생한다() {
			//given
			List<Integer> numbers = List.of(1, 2, 3, 4);
			
			//expected
			assertThatThrownBy(() -> BaseballNumbers.from(numbers))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("잘못된 숫자 개수 입니다.");
		}
		
		@Test
		void 개수가_부족하게_생성하면_예외가_발생한다() {
			//given
			List<Integer> numbers = List.of(1, 2);
			
			//expected
			assertThatThrownBy(() -> BaseballNumbers.from(numbers))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("잘못된 숫자 개수 입니다.");
		}
	}
	
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
