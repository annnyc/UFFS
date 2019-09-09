import java.util.Scanner;
public class prog {
 public static void main(String[] args) {

      double parcela,desc;
      int dia;

      Scanner sc = new Scanner(System.in);
      System.out.print("informe a parcela");
      parcela = sc.nextDouble();
      System.out.print("desconto");
      desc = sc.nextDouble();
      System.out.print("dia em que foi pago");
      dia = sc.nextInt();

      if(dia<=5){

        parcela=parcela-(parcela*desc);
        System.out.print("PARCELA = "+parcela+"\n");
        System.out.print("DESCONTO = "+desc+"\n");
      } else if(dia>31){
        System.out.print("dia invalido");

      }




   }
}
