# Introdução ao Selection Sort

## Introdução

O algorítmo de ordenação por seleção (selection sort) é uma melhora do bubble sort reduzindo a quantidade de trocas necessários de N^2 para N. O número de comparações continua sendo N^2 / 2

## Teoria

- para 10 elementos, serão 9 comparações na primeira passagem, 8 na segunda, 7 na terceira, etc.. (n-1, n-2, n-3)

- 10 itens: 9 + 8 + 7 + 6 + 5 + 4 + 3 + 2 + 1 = 45 comparações

- O(N^2)

- aproximadamente N^2 / 2 comparações (igual o algoritmo da bolha)
- haverá menos de 10 trocas para 10 elementos, e nem sempre será necessário trocar
- para 100 itens haverá 4950 comparações e menos de 100 trocas.


## Explicação

