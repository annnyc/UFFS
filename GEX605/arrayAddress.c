#include <stdio.h>

int main(){
  int vetor[10] = {1,2,3,4,5,6,7,8,9,0},i;
  for(i=0;i<10;i++){
    printf("\nendereço do elemento [%i]: %x\n",i,&vetor[i]);
  }


}
