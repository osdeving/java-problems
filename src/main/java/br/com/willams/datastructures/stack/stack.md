# O que é uma Pilha

Pilha é uma estrutura de dados para armazenar dados, similar a Lista Encadeada.
Na pilha a inserção e remoção é feito em uma única ponta chamada TOPO.
O último elemento a ser inserido é o primeiro a ser removido.
Isso é conhecido como LIFO (Last In, First Out) ou FILO (First In, Last Out).
É o mesmo comportamento de uma pilha de pratos (o último prato colocado é o primeiro a ser retirado).

## Principais operações

void push(int data): insere 'data' no topo da pilha
int pop(): remove o último elemento inserido na pilha
int top(): retorna o último elemento sem remove-lo
int size(): retorna o número de elementos na pilha
int isEmpty(): indica se a pilha está vazia
int isFull(): indica se a pilha está cheia


## Aplicações

###  Aplicações Diretas

- balancear símbolos
- infix-to-postfix converção
- avaliar expressões postfix 
- implementar chamadas de funções (incluindo recursão)
- encontrar spans
- páginas visitadas no histórico em um navegador
- undo em um editor de textos
- matching tags em HTML ou XML

### Aplicações Indiretas

- estrutura auxiliar para outros algorítmos, tipo percorrer uma árvore.
- componente de outras estruturas de dados, tipo simular uma fila.

## Implementação

- Simple Array
- Dynamic Array 
- Linked List


## Anotações

### Problem-3 - For a given array with n symbols how many stack permutations are possible?
##### Solution: The number of stack permutations with n symbols is represented by Catalan number.
