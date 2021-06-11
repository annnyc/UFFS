import java.util.Random;

/*Memoria Principal*/
public class Principal {
    private Bloco[] memPrincipal;
    private Bloco[] bloco;
    private int numCelulas;
    private int numCelulasBloco;
    private int numBlocos;
    
    public Principal(){
        this.numCelulas = 128;
        this.numCelulasBloco = 4;
        this.numBlocos = (this.numCelulas/ this.numCelulasBloco); 
        
        bloco = new Bloco[numBlocos];
        
        memPrincipal = new Bloco[this.numBlocos];
        
        Random gerador = new Random();
        
        for(int i = 0; i < this.numBlocos; i++){
            bloco[i] = new Bloco();
            // TODO: adicionar para 8 valores
            for(int a = 0; a < numCelulasBloco; a++){
                int n = (gerador.nextInt(255) + 1)*10000 ;
                String binario =  Integer.toString( n, 2); 
                bloco[i].escreverCelula(a, binario.substring(0,8));
            
            }
            
            memPrincipal[i] = bloco[i];
        }
    }
    
    public Bloco lerBloco(int i){
        if(i >= 0 && i < this.numBlocos){
            return memPrincipal[i];
        }else{
            return null;
        }
    }
    
    public void escreverBloco(String posicao, Bloco novoBloco){
        Bloco blocoParaSubstituir  =  this.getBlocoAPartirDoEnderecoDeMemoria(posicao);
        blocoParaSubstituir = novoBloco.clone();
    }
    
    public void mostrarMemoria(){
        
        System.out.println("Bloco  -   Celula  -  Conteudo   ");
        
        for(int b = 0; b < this.numBlocos; b++){
            for(int c = 0; c < this.numCelulasBloco; c++){
                System.out.println(String.format("%5s", Integer.toBinaryString(b)).replaceAll(" ","0") + "         " + String.format("%2s", Integer.toBinaryString(c)).replaceAll(" ","0") + "     " + String.format("%8s", (memPrincipal[b].lerCelula(c).getCelula())).replaceAll(" ","0"));
            }
        }
    }

    public Bloco getBlocoAPartirDoEnderecoDeMemoria (String endereco){
        String enderecoParaVerificar = endereco.substring(0,5);
        int posicaoDaMemoriaPrincipal = Integer.parseInt(enderecoParaVerificar, 2);
        return this.memPrincipal[posicaoDaMemoriaPrincipal];
            
        

    }
}
