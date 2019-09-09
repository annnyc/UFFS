import java.util.Scanner;
public class prog1 {
 public static void main(String[] args) {

      double volcil,raio,pi=3,altura;
      Scanner sc = new Scanner(System.in);
      System.out.print("informe o raio");
      raio = sc.nextInt();
      System.out.print("informe altura");
      altura = sc.nextInt();
      volcil = pi*(raio*raio)*altura;




      System.out.print("o volume do cilindro é igual a:"+volcil+"\n");


   }
}
