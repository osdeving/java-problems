package br.com.willams.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

public class StringLikeAlgorithms {
    // dado um array como ["a", "b", "c", "d"], retornar uma lista com
    // [
    //      "ab", "ac", "ad", "ba", "bc", "bd",
    //      "ca", "cb", "cd", "da", "db", "dc"
    // ]
    List<String> wordBuilder(char v[], int n) {
        var result = new ArrayList<String>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i != j) {
                    result.add(String.valueOf(v[i]) + String.valueOf(v[j]));
                }
            }
        }

        return result;
    }
}
