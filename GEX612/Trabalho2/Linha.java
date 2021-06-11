public class Linha {
    public String posicaoMemoriaPrincipal;
    private Bloco linha;
    private int contadorLRU; //bit que vai indicar se vai ou nao substituir
    
    public Linha(){
        this.posicaoMemoriaPrincipal = "00000";  //porque existem 32 possiveis enderecos de memoria
        this.contadorLRU = 0;
        this.linha = new Bloco();
    }
    
    public Bloco getLinha() {
        return this.linha;
    }
    
    
    public int getContadorLRU() {
        return this.contadorLRU;
    }

    public void setContadorLRU(int valor) {
        this.contadorLRU = valor;
    }
    public void incrementaContadorLRU() {
        this.contadorLRU = contadorLRU +1;
    }
    
    public String getPosicaoMemoriaPrincipal() {
        return this.posicaoMemoriaPrincipal;
    }

    public void setPosicaoMemoriaPrincipal(String valor) {
        this.posicaoMemoriaPrincipal = valor;
    }
    
    public void setLinha(Bloco linha) {
        this.linha = linha;
    }

   public Celula getCelulaAPartirDoEnderecoDeMemoria(String endereco ){
        // Integer.parseInt("1001", 2);
        // xxxxx.xx.xxx -> Pega os 2 digito que vem depois do mais signifcativo
        String digitosDeslocamento = endereco.substring(5,7);
        // converte o binário para base decimal -> 010 vira um int 2
         int digitosDeslocados = Integer.parseInt(digitosDeslocamento, 2);
        // usa esse inteiro para pegar a linha correta da cache
        return this.linha.getCelulasDoBloco(digitosDeslocados);
   }

}
