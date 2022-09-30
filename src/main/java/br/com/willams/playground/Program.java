package br.com.willams.playground;

import java.util.Scanner;
import java.util.stream.Collectors;

class Programa {

    public static void main(String[] args) {
        Scanner oT = new Scanner(System.in);

        // System.out.println("digite a frase: ");
        // String frase = oT.nextLine();
        // System.out.println("Digite a quantidade de rotações: ");
        // int rot = oT.nextInt();

        var frase = "ABC";
        int rot = 4;
        int B = ((int)'b');
        var newFrase = new StringBuilder();
        
        for (int i = 0; i < frase.length(); i++) {
            var ch = (int)frase.charAt(i);
            var newCh = (char) (ch + (B + (rot % 26)));
            newFrase.append(newCh);
        }

        System.out.println(newFrase);

        // var frase = "abc";
        // frase.chars()
        // .mapToObj(ch -> rotIndex - (ch - (int) 'a'))
        // .peek(System.out::println)
        // .map(newC -> String.valueOf(Character.toChars(newC)))
        // .collect(Collectors.toList());

        // int position = (int) 'c' - (int) 'a';
        // position = 26 - position;

        // System.out.println(a[position]);

        // position = position % 26;

        // System.out.println(a[position]);

        // while (rot != 0) {
        // frase = frase.replace("z", "a");
        // frase = frase.replace("y", "z");
        // frase = frase.replace("x", "y");
        // frase = frase.replace("w", "x");
        // frase = frase.replace("v", "w");
        // frase = frase.replace("u", "v");
        // frase = frase.replace("t", "u");
        // frase = frase.replace("s", "t");
        // frase = frase.replace("r", "s");
        // frase = frase.replace("q", "r");
        // frase = frase.replace("p", "q");
        // frase = frase.replace("o", "p");
        // frase = frase.replace("n", "o");
        // frase = frase.replace("m", "n");
        // frase = frase.replace("l", "m");
        // frase = frase.replace("k", "l");
        // frase = frase.replace("j", "k");
        // frase = frase.replace("i", "j");
        // frase = frase.replace("h", "i");
        // frase = frase.replace("g", "h");
        // frase = frase.replace("f", "g");
        // frase = frase.replace("e", "f");
        // frase = frase.replace("d", "e");
        // frase = frase.replace("c", "d");
        // frase = frase.replace("b", "c");
        // frase = frase.replace("a", "b");

        // System.out.println(frase);
        // rot--;
        // }

        // System.out.println(frase);
    }
}