package baseball.io.writer;

public class SystemWriter implements Writer {
	
	@Override
	public void write(final String value) {
		System.out.print(value);
	}
}
