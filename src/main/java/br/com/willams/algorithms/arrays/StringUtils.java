package br.com.willams.algorithms.arrays;

public class StringUtils {
    public static String reverse(String text) {
        var chars = text.toCharArray();
        
        for(int i = 0; i < chars.length / 2; i++) {
            var tmp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = tmp;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        var text = "the quick brown fox jumps over the lazy dog";
        System.out.println("Texto: \"" + text + "\" invertido é: \"" + StringUtils.reverse(text) + "\"");
    }

}
