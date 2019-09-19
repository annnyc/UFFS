#include <stdio.h>
#include <math.h>
void calcubo (int *primeiro, int *segundo){
  int resultado = 0, aux=0;
  aux = (*primeiro) * (*primeiro);
  resultado = (*segundo) * (*segundo);
  resultado =  resultado + aux;
  // resultado = pow(primeiro,expoente);
  // resultado = resultado + pow(segundo,expoente);

  printf("Resultado:\n %i", resultado);

}
int main(){
  int a,b;
  printf("Digite o primeiro numero:\n");
  scanf("%d",&a);
  printf("Digite o segundo numero:\n");
  scanf("%d",&b);
  calcubo(&a,&b);
  return 0;
}
