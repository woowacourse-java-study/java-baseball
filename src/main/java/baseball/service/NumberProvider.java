package baseball.service;

import java.util.List;

@FunctionalInterface
public interface NumberProvider {
	
	List<Integer> provide();
}
