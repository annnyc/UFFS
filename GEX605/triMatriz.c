#include <stdio.h>

int main(){
  int vetor[3][3],i,j;

  for(i=0;i<3;i++){
    for(j=0;j<3;j++){
    printf("digite os numeros na matriz\nem [%d][%d]",i,j);
    scanf("%i",&vetor[i][j]);
  }}

  for(i=0;i<3;i++){
    for(j=0;j<3;j++){
    printf("\nendereço do elemento [%d][%d]: %x %x\n",i,j,&vetor[i][j]);
  }}


}
