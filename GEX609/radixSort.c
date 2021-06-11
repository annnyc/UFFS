// Pesquisa e ordenacao de dados 2020 2
// Academica: Any Cruz Silva 
// Matricula: 1721101005



#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct produto {
   int codigo;
   char descricao[20];
};

void radixsort(struct produto vetor[], int x);


int main(){
    int i;
    struct produto itens[10];
    itens[0].codigo = 502;
    memcpy(itens[2].descricao,    "Manga", 6);
    itens[1].codigo = 922;
    memcpy(itens[1].descricao,    "Jaca", 6);
    itens[2].codigo = 123;
    memcpy(itens[0].descricao,    "Ata", 6);
    itens[3].codigo = 900;
    memcpy(itens[3].descricao,    "Cafe", 6);
    itens[4].codigo = 221;
    memcpy(itens[4].descricao,    "Caqui", 6);
    itens[5].codigo = 139;
    memcpy(itens[5].descricao,    "Jambo", 6);
    itens[6].codigo = 101;
    memcpy(itens[6].descricao,    "Caju", 6);
    itens[7].codigo = 435;
    memcpy(itens[7].descricao,    "Uva", 6);
    itens[8].codigo = 898;
    memcpy(itens[8].descricao,    "Roma", 6);
    itens[9].codigo = 157;
    memcpy(itens[9].descricao,    "Limao", 6);

    printf("Lista antes de aplicar o radix sort:\n\n");
    printf("Codigo |  Produto\n");
    for (i = 0; i < 10; i++)
    {
        printf("%d\t%s\t\n", itens[i].codigo, itens[i].descricao);
    } 

    printf("Aplicando o Radix Sort...\n\n");
    radixsort(itens, 10);
    printf("Ordenacao finalizada. Aqui esta a lista ordenada:\n\n");
    printf("Codigo |  Produto\n");

    for (i = 0; i < 10; i++)
    {
        printf("%d\t%s\t\n", itens[i].codigo, itens[i].descricao);
    } 
    
   
    return 0;
}

void radixsort (struct produto vetor[], int tamanho)
{
    int i, aux=0, exp=1;
    struct produto vetor2[tamanho];


    for (i=0; i< tamanho ; i++)
    {
        if (vetor[i].codigo > aux)
            aux=vetor[i].codigo;
    }
    while (aux/exp>0)
    {
        int bucket[10]={0};
        for (i=0; i < tamanho ; i++)
            bucket[vetor[i].codigo/exp%10]++;
        for (i=1; i<10; i++)
            bucket[i]+=bucket[i-1];
        for (i = tamanho - 1 ; i >=0 ; i--)
            vetor2[--bucket[vetor[i].codigo/exp%10]].codigo=vetor[i].codigo;
        for (i=0; i< tamanho ; i++){
            vetor[i].codigo=vetor2[i].codigo;
        }
        exp*=10;
    }
}



