//UFFS - UNIVERSIDADE FEDERAL DA FRONTEIRA SUL
//Academica: Any Cruz Silva
//Matricula: 1721101005
//Pesquisa e ordenaçao de dados - 2021 2


#include <stdio.h>
#include <time.h>
#include <stdlib.h>

void crescenteVetor(int vetor[], int tamanho){
    for (int i = 0; i < tamanho; i++){
        vetor[i] = i;
     }
}

void decrescenteVetor(int vetor[], int tamanho){
    int op = 0, j= 0, i= 0;
    for ( i = 0; i < tamanho; i++){
      vetor[i] = i;
     }

    for ( i = 0; i < tamanho; i++) 
        {
            for (j = i + 1; j < tamanho; j++) 
            {
                if (vetor[i] < vetor[j]) 
                {
                    op = vetor[i];
                    vetor[i] = vetor[j];
                    vetor[j] = op;
                }
            }
}
}

void aleatorioVetor(int vetor[], int tamanho){
    for (int i = 0; i < tamanho; i++){
      vetor[i] = (rand() % 100);
  }
}

void selectionSort(int vetor[], int x){
    int i, j, position, swap, contador = 0;
    for(i = 0; i < (x - 1); i++){
        position=i;
        contador++;
        for(j = i + 1; j < x; j++){
        if(vetor[position]>vetor[j])
            position=j;
                    }
        if(position != i)
        {
            swap=vetor[i];
            vetor[i]=vetor[position];
            vetor[position]=swap;
            contador++;
        }       
    }
    printf("Selection Sort:\n");
    printf("Numero de comparacoes efetuadas pelo metodo: %d \n", contador);
}

void insertionSort(int vetor[], int x) 
{ 
    int i, aux, j, contador = 0; 
    for (i = 1; i < x; i++) { 
        aux = vetor[i]; 
        j = i - 1; 
        contador++;
        while (j >= 0 && vetor[j] > aux) { 
            vetor[j + 1] = vetor[j]; 
            j = j - 1; 
            contador++;
        } 
        vetor[j + 1] = aux; 
    } 
    printf("\n\nInsertion Sort:\n");
    printf("Numero de comparacoes efetuadas pelo metodo: %d \n", contador);
} 

void bubbleSort(int vetor[], int n) {
    int i, j, temp, flag=0, contador = 0;
    for(i = 0; i < n; i++)
    {
        for(j = 0; j < n-i-1; j++)
        {
            if( vetor[j] > vetor[j+1])
            {
                temp = vetor[j];
                contador++;
                vetor[j] = vetor[j+1];
                vetor[j+1] = temp;
                flag = 1;
            } 
        }

        if(flag==0)
        {
            break;
        }
    }
    printf("\n\nBubble Sort:\n");
    printf("Numero de comparacoes efetuadas pelo metodo: %d \n", contador);
}


int main() {
   clock_t start_t, end_t, total_t;
  int  x, i, d, swap, n, a;
  srand(time(0));


//   printf("Bem-vinda\nInforme o tamanho do vetor:\n");
//   scanf("%d", &x); 
  printf("Informe qual o tamanho do vetor\n");
  int opTamanho = 0;
  while(1){
      printf("O vetor deve ser:\n1- 10 000\n2- 50 000\n3- 100 000\n\n");
      switch (op)
    {
      case 1: {
          
          exit(0);
          break;
      }

      case 2: {

          exit(0);
          break;
      }

      case 3: {

          exit(0);
          break;
      }

  }

  int vetor [x];
  printf("Escolha um tipo de vetor\n\n");
  
  int op=1,k;
  while (op!=0)
    {
    printf("O vetor deve ser:\n1- Crescente\n2- Decrescente\n3- Aleatorio\n\n");
    scanf("%d",&op);
    switch (op)
    {
      case 1: {
                // vetor crescente

                //SELECTION SORT
                crescenteVetor(vetor,x);
                start_t = clock();
                selectionSort(vetor, x);
                end_t = clock();
                double diferenca1 = ((double) end_t - start_t) / CLOCKS_PER_SEC;
                printf( "O tempo de execucao do Selection Sort foi de %lf segundos quando aplicado em um vetor crescente de %d valores.\n",  diferenca1, x);


                //INSERTION SORT
                crescenteVetor(vetor,x);
                start_t = clock();
                insertionSort(vetor, x);
                end_t = clock();
                double diferenca2 = ((double) end_t - start_t) / CLOCKS_PER_SEC;
                printf( "O tempo de execucao do Insertion Sort foi de %lf segundos quando aplicado em um vetor crescente de %d valores.\n",  diferenca2, x);

                 //BUBBLE SORT
                crescenteVetor(vetor,x);
                start_t = clock();
                insertionSort(vetor, x);
                end_t = clock();
                double diferenca3 = ((double) end_t - start_t) / CLOCKS_PER_SEC;
                printf( "O tempo de execucao do Bubble Sort foi de %lf segundos quando aplicado em um vetor crescente de %d valores.\n",  diferenca3, x);



                exit(0);
                break;
                
              }

      case 2: {
                 // vetor decrescente

                //SELECTION SORT
                decrescenteVetor(vetor,x);
                start_t = clock();
                selectionSort(vetor, x);
                end_t = clock();
                double diferenca4 = ((double) end_t - start_t) / CLOCKS_PER_SEC;
                printf( "O tempo de execucao do Selection Sort foi de %lf segundos quando aplicado em um vetor decrescente de %d valores.\n",  diferenca4, x);


                //INSERTION SORT 
                decrescenteVetor(vetor,x);
                start_t = clock();
                insertionSort(vetor, x);
                end_t = clock();
                double diferenca5 = ((double) end_t - start_t) / CLOCKS_PER_SEC;
                printf( "O tempo de execucao do Insertion Sort foi de %lf segundos quando aplicado em um vetor decrescente de %d valores.\n",  diferenca5, x);

                 //BUBBLE SORT
                decrescenteVetor(vetor,x);
                start_t = clock();
                bubbleSort(vetor, x);
                end_t = clock();
                double diferenca6 = ((double) end_t - start_t) / CLOCKS_PER_SEC;
                printf( "O tempo de execucao do Bubble Sort foi de %lf segundos quando aplicado em um vetor decrescente de %d valores.\n",  diferenca6, x);
                exit(0);
                break;
                
              }

      case 3:{
                    // vetor aleatorio

                //SELECTION SORT
                aleatorioVetor(vetor,x);
                for(int contadorTeste = 0; contadorTeste < x; contadorTeste ++){
                    printf(" \n vetor[%d]", vetor[contadorTeste]);
                }
                start_t = clock();
                selectionSort(vetor, x);
                end_t = clock();
                double diferenca7 = ((double) end_t - start_t) / CLOCKS_PER_SEC;
                printf( "O tempo de execucao do Selection Sort foi de %lf segundos quando aplicado em um vetor aleatorio de %d valores.\n",  diferenca7, x);


                //INSERTION SORT
                aleatorioVetor(vetor,x);
                start_t = clock();
                insertionSort(vetor, x);
                end_t = clock();
                double diferenca8 = ((double) end_t - start_t) / CLOCKS_PER_SEC;
                printf( "O tempo de execucao do Insertion Sort foi de %lf segundos quando aplicado em um vetor aleatorio de %d valores.\n",  diferenca8, x);

                 //BUBBLE SORT
                aleatorioVetor(vetor,x);
                start_t = clock();
                bubbleSort(vetor, x);
                end_t = clock();
                double diferenca9 = ((double) end_t - start_t) / CLOCKS_PER_SEC;
                printf( "O tempo de execucao do Bubble Sort foi de %lf segundos quando aplicado em um vetor aleatorio de %d valores.\n",  diferenca9, x);
                exit(0);
                break;
      }

    }
}}

