# Introdução ao Insertion Sort

## Introdução

O algorítmo de ordenação por inserção (insertion sort) é cerca de duas vezes mais rápido que o método da bolha e um pouco mais rápido que a ordenação por seleção em situações normais (random input).

## Teoria

- Na primeira passada é comparado no máximo 1 item. Na segunda passada no máximo 2 itens, na terceira 3, etc.
- 1+2+3+ ... + N -1 = N*(N-1) / 2 comparações (pior caso)
- Em cada passagem a média de comparações é cerca de metade dos itens, então: N*(N-1) / 4 comparações (caso médio)
- O número de cópias é aproximadamente o mesmo que o de comparações
- para dados alteatórios é 2x mais rápido que o da bolha e mais rápido que o de seleção
- é ainda mais eficiente para dados quase ordeandos.
- para dados inversamente ordenados todas as comparações e deslocamentos serão executados ficando ainda mais lento que o da bolha.
- O(N^2)


## Explicação

- marcamos algum local no meio do vetor
- os elementos à esquerda estarão ordenados entre eles, mas não estarão na sua posição final ainda.
- os elementos à direita não estarão ordenados