import java.util.Scanner;
public class prog {
 public static void main(String[] args) {

      double parcela,juros,multa;
      int dia;

      Scanner sc = new Scanner(System.in);
      System.out.print("informe a parcela");
      parcela = sc.nextDouble();
      System.out.print("informe os juros(duas casas após a virgula)");
      juros = sc.nextDouble();
      System.out.print("dia em que foi pago - a partir do dia 5 havera multa");
      dia = sc.nextInt();

      if(dia>5){
        multa=0.02;
        parcela=parcela+(parcela*multa);
        parcela = parcela+(parcela*juros);
        System.out.print("PARCELA = "+parcela+"\n");
        System.out.print("JUROS = "+juros+"\n");
        System.out.print("MULTA - "+multa+"\n");
      } else if(dia>31){
        System.out.print("dia invalido\n");

      }else{
        System.out.print("PARCELA = "+parcela+"\n");
      }




   }
}
// calcula os 2% depois da porcentagem 
