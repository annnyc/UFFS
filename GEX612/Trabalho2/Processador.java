import java.io.*;

/*CPU*/

public class Processador {

  Cache mc = new Cache();
  Principal mp = new Principal();

 public boolean leitura(String endereco) {

    if (endereco.length() != 8) {
      System.out.println("Endereco invalido!");
      return false;
    }
    // se tiver na memoria cache, incrementar o hit escrita e escrever o dado novo
    if(mc.verificaPosicaoEstaNaCache(endereco) == true){
        mc.incrementaHitLeitura(1);
        mc.getLinhaAPartirDoEndereco(endereco).incrementaContadorLRU();
        return true;    
    }
    // se não tiver a gente precisa buscar na memória principal, entao contabiliza miss
    mc.incrementaMissLeitura(1);
    Bloco blocoDaMemoriaPrincipal = mp.getBlocoAPartirDoEnderecoDeMemoria(endereco);
    Bloco blocoParaInserirNaCache = blocoDaMemoriaPrincipal.clone();
    // pegar a linha com menos uso da memoria cache
    Linha linhaParaSubstituir = mc.getLinhaLRU();

    // gravar na memoria principal o conteudo do bloco da cache (USAR a escrita de retorno)
    mp.escreverBloco(linhaParaSubstituir.getPosicaoMemoriaPrincipal() , linhaParaSubstituir.getLinha());
    // colocar na cache o bloco que vem da memoria principal
    mc.substituirLinhaNaCache(linhaParaSubstituir.getPosicaoMemoriaPrincipal(), endereco, blocoParaInserirNaCache);
    // incrementa o lru
    linhaParaSubstituir.incrementaContadorLRU();
    // System.out.println();
    // Linha linhaParaInserir = mc.getLinhaAPartirDoEndereco(end);
    // Celula celulaDaLinha =  linhaParaInserir.getCelulaAPartirDoEnderecoDeMemoria(end);
    // celulaDaLinha.setCelula(dado); 
    // mc.incrementarEscrita();
    // linhaParaInserir.incrementaContadorLRU();

        return true;
  }

// se tiver na memoria cache, incrementar o hit escrita e escrever o dado novo!

// se não tiver a gente precisa buscar na memória principal

// substituir na cache (USAR a escrita de retorno)
// escreve o dado novo
// incrementa o lru

  public void escrita(String end, String dado) {
    //TODO: arrumar o dado
    String dad1 = dado;
    if (dado.length() != 8) {
      System.out.println("Endereco invalido!");
      return;
    }
    // se tiver na memoria cache, incrementar o hit escrita e escrever o dado novo
    if(mc.verificaPosicaoEstaNaCache(end) == true){
        mc.incrementarEscrita();
        Linha linhaParaInserir = mc.getLinhaAPartirDoEndereco(end);
        Celula celulaDaLinha =  linhaParaInserir.getCelulaAPartirDoEnderecoDeMemoria(end);
        celulaDaLinha.setCelula(dado); 
        linhaParaInserir.incrementaContadorLRU();
        return;
        
    }

    // se não tiver a gente precisa buscar na memória principal, entao contabiliza miss
    mc.incrementaMissEscrita(1);


    Bloco blocoDaMemoriaPrincipal = mp.getBlocoAPartirDoEnderecoDeMemoria(end);
    Bloco blocoParaInserirNaCache = blocoDaMemoriaPrincipal.clone();
    // pegar a linha com menos uso da memoria cache
    Linha linhaParaSubstituir = mc.getLinhaLRU();

    // gravar na memoria principal o conteudo do bloco da cache (USAR a escrita de retorno)
    mp.escreverBloco(linhaParaSubstituir.getPosicaoMemoriaPrincipal() , linhaParaSubstituir.getLinha());
    // colocar na cache o bloco que vem da memoria principal
    mc.substituirLinhaNaCache(linhaParaSubstituir.getPosicaoMemoriaPrincipal(), end, blocoParaInserirNaCache);
    // incrementa o lru
    linhaParaSubstituir.incrementaContadorLRU();
    Celula celulaDaLinha =  linhaParaSubstituir.getCelulaAPartirDoEnderecoDeMemoria(end);
    celulaDaLinha.setCelula(dado); 
    // System.out.println();
    // Linha linhaParaInserir = mc.getLinhaAPartirDoEndereco(end);
    // Celula celulaDaLinha =  linhaParaInserir.getCelulaAPartirDoEnderecoDeMemoria(end);
    // celulaDaLinha.setCelula(dado); 
    // mc.incrementarEscrita();
    // linhaParaInserir.incrementaContadorLRU();

  }
}
