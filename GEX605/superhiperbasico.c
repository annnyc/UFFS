#include <stdio.h>
#include <math.h>
void maxMin(int vetor[10], int *primeiro, int *segundo){
  int i;
  for(i=0;i<=10;i++){
    *primeiro = vetor[0];
    *segundo = vetor[9];
  }
  printf("Maximo valor: %d\n Minimo valor: %d", *primeiro, *segundo);

}
int main(){
  int a = 0 ,b = 0, vetor[10] = {0,1,2,3,4,5,6,7,8,9};
  maxMin(vetor,&a,&b);

}
