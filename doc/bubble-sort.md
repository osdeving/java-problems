# Introdução ao Bubble Sort

## Introdução

O algorítmo de ordenação  bubble (em português, bolha) tem esse nome porque se você imaginar que os valores ao serem trocados de lugar precisa subir, caminhar até à direita e então descer, esse movimento lembra bolhas em uma superfície (eu consigo ver, você não!? :D).

## Teoria

- para 10 elementos, serão 9 comparações na primeira passagem, 8 na segunda, 7 na terceira, etc.. (n-1, n-2, n-3)

- 10 itens: 9 + 8 + 7 + 6 + 5 + 4 + 3 + 2 + 1 = 45 comparações

- O(N^2)

- aproximadamente N^2 / 2 comparações
- haverá menos trocas que comparações, visto que nem sempre será necessário trocar
- para dados aleatórios haverá mais ou menos N^2 / 4 trocas
- para o pior caso (uma lista inversamente ordenada) haverá 1 troca por cada comparação





## Explicação

Dada a sequência [99, 1, 3, 4], para levar o primeiro item uma casa para direita podemos fazer uma troca simples:

int[] array = int[]{99, 1, 3, 4};

int temp = array[0]; // vamos sobrescrever esse valor, então guardamos ele primeiro
array[0] = array[1];
array[1] = temp; // note que aqui array[0] não tem mais o valor inicial, isso explica a váriável temp

Assim, o array agora será: [1, 99, 3, 4]

Para levar o segundo valor para direita, poderias repetir o processo:

int temp = array[1];
array[1] = array[2];
array[2] = temp;

Perceba que agora o array será: [1, 3, 99, 4]

Se repetirmos o processo para o terceiro valor, levando-o para a quarta posição, teríamos: [1, 3, 4, 99]

Agora imagem que em vez de 99 tenhamos o valor 2 em seu lugar. A sequência final seria: [1, 3, 4, 2]

Notamos que não seria necessário fazer a primeira troca, pois 1 já é menor que 2, tampouco as demais trocas, pois 2 é menor que 3 e 3 é menor que 4.

O algorimo de ordenação bubble faz o processo acima, ele vai percorrer o array e vai verificar se o valor na posição i é maior que o valor na posição i+1 e caso seja, irá trocar de lugar. Esse processo se repete até o final.  Então, dada a sequência [4, 1, 3, 2]

Faríamos:

no array [4,1, 3, 2] da posição 1 até a 4 faz:
    4 é maior que 1?
        sim, então troca 4 com 1 e ficamos com [1, 4, 3, 2]

no array [1, 4, 3, 2] da posição 2 até a 4 faz:
    4 é maior que 3?
        sim, então troca 4 com 3 e ficamos com [1, 3, 4, 2]

no array [1, 3, 4, 2] da posição 3 até a 4 faz:
    4 é maior que 2?
        sim, então troca 4 com 2 e ficamos com [1, 3, 2, 4]

no array [1, 3, 2, 4] da posição 4 até a 4 faz:
    4 é maior que 4?
        não, então não faz nada e ficamos com [1, 3, 2, 4]

Isso jogou o 4 até sua posição correta. O processo então deverá voltar até a posição inicial desse vetor e fazer tudo novamente.
Perceba que 1 não será maior que 3, então não fará nada, mas na próxima rodada 3 será maior que 2 e fará a troca e na próxima não fará nada.

Isso jogou o 3 até sua posição correta. O processo então deverá voltar até a posição inicial desse vetor e fazer tudo novamente.
Perceba que tudo já está ordenado, então haverá apenas comparações, mas não trocas.

Como jogar isso no código? Simples:

dado o array de tamanho N, da posição i até N faz:
    da posição j até N faz:
        array[j] é maior que arra[j + 1]?
            sim, então troca arra[j] com arra[j+1]
        

Não é tão simples se você tá vendo esse assunto agora. Sugiro que pegue alguns exemplos com 4 posições e faça manualmente o processo até entender a lógica.
Você vai notar, p.ex., que o segundo laço de repetição não precisa ir até N, porque na primeira vez o maior valor já foi até o final, na segunda vez o segundo maior valor já foi até a penúltima posição e assim por diante. Esse comportamento indica que é possível percorrer até N - i. Note também que se o array já tiver ordenado, não haveria nenhuma troca, mas não houver nenhuma troca então não precisa percorrer de novo. Esse comportamento permite um ajuste no algorítmo.

