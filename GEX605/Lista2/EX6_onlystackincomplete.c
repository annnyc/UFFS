#include <stdio.h>
#include <stdlib.h>

struct TpStack {
  int value;
  struct TpStack *next;
};

typedef struct TpStack Stack;
//
int isStackEmpty(Stack *t)
{
	if (t==NULL) return 1;
	else         return 0;
}

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
	
int peek(Stack *t) 
{
    if (isStackEmpty(t))
    {
		printf("Empty Stack!\n");
		return -1;
	}
	return t->value;   
}

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

void showStack(Stack *t)
{
	while (t!=NULL)
	{
		printf("%d\n",t->value);
		t=t->next;
	}
	return;
}

int main()
{
    Stack *top=NULL;
    int op=1, vl;
    while (op!=0)
    {
		printf("\n1 - Push\n2 - Pop\n3 - Peek\n4 - Clean\n5 - Show stack\n0 - Sai: ");
		scanf("%d",&op);
		switch (op)
		{
			case 1: {
				      printf("Value: "); 
              scanf("%d",&vl);
              if(vl<0){
                 push(&top,vl);
                 break;
              }
			         
			        }
			case 2: vl=pop(&top); break;
			case 3: printf("Top: %d\n",peek(top)); break;
			case 4: top=cleanStack(top); break;
			case 5: showStack(top); break;
		}
	}
		
    return 0;
}
