import java.util.Scanner;
public class prog1 {
 public static void main(String[] args) {

      double hr,slr,x,hk;
      // int dia;

      Scanner sc = new Scanner(System.in);
      System.out.print("informe as horas trabalhadas");
      hr = sc.nextDouble();
      System.out.print("informe o salario");
      slr = sc.nextDouble();
      System.out.print("informe o valor da hora extra");
      x = sc.nextDouble();
    
      if(hr>8){
        hk=(hr-8)*x;
        slr=slr+hk;
        System.out.print("SALARIO = "+slr+"\n");
        System.out.print("HORA(S) EXTRA(S) = "+hr+"\n");
        System.out.print("VALOR DA HORA EXTRA - "+x+"\n");
      }




   }
}
