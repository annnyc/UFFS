import java.util.Scanner;
public class pro1 {
 public static void main(String[] args) {


      Scanner sc = new Scanner(System.in);
      int dia;
      System.out.print("informe o dia");
      dia = sc.nextInt();
      switch(dia){
            case 1:{
            System.out.print("segunda\n");
            break;}
            case 2:{
            System.out.print("terça\n");
            break;}
            case 3:{
            System.out.print("quarta\n");
            break;}
            case 4:{
            System.out.print("quinta\n");
            break;
            }
            case 5:{
            System.out.print("sexta\n");
            break;
            }
            case 6:{
            System.out.print("sabado\n");
            break;
            }
            case 7:{
            System.out.print("domingo\n");
            break;
            }
            default:{
            System.out.print("invalido\n");
            break;}
            }



      }
    }
