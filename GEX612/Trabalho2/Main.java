import java.util.Scanner; 
import java.util.ArrayList;
import java.util.List;
//mapeamento associativo, escrita no retorno e lru

public class Main {
    public static void main(String[] args) {
        boolean continua = true;
        int opcao;
        String end;
        Processador processadorObj = new Processador();

        while(continua){
            System.out.print("Bem-vind@ ao Simulador de Memoria Cache Associativa!:\n ");
            System.out.println("Menu:");
            System.out.println("1 - Ler o conteudo de um endereço de memoria:");
            System.out.println("2 - Escrever em um endereco de memoria");
            System.out.println("3 - Exibir memoria principal");
            System.out.println("4 - Exibir a memoria cache");
            System.out.println("5 - Exibir estatisticas");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opcao: ");

            Scanner s = new Scanner(System.in);
            opcao = s.nextInt();
            
            switch (opcao) {
                case 1: {
                    System.out.print("Ler o conteúdo de um endereço de memoria: ");
                    end = s.next();
                    processadorObj.leitura(end);
                    System.out.println();
                    break;
                }
                case 2: {
                    System.out.print("Digite o endereço de memoria que deseja manipular: ");
                    String ender = s.next();
                    System.out.print("Digite o dado para ser armazenado no endereço: ");
                    String dado = s.next();
                    System.out.print("O endereco e o conteudo foram escritos! ");
                    processadorObj.escrita(ender, dado);
                    break;
                }
                case 3: {
                    System.out.println("Mostrando memoria principal: ");
                    processadorObj.mp.mostrarMemoria();
                    System.out.println();
                    break;
                }
                case 4: {
                    System.out.println("Mostrando memoria cache: ");
                    processadorObj.mc.mostrarMemoriac();
                    System.out.println();
                    break;
                }
                
                case 5: {
                    System.out.println("Mostrando estatisticas: ");
                    System.out.println();
                    System.out.println("Total de acessos: " +( processadorObj.mc.getHitLeitura() + processadorObj.mc.getMissLeitura() + processadorObj.mc.getHitEscrita() + processadorObj.mc.getMissEscrita()));
                    System.out.println("Leituras: " + ( processadorObj.mc.getHitLeitura() +  processadorObj.mc.getMissLeitura()));
                    System.out.println("Escritas: " + ( processadorObj.mc.getHitEscrita() +  processadorObj.mc.getMissEscrita()));
                    System.out.print("Leituras-acertos: " +  processadorObj.mc.getHitLeitura() + " - ");
                    if( processadorObj.mc.getHitLeitura() +  processadorObj.mc.getMissLeitura() > 0){
                        float porcent = (float) processadorObj.mc.getHitLeitura() / ((float) processadorObj.mc.getHitLeitura() + (float) processadorObj.mc.getMissLeitura())*100;
                        System.out.println(porcent + "%");
                    }else{
                       System.out.println("0%"); 
                    }
                    System.out.print("Leituras-erros: " +  processadorObj.mc.getMissLeitura() + " - ");
                    if( processadorObj.mc.getHitLeitura() +  processadorObj.mc.getMissLeitura() > 0){
                        float porcent1 = (float) processadorObj.mc.getMissLeitura() / ((float) processadorObj.mc.getHitLeitura() + (float) processadorObj.mc.getMissLeitura())* 100;
                        System.out.println(porcent1 + "%");
                    }else{
                       System.out.println("0%"); 
                    }
                    System.out.print("Escrita-acertos: " +  processadorObj.mc.getHitEscrita() + " - ");
                    if( processadorObj.mc.getHitEscrita() +  processadorObj.mc.getMissEscrita() > 0){
                        float porcent2 = (float) processadorObj.mc.getHitEscrita() / ((float) processadorObj.mc.getHitEscrita() + (float) processadorObj.mc.getMissEscrita()) * 100;
                        System.out.println(porcent2 + "%");
                    }else{
                        System.out.println("0%"); 
                    }
                    System.out.print("Escrita-erros: " +  processadorObj.mc.getMissEscrita() + " - ");
                    if( processadorObj.mc.getHitEscrita() +  processadorObj.mc.getMissEscrita() > 0){
                        float porcent3 = (float) processadorObj.mc.getMissEscrita() / ((float) processadorObj.mc.getHitEscrita() + (float) processadorObj.mc.getMissEscrita()) * 100;
                        System.out.println(porcent3 + "%");
                    }else{
                        System.out.println("0%"); 
                    }
                    System.out.println();
                    break;
                }
        
                case 6: {
                    System.out.println("Fim");
                    continua = false;
                    break;
                }
                default: {
                    System.out.println("Por favor, tente novamente.");
                }
            }
                
        }


    }
}
