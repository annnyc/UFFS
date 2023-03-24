#include <stdio.h>

int somaMulti(int numero, int outroNumero){
    int resultado = 0;
    for(int i = 0; i <outroNumero; i++){
        resultado = resultado + numero;
    }
    printf("resultado  %i\n ", resultado);
}

int main(){
    int numero, outroNumero, op = 1;
    while(op == 1){
        printf("digite um numero:\n");
        scanf("%i", &numero);
        printf("digite um outro numero:\n");
        scanf("%i", &outroNumero);
        op--;
    }
    somaMulti(numero, outroNumero);
}
