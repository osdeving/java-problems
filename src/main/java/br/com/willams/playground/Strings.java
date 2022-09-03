package br.com.willams.playground;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public final class Strings {
	private Strings() {
		throw new AssertionError("Cannot be instantiated");
	}

	public static Map<Character, Long> countDuplicateCharsV1(String str) {
		var result = new HashMap<Character, Long>();

		for(char ch : str.toCharArray()) 
			result.compute(ch, (k,v) -> (v == null) ? 1 : ++v);
		
		return result;
	}

	public static Map<Character, Long> countDuplicateCharsV2(String inputTexString) {
		return inputTexString
				.chars()
				.mapToObj(c -> (char)c)
				.collect(groupingBy(c -> c, counting()));
	}

	public static Map<String, Long> countDuplicateCharsVCP1(String str) {

		var result = new HashMap<String, Long>();

		for(int i = 0; i < str.length(); i++) {
			int cp = str.codePointAt(i);

			String ch = String.valueOf(Character.toChars(cp));

			if(Character.charCount(cp) == 2) {
				i++;
			}

			result.compute(ch, (k ,v) -> (v == null) ? 1 : ++v);
		}

		return result;
	}

	public static Map<String, Long> countDuplicateCharsVCP2(String str) {
		return str
			.codePoints()
			.mapToObj(c -> String.valueOf(Character.toChars(c)))
			.collect(groupingBy(Function.identity(), counting()));
	}
}