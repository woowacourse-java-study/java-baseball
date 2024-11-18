package baseball.domain;

import baseball.testutil.NumberPickerFake;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumberTest {
	
	@Nested
	class 생성_테스트 {
	
		@Test
		void 값으로_생성한다() {
		    //given
		    int number = 1;
		    
		    //expected
			assertThatCode(() -> BaseballNumber.from(number))
					.doesNotThrowAnyException();
		}
		
		@Test
		void NumberPicker를_통해_생성한다() {
			//given
			NumberPickerFake numberPickerFake = new NumberPickerFake();
			numberPickerFake.setNumbers(1, 2, 3);
			
			//expected
			assertThatCode(() -> BaseballNumber.from(numberPickerFake))
					.doesNotThrowAnyException();
		}
		
		@Test
		void 범위보다_작은_값으로_생성하려고_하면_예외가_발생한다() {
			//given
			int number = 0;
			
			//expected
			assertThatThrownBy(() -> BaseballNumber.from(number))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("잘못된 숫자 범위 입니다.");
		}
		
		@Test
		void 범위보다_큰_값으로_생성하려고_하면_예외가_발생한다() {
			//given
			int number = 10;
			
			//expected
			assertThatThrownBy(() -> BaseballNumber.from(number))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("잘못된 숫자 범위 입니다.");
		}
	}
}
