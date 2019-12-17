// class TestaReferencias{
//   public static void main(String args[]){
//     conta c1 = new.conta();
//     c1.deposita(100);
//
//     conta c2 = c1; //linha importante
//     c2.deposita(200);
//
//     System.out.println(c1.saldo);
//     System.out.println(c2.saldo);
//   }
// }
// import java.util.Scanner();
// class circulo{
//   float raio;
//   float cr;
//   void calculo(float ry ){
//     p=(2*3.14)*raio;
//   }
// }
//
// class TestaReferencias{
//   public static void main(String args[]){
//     Scanner entrada = new Scanner(System.in);
//
//
//   }
// }
import java.util.Scanner;

class prestacao{
  float total;
  float entrada;
  float taxa;
  int x;
  int dia;

  void simpl(float valor){
    Scanner entrada = new Scanner(System.in);
    float jur,juros,per;
    int mes=0;
    System.out.println("Informe a taxa de juros:");
    jur = entrada.nextFloat();
    mes=mes/100;
    System.out.println("Informe a quantidade de meses");
    per = entrada.nextFloat();
    juros=valor*jur*per;
    // juros=valor*i*t;
    System.out.println("Novo valor da parcela:"+juros);
  }
  void data(int dia,float valor){
    if(dia>5){
      valor=valor*(2/100);
    }
  }
  void bene(float valor,int dia){
    if(dia<5){
      valor=valor-(5/valor);
    }
  }
  void saida(){
    System.exit(0);
  }
}

class pr{
  public static void main(String[] args){
    Scanner entrada = new Scanner(System.in);
    int opt,dia;
    float total;

    prestacao minhapres = new prestacao();

    System.out.print("Digite o valor inicial da prestação");
    minhapres.total = entrada.nextFloat();
    System.out.println("Informe o número de prestações:");
    minhapres.x = entrada.nextInt();
    System.out.println("Deseja pagar algum valor de entrada?");
    minhapres.entrada = entrada.nextFloat();
    System.out.println("Informe a data do pagamento");
    minhapres.dia = entrada.nextInt();




    do{

      System.out.println("----------------------Menu----------------------\n");
//       System.out.println("Digite o número que corresponde a opção desejada\n");
//       System.out.println("1. Calcular o valor das prestações com juros simples e o total da operação, possibilidade de ter
// um valor como entrada");
//       System.out.println("2. Calcular o valor a ser pago na antecipação de uma prestação ");
//       System.out.println("3. Calcular o valor de uma prestação paga com atraso, utilizando juros simples e cobrando
// multa");
//       System.out.println("4. Sair");
      opt = entrada.nextInt();


      if(opt==1){
        minhapres.simpl(total);
        break;

      }

      if(opt==2){
        minhapres.bene(total,dia);
      }

      if(opt==3){
        minhapres.data(dia,total);
      }
      if(opt==4){
        System.out.println("\n");
        // opt=0;
        minhapres.saida();
      }
      else{
        System.out.println("Opção inválida!\n");}
        break;
    } while(opt!=0);
      }
    }
