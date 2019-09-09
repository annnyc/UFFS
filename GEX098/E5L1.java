import java.util.Scanner;
public class pro1 {
 public static void main(String[] args) {

      int x,y,aux;
      Scanner sc = new Scanner(System.in);
      System.out.print("informe a variavel correspondente a x");
      x = sc.nextInt();
      System.out.print("informe a variavel correspondente a y");
      y = sc.nextInt();

      aux = x;
      x = y;
      y = aux;




      System.out.print("a variavel x é :"+x+"\n");
      System.out.print("a variavel y é :"+y+"\n");


   }
}
