import java.util.Scanner;
public class prog1 {
 public static void main(String[] args) {

      float pz=10.00,rf=5.00,sv=2.00,total,gj,tp,tr,ts;
      int px,rx,st,pp;

      Scanner sc = new Scanner(System.in);
      System.out.print("informe a quantidade de pizzas");
      px = sc.nextInt();
      System.out.print("informe a quatidade de refrigerantes");
      rx = sc.nextInt();
      System.out.print("informe a quantidade de sorvetes");
      st = sc.nextInt();
      System.out.print("Total de pessoas");
      pp = sc.nextInt();

      tp=pz*px; //pizza
      tr=rf*rx; //refri
      ts=sv*st; //sorv
      tl=tp+tr+ts;
      total=(pz+rf+sv)/pp;
      gj=total*0.1;

      System.out.print(px);
      System.out.println(" pizzas de cada = "+tp+"\n");
      System.out.print(" %d de refrigerates de %f = \n",rx,tr);
      System.out.print("SORVETE - "+ts+"\n");
      System.out.print("TOTAL "+total+"\n");
      System.out.print(" GORJETA "+gj+"\n");
      System.our.print(" "+tl+"\n");


// System.out.printf(" %0,2d- %s\n", (i+1), nomeMes[i]);

   } //50/50
}
