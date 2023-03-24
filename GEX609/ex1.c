#include <stdio.h>

void imprimeMetade(int numero){
    int metade = numero /2;
    for (int i = 0; i <= numero; i++){
        printf("%i , ", i);
        if (i == metade ){
            printf("metade , ");
        }
    }
}


int main(){
    int numero, op = 1;
    while(op == 1){
        printf("digite um numero:\n");
        scanf("%i", &numero);
        op--;
    }
    imprimeMetade(numero);

}
