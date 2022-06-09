#include <stdio.h>
#include <time.h>
#include <stdlib.h>

// Arr[(i-1)/2]	Returns the parent node
// Arr[(2*i)+1]	Returns the left child node
// Arr[(2*i)+2]	Returns the right child node



void heap(int vetor[], int tamanho){

    int root, leftChild, rightChild, parent;
    root = vetor[0];
    parent = vetor[(root-1)/2];
    leftChild = vetor[(2*root)+1];
    rightChild = vetor[(2*root)+2];
    
    if(leftChild < tamanho){
        int maiorValor = leftChild;
    }

    if(rightChild < tamanho){
        
    }
    


}

void imprimeVetor(int vetor[], int tamanho){
     for(int contadorTeste = 0; contadorTeste < tamanho; contadorTeste ++){
        printf(" \n vetor[%d]", vetor[contadorTeste]);
        }
}


int main(){
    int tamanhoVetor = 10;
    int vetor[tamanhoVetor];
    srand(time(0));
    for(int i = 0; i < tamanhoVetor ; i++){
        vetor[i] = (rand() % 100);
    }
    imprimeVetor(vetor, tamanhoVetor);
    printf(" \n .");

    heap(vetor, tamanhoVetor);
    imprimeVetor(vetor, tamanhoVetor);
}