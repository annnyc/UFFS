/*Memoria cache*/

import java.util.ArrayList;
import java.util.List;
public class Cache {
    private int hitLeitura;
    private int missLeitura;
    private int hitEscrita;
    private int missEscrita;
    public int numeroLinhas;
    public ArrayList <Linha>  linhadaCache;
    
    public Cache(){
        this.hitLeitura = 0;
        this.missLeitura = 0;
        this.hitEscrita = 0;
        this.missEscrita = 0;
        this.numeroLinhas = 8;
        linhadaCache = new ArrayList<Linha>();

        // cria linhas
        for(int i = 0 ; i < numeroLinhas; i++){
           Linha linha = new Linha();
           linhadaCache.add(linha);
     }      
    }



    public int getHitEscrita() {
        return hitEscrita;
    }
    
    public void incrementarEscrita() {
        this.hitEscrita += 1;
    }
    public void setHitEscrita(int escrita) {
        this.hitEscrita = escrita;
    }
    
    public int getHitLeitura() {
        return this.hitLeitura;
    }

    public void setHitLeitura(int value) {
        this.hitLeitura = value;
    }
    
    public int getMissLeitura() {
        return this.missLeitura;
    }
    
    public void incrementaHitLeitura(int value){
        this.hitLeitura += value;
    }
    
    public void incrementaMissLeitura(int value){
        this.missLeitura += value;
    }
    
    public void incrementaMissEscrita(int i){
        this.missEscrita += i;
    }

    public Linha getLinha(int i) {
        return this.linhadaCache.get(i);
        
    }
 
    public int getMissEscrita() {
        return missEscrita;
    }

    public void setnumeroLinhas(int i) {
        numeroLinhas = i;
    }

    public int getnumeroLinhas() {
        return this.numeroLinhas;
    }

    public void mostrarMemoriac(){
        
        System.out.println("Exibindo a memoria:\n");
        
        for(int b = 0; b < this.numeroLinhas; b++){
            //tem todas as linhas 
            Linha linha = linhadaCache.get(b);
            Bloco bloco = linha.getLinha();
            System.out.printf("Linha --------%d \n ", b);
            System.out.printf("Rotulo -------%s \n ", linha.getPosicaoMemoriaPrincipal() );


            for(int a = 0; a< bloco.getNumCelulas(); a++){
                
                Celula celula = bloco.getCelulasDoBloco(a);
                System.out.printf("Celula  -----%d\n ", a);
                System.out.printf("Valor da celula  %s ", celula.getCelula());
                System.out.println("\n\n\n");
                
            }
                System.out.println();
                // System.out.println(String.format("%5s", Integer.toBinaryString(b)).replaceAll(" ","0") + "         " + String.format("%2s", Integer.toBinaryString(c)).replaceAll(" ","0") + "     " + String.format("%8s", Integer.toBinaryString().replaceAll(" ","0"));
            
        }

        
    }


    public Linha getLinhaAPartirDoEndereco (String endereco){
        String enderecoParaVerificar = endereco.substring(0,5);
        for(int i = 0; i < this.numeroLinhas ; i++){
            Linha linhaDaPosicao = this.linhadaCache.get(i);
            if(linhaDaPosicao.getPosicaoMemoriaPrincipal().equals(enderecoParaVerificar)   ){
                return this.linhadaCache.get(i);
            }  
        } 
        return null;
    }


    public boolean verificaPosicaoEstaNaCache (String endereco){
        String enderecoParaVerificar = endereco.substring(0,5);
        for(int i = 0; i < this.numeroLinhas ; i++){
            Linha linhaDaPosicao = this.linhadaCache.get(i);
            if(linhaDaPosicao.getPosicaoMemoriaPrincipal().equals(enderecoParaVerificar)   ){
                return true;
            } 
        } 
        return false;

    }



    public Linha getLinhaLRU () {
        int indiceBlocoMenosUsado = 0;

        for(int i = 0; i < this.numeroLinhas ; i++){
            Linha linhaDaPosicao = this.linhadaCache.get(i);
            if(linhaDaPosicao.getContadorLRU() < this.linhadaCache.get(indiceBlocoMenosUsado).getContadorLRU()  ){
                indiceBlocoMenosUsado = i;
        }  
    } 
    return this.linhadaCache.get(indiceBlocoMenosUsado);
   }

   public void substituirLinhaNaCache (String posicaoNaCache,String posicaoMemoriaPrincipal, Bloco novoBloco){
       Linha linhaSubstituida = this.getLinhaAPartirDoEndereco(posicaoNaCache);
       linhaSubstituida.setContadorLRU(0);
       linhaSubstituida.setPosicaoMemoriaPrincipal(posicaoMemoriaPrincipal.substring(0,5));
       linhaSubstituida.setLinha(novoBloco);
   } 


}
