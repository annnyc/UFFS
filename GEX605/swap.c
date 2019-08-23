#include <stdio.h>

void swap(float *a, float *b){
  float aux;
  aux = *a;
  *a = *b;
  *b = aux;
}

int main(){
  float x = 20.3,y = 68.1;
  printf("x: %f y: %f",x,y);
  swap(&x,&y);
  printf("\n\nx: %f y: %f",x,y);
  

}
