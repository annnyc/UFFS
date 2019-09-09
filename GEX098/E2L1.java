import java.util.Scanner;
public class prog1 {
 public static void main(String[] args) {

      double TOTAL, A,B,C;
      Scanner sc = new Scanner(System.in);
      TOTAL = sc.nextInt();

      A = TOTAL*0.39;
      B = TOTAL*0.43;
      C = TOTAL-(A+B);


      System.out.print("39% corresponde a:"+A+"\n");
      System.out.print("43% corresponde a:"+B+"\n");
      System.out.print("O restante eh:"+C+"\n");

   }
}
