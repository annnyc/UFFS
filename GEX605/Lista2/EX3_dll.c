
#include <stdio.h>
#include <stdlib.h>

struct node {
   int valor;
   struct node *anterior;
   struct node *proximo;
};

struct node *head = NULL;
struct node *ultimo = NULL;

struct node *atual = NULL;


void printList() {
   struct node *ptr = head;

   printf("\n[head] <=>");
   while(ptr != NULL) {        
      printf(" %d <=>",ptr->valor);
      ptr = ptr->proximo;
   }

   printf(" [ultimo]\n");
}

void insert(int valor) {
 
   struct node *link = (struct node*) malloc(sizeof(struct node));

   link->valor = valor;
   link->anterior = NULL;
   link->proximo = NULL;

   
   if(head==NULL) {
      head = link;
      return;
   }

   atual = head;
   
   while(atual->proximo!=NULL)
      atual = atual->proximo;

   
   atual->proximo = link;
   ultimo = link;
   link->anterior = atual;
}

void search(int valor) {
   int pos = 0;
   
   if(head==NULL) {
      printf("Lista vazia.");
      return;
   } 

   atual = head;
   while(atual!=NULL) {
      pos++;
      if(atual->valor == valor) {
         printf("%d encontrado em %d\n", valor, pos);
         return;
      }

      if(atual->proximo != NULL)
         atual = atual->proximo;
      else
         break;
   }

   printf("%d nao esta na lista\n", valor);
}




int main() {
   int op=1, vl;
   while (op!=0)
    {
		printf("\n1 - Insere\n2 - Procura\n3 - Lista Todos\n4 - Sai\n");
		
		scanf("%d",&op);
		if (op==1)
		{
			printf("Valor: ");
			scanf("%d",&vl);
			insert(vl);
		}
		if (op==2)
		{
			printf("Valor: ");
			scanf("%d",&vl);
      search(vl);
	    }
		if (op==3)
		{
		  printList();
		}
	
		if (op==4)
		{
			exit(0);
		}
    }


}
