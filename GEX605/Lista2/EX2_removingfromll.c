
#include <stdio.h>
#include<stdlib.h>



struct Node{
  int valor;
  struct Node*proximo;
};

typedef struct Node Node;

void insere(struct Node**raiz,int conteudo){
  struct Node*temp=NULL,*new_node=(struct Node*)malloc(sizeof(struct Node));
  if(new_node)
  {   

    new_node->valor=conteudo;
    new_node->proximo=NULL;

    if(*raiz==NULL){
      
      *raiz=new_node;
    }
    else{

      temp=*raiz;
 
      while(temp->proximo){
       
        temp=temp->proximo;  
      }
      
    
      temp->proximo=new_node;
      
    }         
  }
  else
  {
   
    printf("\nMemória cheia! :(\n");
  }
}



void mostra(struct Node*temp){
  if(temp==NULL){
    printf("Lista vazia.\n");
  }
  else
  {
    printf("\n");
    while(temp)
    {
      printf("%d  ",temp->valor);

      temp=temp->proximo;
    }
    
  }
}
/*Help of this function removing all linked list element.*/
void delete_lista(struct Node**raiz){

  if(*raiz){

    struct Node*temp=*raiz;
    
    while(temp){
      *raiz=temp->proximo;
      temp->proximo=NULL;
      free(temp);
      
      temp=*raiz;
    }
    printf("\n\nLista limpa.\n");
  }
  else{
    printf("\nA lista já está vazia. \n");
  }
  
}


void delete_pares(struct Node **raiz ){
  if(*raiz==NULL) {
    printf("\n Lista vazia.\n");
  }
  else
  {
   struct Node*temp=*raiz,*aux=*raiz;
      while(temp){
        if(temp->valor%2==0){
          if(temp == *raiz){
            aux=temp;
            *raiz=(*raiz)->proximo;
            temp=*raiz;
            aux->proximo=NULL;
            free(aux);
            aux=NULL;
        }
        else{
      
          aux->proximo=temp->proximo;
          temp->proximo=NULL;
          free(temp);
          temp=aux->proximo;
        } 
      }else{
      aux=temp;
      temp=temp->proximo;  
    }
  
    }  
  }
}


int main(){
  struct Node*raiz=NULL;
  printf("\nComeçando...\n  ");

  mostra(raiz);
  
  printf("\n Inserindo valores na lista... \n ");
 
  insere(&raiz,1);
  insere(&raiz,2);
  insere(&raiz,3);
  insere(&raiz,4);
  insere(&raiz,5);
  insere(&raiz,6);
  insere(&raiz,4);
  insere(&raiz,1);
  insere(&raiz,1);

  printf("\nA lista era assim:\n");
  mostra(raiz);
  delete_pares(&raiz);
  printf("\nE ficou assim:\n");  
  mostra(raiz);


  delete_lista(&raiz);
  
return 0;
}

