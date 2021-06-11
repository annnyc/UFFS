#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// odenando em ordem decrescente
void radixSort (int vetor[], int tamanho){
int i, aux=0, exp=1, vetor2[tamanho];

    for (i=0; i<tamanho; i++){
        if (vetor[i] > aux)
            aux=vetor[i];}

    while (aux/exp>0)
    {
        int bucket[10]={0};
        for (i=0; i<tamanho; i++)
            bucket[9-vetor[i]/exp%10]++;        
        for (i=1; i<10; i++)
            bucket[i]+=bucket[i-1];
        for (i= tamanho-1; i>=0; i--)
            vetor2[--bucket[9-vetor[i]/exp%10]]=vetor[i]; 
        for (i=0; i<tamanho ;i++){
            vetor[i]=vetor2[i];                       
        }
        exp*=10;
    }
}


int main(){
    clock_t inicio, fim;
    inicio = clock();
    int tamanhoVetor, i;
    printf("Bem-vind@!\n Este eh um Radix Sort decrescente\n\n");
    printf("Digite o tamanho do vetor:");
    scanf("%d", &tamanhoVetor);
    int vetorRadix[tamanhoVetor];
    printf("Adicionando os %d numeros.....\n\n", tamanhoVetor);
    printf("Aguarde...\n\n\nCarregando valores...\n\n\n");
    for (i = 0; i < tamanhoVetor; i++){
        vetorRadix[i] = rand();
  }
    printf("Agora aplicando o Radix Sort...\n\n");
    radixSort(vetorRadix, tamanhoVetor);
    printf("O vetor ficou assim:\n\n\n");
    for (i = 0; i < tamanhoVetor; i++){
        printf("%d\n", vetorRadix[i]);}
    fim = clock();
    printf( "O tempo de execucao do Radix Sort  para ordenar %d valores em ordem decrescente foi de %lu segundos.\n", tamanhoVetor, (fim - inicio) / CLOCKS_PER_SEC );
}