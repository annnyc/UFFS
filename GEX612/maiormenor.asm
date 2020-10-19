.data
vetor: 	.word 	10, 20, 23, 11, 6

	.text


	la $a0, vetor      #$a0 armazena o endereço do vetor
	addi $a1, $zero, 5 #$a1 armazena o numero de indices do vetor
	addi $a3, $zero,0 #$a3 armazena o contador (m) que conta o maior indice
	addi $t0, $zero, 0 #$a4 armazena o contador (n) que conta o menor indice

	addi $a2, $zero, 0 #$a2 contador de posiçoes do vetor (k)
	
teste:	blt $a2, $a1, corpodolaco #for começa aqui
	j fim
corpodolaco:
	bne $a2, $zero, else #comparando k<5
	
	
	sll $t3, $a2, 2 #desloca(multiplica)
	add $t4, $a0, $t3
	lw $t5, 0($t4) #n testado
	
	lw $t5, 0($a0+(x*4)) #n testad
	
	
	#lw $a3, 0($a2) #atribui a m o valor do indice na posiçao k
	#lw $t0, 0($a2) #atribui a n o valor no indice na posiçao k
	
	blt $a2, $a3, exec #compara o o indice do vetor na posiçao k com m
	j else
exec:   lw $a3, 0($a2) #atribui a variavel m a posiçao k do vetor
	

else:
	blt $a2, $t0, exec2
	j run
	
exec2: lw $t0, 0($a2)

run:
	addi $a2, $a2, 1 #variavel de controle do laço
	j teste


fim: 
