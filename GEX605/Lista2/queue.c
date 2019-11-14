//MATRICULA: 1721101005
#include <stdio.h>
#include <stdlib.h>
#define FULL 10

struct node
{
    int cntd;
    struct node *next;
};
typedef struct node node;

struct fila
{
    int len;
    node *first;
    node *last;
};
typedef struct fila queue;

void start(queue *ptr)
{
    ptr->len = 0;
    ptr->first = NULL;
    ptr->last = NULL;
}

int empty(queue *ptr)
{
    if (ptr->len == 0) return 1;
    else return 0;
    // return (ptr->last == NULL);
}

void push(queue *queue, int y)
{
    if (queue->len < FULL)
    {
        node *tmp;
        tmp = (node*)malloc(sizeof(node));
        tmp->cntd = y;
        tmp->next = NULL;

        if(!empty(queue)) //Fila com alguma coisa
        {
            queue->last->next = tmp;
            queue->last = tmp;
        }
        else // Sem nada na fila
        {
            queue->first = queue->last = tmp;
        }
        queue->len++;
    }
    else
    {
        printf("Fila cheia!\n");
    }
}

int pop(queue *ptr)
{
    int n;
    node *tmp;
    // int n = ptr->first->cntd;
    n=ptr->first->cntd;
    tmp = ptr->first;
    ptr->first = ptr->first->next;
    ptr->len--;
    free(tmp);
    return(n);
}

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

int main()
{
    queue *ptr;
    ptr = (queue*) malloc(sizeof(queue));
    
    start(ptr);

    int op=1,k;
    while (op!=0)
    {
		printf("\n1 - Inserir item na fila\n2 - Remover item da fila\n3 - Mostrar fila\n0 - Sai: \n");
		scanf("%d",&op);
		switch (op)
		{
			case 1: {
				        printf("Informe o item que sera inserido: "); scanf("%d",&k);
			          push(ptr,k);
                break;
			        }
			case 2: {
                printf("Remover\n");
                pop(ptr);

              }

			case 3:{
                printf("Fila:\n");
                show(ptr->first);
                break;
      }

		}
	}
    return 0;
}
