package baseball.testutil;

import baseball.service.NumberProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberProviderFake implements NumberProvider {
	
	private List<Integer> numbers = new ArrayList<>();
	private int numbersCount = 0;
	
	public void setNumbers(Integer... numbers) {
		this.numbers.addAll(Arrays.asList(numbers));
	}
	
	@Override
	public List<Integer> provide() {
		List<Integer> numbers = this.numbers.subList(numbersCount, numbersCount + 3);
		numbersCount += 3;
		return numbers;
	}
}
