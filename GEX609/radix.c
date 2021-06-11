#include <stdio.h>
#include <stdlib.h>

void radixsort(int *vet, int n) {
	int i, exp = 1, m = 0, bucket[n], temp[n];

	for(i = 0; i < n; i++) {
		if(vet[i] > m) {
			m = vet[i];
		}
	}

	while((m/exp) > 0) {
		for (i = 0; i < n; i++) {
			bucket[i] = 0;
		}
		for(i = 0; i < n; i++) {
			bucket[(vet[i] / exp) % 10]++;
		}
		for(i = 1; i < n; i++) {
			bucket[i] += bucket[i-1];
		}
		for(i = (n - 1); i >= 0; i--) {
			temp[--bucket[(vet[i] / exp) % 10]] = vet[i];
		}
		for(i = 0; i < n; i++) {
			vet[i] = temp[i];
		}
		exp *= 10;
	}
}

int main() {
    clock_t inicio, fim;
    inicio = clock();
    int i, x, op=1;
	
	
    while (op!=0)
    {
		printf("\n1 - Ordenacao de vetor crescente\n2 - Ordenacao de vetor decrescente\n");
		scanf("%d",&op);
		if (op==1)
		{
			printf("Digite o tamanho do vetor:\n");
			scanf("%d",&x);
			int vetor[x];
            printf("Adicionando os %d numeros.....\n\n", x);
            printf("Aguarde...\n\n\nCarregando valores...\n\n\n");
            for (i = 0; i < x; i++){
                vetor[i] = rand();}
            

			continue;
		}
		if (op==2)
		{
			printf("Valor: ");
			scanf("%d",&vl);
			if (findValue(head,vl)!=NULL)
			   printf("Valor presente na lista!\n");
			else
			   printf("Valor não encontrado na lista!\n");
			continue;
	    }
		if (op==3)
		{
		  showAll(head);
		  continue;
		}
		if (op==4)
		{
			deleteList(head);
			head=NULL; // não esquecer de setar a lista para vazia
			continue;
		}
		if (op==5)
		{
			printf("Valor antigo: "); scanf("%d",&vold);
			printf("Valor   novo: "); scanf("%d",&vnew);
			updateList(head,vold,vnew);
			continue;
		}
		if (op==6)
		{
			printf("Valor a ser excluído: "); scanf("%d",&vl);
			head=deleteValue(head,vl);
			continue;
		}
    }

	radixsort(vetor,max);
	for (i = 0; i < max; i++) {
		printf("%d ", vetor[i]);
	}
	return(0);
}