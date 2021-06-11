.globl main
# Matricula: 1721101005 
# Academica: Any Cruz Silva
#codigo em c usado como "modelo"
##include <stdio.h>
#int main (){
#int vetor[8] = {20,2,11,8,9,35,27,5};
#int contador, i;
#for(i = 0; i < 8; i++)
#{
#    if(vetor[i]%2 == 0)
#       contador++;
#        printf("Os numeros pares sao: %d\n",vetor[i]);
#}
#printf("\ntotal de pares do vetor: %d",contador );
#}
	.data
vetor:		 .word 20, 2, 11, 8, 9, 35, 27, 5    

	.text
main:
    addi t0, zero, 0 #contador de numeros pares (posteriormente sera o a0)
    addi t1, zero, 0 #contador do for  (i)
    addi t2, zero, 8 #contador de posicoes do vetor, no caso são 8 
    addi t4, zero, 4 #contador 4 (contador auxiliar)
    la t3, vetor #carregando o vetor 
    j for

for:
    blt t2, t1, fimdofor # fazendo o i < 8 do for
    lw   t3, 0(t4) #carregando o vetor na posicao o em t3
    andi t5, a3, 1 #operação de and do vetor em [0] com 1, o resultado é guardado em t5
    beq t5, t6, contando #se o valor em t5 for igual a t6 (t5==0), vai incrementar o contador de numeros pares
    
contando:
    addi t0, zero, 1 #incrementando o contador de numeros pares
    add t3, t3, t4 #acessando a proxima prosição do vetor
    j for #voltando para o for novamente
    
fimdofor:
    add a0, a0, t0
    ret 
    
    