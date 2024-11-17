package baseball.dto;

import baseball.model.Numbers;

public class ComputerDto {
    private final Numbers numbers;

    public ComputerDto(Numbers numbers) {
        this.numbers = numbers;
    }

    public Numbers getNumbers() {
        return numbers;
    }
}
