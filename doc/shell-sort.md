# Introdução ao Insertion Sort

## Introdução

O algorítmo de ordenação Shell foi inventado por Donald Shell (daí o nome) e é derivado do insertion sort.
Sabemos que o insertion sort funciona bem para entradas que já estão quase ordenadas. O shell  sort é um método que dá uma 'arrumada' no vetor de entrada antes de aplicar o insertion sort. Ou seja, ele ordena alguns elementos primeiro. Em vez de chamar o insertion sort comparando valores adjacentes, o algoritmo aplica uma ordenação pulando alguns valores. Por conta disso, o shell sort também é conhecido como um n-gap insertion sort.


## Teoria




## Explicação

- o vetor original é quebrado em subvetores
- cada subvetor é ordenado comparando e trocando valores.
- ao final de uma rodada o subvetor é quebrado em mais um subvetor
- vetor com 20 elementos: 
    - primeira rodada: 10 elementos
    - segundao rodada: 5 elementos
    - terceira rodada: 2/3 elementos

