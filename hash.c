#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//Estrutura base do nó->
struct Node
{
  int valor;
  struct Node *proximo;
};

typedef struct Node node;

// funcao que retorna o ultimo digito do numero como chave de hash
int hash(int codigo)
{
  int chave = codigo;
  while (chave >= 10)
  {
    chave = chave % 10;
  }
  return chave;
}

// imprime a lista na posicao da chave hash
void displayLL(int chave, node *p)
{
  int i;
  printf("\nposicao %d:", chave);
  if (p)
  {
    do
    {
      printf(" %d ", p->valor);
      p = p->proximo;
    } while (p);
  }
  else
    printf("nodo vazio.");
}

int main(void)
{
  int tamanho_da_tabela_hash = 10, i;
  node *tabela_hash[sizeof(node *) * tamanho_da_tabela_hash];
  for(i=0;i<tamanho_da_tabela_hash;i++){
    tabela_hash[i]=NULL;
  }

  // criando o primeiro nodo na tabela hash
  int codigo1 = 100112345;
  int chave1 = hash(codigo1);

  // criando o primeiro nodo na tabela hash
  tabela_hash[chave1] = (node *)malloc(sizeof(node));
  tabela_hash[chave1]->valor = codigo1;
  tabela_hash[chave1]->proximo = NULL;

  // informacoes para inserir o segundo nodo
  int codigo2 = 100154321;
  int chave2 = hash(codigo2);

  // criando o segundo nodo na tabela hash
  tabela_hash[chave2] = (node *)malloc(sizeof(node));
  tabela_hash[chave2]->valor = codigo2;
  tabela_hash[chave2]->proximo = NULL;

  // imprimindo toda a estrutura
  for (int i = 0; i < 10; i++)
  {
    if (tabela_hash[i])
    {
      displayLL(i, tabela_hash[i]);
    }
    else
    {
      printf("\nposicao %d, nodo vazio", i);
    }
  }

  return 0;
}
