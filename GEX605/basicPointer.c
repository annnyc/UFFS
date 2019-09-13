#include <stdio.h>

int main(){
  int valor = 27;
  int *ponteiro;

  ponteiro = &valor;
  printf("conteúdo da variavel valor: %d\n",valor);
  printf("endereco da variavel valor: %x\n", valor);
  printf("conteudo da variavel ponteiro: %x", ponteiro);

}
