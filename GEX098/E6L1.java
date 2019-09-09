import java.util.Scanner;
public class prog {
 public static void main(String[] args) {

      float j,c,t,i;

      Scanner sc = new Scanner(System.in);
      System.out.print("informe o capital");
      c = sc.nextFloat();
      System.out.print("informe a taxa de juros (duas casas após a virgula)");
      i = sc.nextFloat();
      System.out.print("informe o tempo (meses)");
      t = sc.nextFloat();

      j = c*i*t;



      System.out.print("o rendimento no final sera de :"+j+"\n");



   }
}
 // juros simples 
