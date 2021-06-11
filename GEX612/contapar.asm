.globl main
	
	.data
vetor:		 .word 20, 2, 11, 8, 9, 35, 27, 5    

	.text
main:
    addi t0, zero, 0; #contador de numeros pares (post a0)
    addi t1, zero, 0 #contador do for
    addi a1, zero, 8 #contador de posicoes do vetor
    addi t4, zero, 4 #contador 4 (contador do for do asm)
    addi t6, zero, 1 #contador 1 
    # t3 sera uma variavel auxiliar
    la a0, vetor

    #slt t3, t1, t2 # verificando se i < 8
    blt t2, t1, fimdofor 
    lw   a0, 0(t4)
    add t3, 0(t4), zero
    andi t5, t3, 1
    beq t5, t6, contando

contando:
    addi t0, zero, 1
    

   
    