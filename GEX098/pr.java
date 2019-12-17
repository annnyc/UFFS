// Nome: Any Cruz S - 1721101005
// 1) Utilizando o que foi feito até agora com as classes Conta e Programa, crie um
// menu, utilizando a estrutura do..while com as seguintes opções:
// 1. Consultar saldo
// 2. Efetuar saque
// 3. Efetuar depósito
// 4. Sair
//  Dentro de cada uma das opções, implemente a chamada do método respectivo.
//  Saia da estrutura de repetição (do..while) quando o usuário digitar 4.
//  Dica: Dentro dos métodos, você pode utilizar entrada e saída de dados


import java.util.Scanner;
class conta {
  int conta;
  String nome;
  float saldo;
  float limite;
  int aux;
  void saca(float valor){
    this.saldo -= valor;
  }

  void deposita(float valor){
    this.saldo += valor;
  }
  void qntd(float valor){
    System.out.println("Saldo da conta:"+valor);
  }

  void saida(){
    System.exit(0);
  }
            }








class pr{
  public static void main(String[] args){
    Scanner entrada = new Scanner(System.in);
    int opt;
    float dp,sc,cont=1000;;


    conta minhaconta = new conta();



    System.out.println("digite o nome do dono:");
    minhaconta.nome = entrada.nextLine();
    System.out.println("Informe o número da conta:");
    minhaconta.conta = entrada.nextInt();
    System.out.print("Digite o saldo inicial da conta:");
    minhaconta.saldo = entrada.nextFloat();




    do{
      System.out.println("Bem-vind@, "+minhaconta.nome+"\nConta n°: "+minhaconta.conta+"\n");
      System.out.println("----------------------Menu----------------------\n");
      System.out.println("Digite o número que corresponde a opção desejada\n");
      System.out.println("1. Consultar saldo");
      System.out.println("2. Efetuar saque ");
      System.out.println("3. Efetuar depósito");
      System.out.println("4. Sair");
      opt = entrada.nextInt();


      if(opt==1){
        // minhaconta.saldo = cont;
        //
        // System.out.print("Saldo da conta: R$"+minhaconta.saldo);
        minhaconta.qntd(cont);
        break;

      }

      if(opt==2){
        System.out.println("Informe o valor que deseja sacar:");
        sc = entrada.nextFloat();
        minhaconta.saca(sc);
        cont=cont-sc;
        System.out.println("Novo saldo:"+cont+"\n");
        return;
      }

      if(opt==3){
        System.out.println("Informe o valor que deseja depositar:\n");
        dp = entrada.nextFloat();
        minhaconta.deposita(dp);
        cont=cont+dp;
        System.out.println("Novo saldo:"+cont+"\n");
        return;
      }
      if(opt==4){
        System.out.println("\n");
        // opt=0;
        minhaconta.saida();
      }
      else{
        System.out.println("Opção inválida!\n");}
        break;
    } while(opt!=0);
      }
                                      }
