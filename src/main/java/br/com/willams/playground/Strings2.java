package br.com.willams.playground;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Strings2 {
	public Map<Character, Long> duplicateCharsCount(String s) {
		return s.chars()
				.mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}

	public static void main(String[] args) {
		var s2 = new Strings2();

		var s = "aabcdxxxxxxxeffgh";

		log.info("teste");
		
		s2.duplicateCharsCount(s)
				.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue())
				.forEach(e -> log.info("{}", e));
		// .entrySet()
		// .stream()
		// .sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap()).entrySet()
		// .forEach(entry -> System.out.println(entry.getKey() + "=" +
		// entry.getValue()));
	}
}
