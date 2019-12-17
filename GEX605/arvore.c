#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define SIZE 10 // 10.000.000

struct STree {
  int value;
  struct STree *left, *right;
};

typedef struct STree TTree;

// get free memory for storing the value and pointers
// return the address of the spot
TTree *getMem();
// Insert following Binary Search Tree rules
TTree *insertBST(TTree *, int );
// Delete value from the Binary Search Tree (its properties must be kept)
TTree *deleteBST(TTree *, int );
// Search for a value in the tree from address pointed by r
TTree *searchBST(TTree *, int );
//  Impressões ordenada
void PrintInOrder(TTree *);
//
void PrintPreOrder(TTree *);
//
void PrintPosOrder(TTree *);
//
// free up the allocated spaces
void cleanTree(TTree *);
//
int treeHeight(TTree *);
//
int numberOfNodes(TTree *);
//
void printBFS(TTree *, int );
//
void BFS(TTree *);
//
int main()
{
    TTree *myTree=NULL, *root=NULL;
    long int i;
    int n,x,exc;
    clock_t begin, end;
    double time_spent;
    srand(time(NULL));   // New seed for random numbers
    printf("Inserindo %d números recursivamente...\n",SIZE);
    begin=clock();
    x=treeHeight(root);
    for (i=1;i<=SIZE;i++)
    {

		n=rand()%10;
    printf("%d ",n);
		myTree=insertBST(root,n);
		if (root==NULL) root=myTree;
    }
    end=clock();
    time_spent=(double)(end-begin)/CLOCKS_PER_SEC;
    printf("\nTempo (em s)%5.2f: \n",time_spent);
    printf("\n# of nodes: %d\n",numberOfNodes(root));
    printf("\nAltura (raiz): %d\n",x);
    printf("\nAltura (1o. filho esq.): %d\n",treeHeight(root->left));
    printf("\nAltura (1o. filho dir.): %d\n",treeHeight(root->right));
    printf("\nAltura (1o. filho esq. do 1o. filho dir.): %d\n",treeHeight(root->right->left));
    printf("\nAltura (1o. filho dir. do 1o. filho dir.): %d\n",treeHeight(root->right->right));
    PrintInOrder(root);
    printf("\Exclusão?");

    cleanTree(root);
    BFS(root);
    return 0;
}

TTree *getMem()
{
	TTree *new=(TTree *)malloc(sizeof(TTree));
	if (new==NULL)
	{
		printf("FATAL ERROR! NO MEMORY AVAILABLE!\n");
		return NULL;
	}
	new->right=NULL;
	new->left=NULL;
	return new;
}
// Insert following Binary Search Tree rules
TTree *insertBST(TTree *r, int vl)
{
    if (r==NULL)
    {
		TTree *new=getMem();
		new->value=vl;
		return new;
	}
	if (vl>=r->value)
	{
    if (vl==r->value)
    {
      return r;
    }
		if (r->right==NULL)
		{
  		    TTree *new=getMem();
		    new->value=vl;
			r->right=new;
			return new;
		}
		return insertBST(r->right,vl);
	} else
	{
		if (r->left==NULL)
		{
  		    TTree *new=getMem();
		    new->value=vl;
			r->left=new;
			return new;
		}
		return insertBST(r->left,vl);
	}
}
// Search for a value in the tree from address pointed by r
TTree *searchSBT(TTree *r, int vl)
{
	if (r==NULL) return NULL;
	if (r->value==vl) return r;
	if (vl>=r->value) return searchSBT(r->right,vl);
	else              return searchSBT(r->left,vl);
}
//  Impressões ordenada
void PrintInOrder(TTree *r)
{
	if (r==NULL) return;
	PrintInOrder(r->left);
	printf("%d ",r->value);
	PrintInOrder(r->right);
}
//
void PrintPreOrder(TTree *r)
{
	if (r==NULL) return;
	printf("%d ",r->value);
	PrintPreOrder(r->left);
	PrintPreOrder(r->right);
}
//m do núcleo gravada)

void PrintPosOrder(TTree *r)
{
	if (r==NULL) return;
	PrintPosOrder(r->left);
	PrintPosOrder(r->right);
	printf("%d ",r->value);
}
//
// free up the allocated spaces
void cleanTree(TTree *r)
{
	if (r==NULL) return;
	cleanTree(r->left);
	cleanTree(r->right);
  free(r);
}
//
int treeHeight(TTree *n)
{
  int l,r;
  if (n==NULL) return 0;
  l=treeHeight(n->left);
  r=treeHeight(n->right);
  if (l>r) return l+1;
  else     return r+1;
}
//
int numberOfNodes(TTree *n)
{
  if (n==NULL) return 0;
  return numberOfNodes(n->left)+numberOfNodes(n->right)+1;
}
void printBFS(TTree *r, int i)
{
  if (r==NULL) return;
  if (i==1)
  {
    printf(" %d ",r->value);
  }
  else
  {
    printBFS(r->left,i-1);
    printBFS(r->right,i-1);
  }
}
void BFS(TTree *r)
{
  int h=treeHeight(r),i;
  for (i=1;i<=h;i++)
  {
    printBFS(r,i);
    printf("\n");
  }
}
