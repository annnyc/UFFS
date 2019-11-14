#include <stdio.h>
#include <stdlib.h>
#define FULL 10
//declarando a estrutura da pilha
struct Stack {
  int value;
  struct Stack *next;
};

typedef struct Stack Stack;

struct node
{
    int cntd;
    struct node *next;
};
typedef struct node node;

//declarando a estrutura da fila
struct Queue{
	int x;
	node *first;
	node *last;
};

typedef struct Queue queue;

//a pilha está vazia?
int isStackEmpty(Stack *t)
{
	if (t==NULL) return 1;
	else         return 0;
}

//a fila está vazia?
int empty(queue *ptr)
{
    if (ptr==NULL) return 1;
    else         return 0;
    // return (ptr->last == NULL);
}

//dando início a fila
void start(queue *ptr)
{
    ptr->x = 0;
    ptr->first = NULL;
    ptr->last = NULL;
}

//função pop da pilha (remove item)
int pop(Stack **t) 
{                  
    Stack *aux;
    int value=-1;
    if (isStackEmpty(*t))
    {
		printf("Empty Stack!\n");
		return value;
	}
	aux=*t;
	value=aux->value;
	*t=aux->next; 
	free(aux);
	return value;
}

//função pop da fila, no caso é a desenfileirar
int desenfileirar(queue *ptr)
{
    int n;
    node *tmp;
    // int n = ptr->first->cntd;
    n=ptr->first->cntd;
    tmp = ptr->first;
    ptr->first = ptr->first->next;
    ptr->x--;
    free(tmp);
    return(n);
}

//inserção da pilha
void push(Stack **t,int value) 
{
	Stack *ntop;
	ntop=(Stack *)malloc(sizeof(Stack));
	ntop->value=value;
	if (isStackEmpty(*t))
		ntop->next=NULL;
	else
	    ntop->next=*t;
	*t=ntop;
	return;
}

//inserção da fila
void enfileirar(queue *ptr, int y)
{
    if (ptr->x < FULL)
    {
        node *tmp;
        tmp = malloc(sizeof(node));
        tmp->cntd = y;
        tmp->next = NULL;
        if(!empty(ptr))
        {
            ptr->last->next = tmp;
            ptr->last = tmp;
        }
        else
        {
            ptr->first = ptr->last = tmp;
        }
        ptr->x++;
    }
    else
    {
        printf("Fila cheia!\n");
    }
}


//verificação da pilha	
int peek(Stack *t) 
{
    if (isStackEmpty(t))
    {
		printf("Empty Stack!\n");
		return -1;
	}
	return t->value;   
}


//limpando a pilha
Stack *cleanStack(Stack *t) 
{                          
	Stack *aux=t;           
	while (aux!=NULL)
	{
		t=aux->next;
		free(aux);
		aux=t;
	}
	return NULL;
}

//imprime a pilha
void showStack(Stack *t)
{
	while (t!=NULL)
	{
		printf("%d\n",t->value);
		t=t->next;
	}
	return;
}

//imprime a fila
void show(node *head)
{
    if(head == NULL)
    {
        printf("Fim da fila.\n");
    }
    else
    {
        printf("%d\n", head -> cntd);
        show(head->next);
    }
}

// void swapstruct(){

// }

int main()
{
	queue *ptr;
    ptr = malloc(sizeof(queue));
    start(ptr);
    Stack *top=NULL;
    int op=1, vl, op2=1;
    while (op!=0)
    {
		printf("\n FUNÇÕES BÁSICAS:\n\n\n\n1 - Insere\n2 - Remove\n3 - Verifica\n4 - Limpa lista\n5 - Lista todos\n6 - Funções entre estruras\n0 - Sai: ");
		scanf("%d",&op);
		if(op==1){
			printf("Valor a ser inserido: \n"); 
			
            scanf("%d",&vl);
              if(vl>0){
           		 printf("Inserindo na pilha...");
                 push(&top,vl);
                 printf("Inserido na pilha! :)");
              }else{
              	printf("insere na fila");
              	enfileirar(ptr,vl);
              	printf("Inserido na fila! :)");
              }
              continue;
		}

		if(op==2){
			printf("Valor a ser retirado:\n");
			printf("removendo da pilha...");
			vl=pop(&top); 
			printf("Removido da pilha! :)");
			continue;

		}

		if(op==3){
			printf("Peek:");
			// printf("pilha...");
			printf("Top: %d\n",peek(top)); 

			continue;

		}

		if(op==4){
			printf("Limpando...\n");
			top=cleanStack(top); 
			continue;

		}

		if(op==5){
			printf("Imprimindo...");
			showStack(top); 
			continue;
		}

		if(op==6){
			while (op2!=0){
				printf("\n FUNÇÕES ENTRE ESTRUTURAS:\n11 - Migrar valores da pilha para fila\n22 - Migrar valores da pilha para fila\n33 - Sai: ");
		        scanf("%d",&op2);
		        if(op==11){
		        	
		        }

		        if(op==22){

		        }
		        if(op==33){
		        	printf("saindo...");
		        	exit(0);
		        }
			}

		}

		if(op==0){
			printf("saindo...");
			exit(0);
		}
		
		
	}
		
    return 0;
}
