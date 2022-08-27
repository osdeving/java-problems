package br.com.willams.stringsandarrays;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/*
intera a string e usa Map com chars como key e números como value.
 */
public class CountingDuplicateCharsApp {
    public static void main(String[] args) {
        // imprime 3
        var str = "ABACATE";
        System.out.println(java8UnicodeCountDuplicateChars(str).get("A"));

        // imprime 2
        str = "ovo";
        System.out.println(countDuplicateChars(str).get('o'));

        CountingDuplicateCharsApp countingDuplicateCharsApp = new CountingDuplicateCharsApp();
        System.out.println(countingDuplicateCharsApp.soma(20, 20));
    }

    static Map<Character,Integer> countDuplicateChars(String str) {
        var result = new HashMap<Character, Integer>();

        for (int i = 0; i < str.length(); i++) {
            var ch = str.charAt(i);

            result.compute(ch, (k,v) -> (v == null) ? 1 : ++v);
        }

        return result;
    }

    static Map<Character,Long> java8countDuplicateChars(String str) {
        return str.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }

    static Map<String, Integer> UnicodeCountDuplicateChars(String str) {
        var result = new HashMap<String, Integer>();

        for (int i = 0; i < str.length(); i++) {
            int cp = str.codePointAt(i);
            String ch = String.valueOf(Character.toChars(cp));

            // 2 significa surrogate pair
            if(Character.charCount(cp) == 2) {
                i++;
            }
            result.compute(ch, (k,v) -> (v == null) ? 1 : ++v);
        }

        return result;
    }

    static Map<String,Long> java8UnicodeCountDuplicateChars(String str) {
        return str.codePoints()
                .mapToObj(c -> String.valueOf(Character.toChars(c)))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }


    int soma(int a, int b) {
        return a+b;
    }
}
