package br.com.willams.algorithms.math;

public class MathAlgorithms {
    double averageOfEvenNumbers(int v[], int n) {
        // A média dos números pares será definida como
        // a soma desses números divida pela quantidade deles
        // dessa forma, manteremos a soma e a quantidade
        double sum = 0.0;
        double countOfEvenNumbers = 0;

        // Iteramos cada número no vetor e se encontrarmos um número par,
        // atualizamos sum e countOfEventNumbers
        for (int i = 0; i < v.length; i++) {
            // o número é par?
            if(v[i] % 2 == 0) {
                sum += v[i];
                countOfEvenNumbers++;
            }
        }

        if(countOfEvenNumbers == 0) return 0.0;

        return sum / countOfEvenNumbers;

    }
}
