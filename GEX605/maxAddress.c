#include <stdio.h>

int main(){
  float x = 10.3, y = 10.5;
  if(&x>&y){
    printf("o endereco da primeira variavel eh maior que eh %x",x);
  } else{
    printf("o endereco da segunda variavel eh maior que eh %x", y );
  }


}
