import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.ArrayList;

public class Blogg{

static ArrayList<Post> Posts = new ArrayList<Post>();

public static void showAll(){
if (Posts.size() > 0){
		for (int i=0; i < Posts.size(); i++){
			System.out.println("\n\tPost " + (i+1) + ":");
			Posts.get(i).Show();}
		}
    else{
			System.out.println("Nao existem postagens a serem exibidas. \n");
		}
    }

public static void readData(Post p1){
Scanner sc = new Scanner(System.in);
System.out.print("\n\tTitulo: ");
p1.setTitle(sc.nextLine());

System.out.print("\n\tPost: ");
p1.setContent(sc.nextLine());

try{
    System.out.print("Informe a data no seguinte formato: (dd/mm/aaaa): ");
    String quedia = sc.nextLine();
    DateFormat dt = new SimpleDateFormat("dd/mm/aaaa");
    p1.setDate(dt.parse(quedia));
    }
catch (Exception ex){
            System.out.println("k");
            ex.printStackTrace();
        }

if (p1 instanceof News){
			System.out.print("\n\tFonte: ");
			News nw = (News) p1;
			nw.setSource(sc.nextLine());
		}

if (p1 instanceof ProductReview){
      int star;
			ProductReview pr = (ProductReview) p1;
			System.out.print("Informe a marca do produto:\n");
			pr.setBrand(sc.nextLine());

            do{
				System.out.print("Avalie o produto em estrelas(0 a 5): \n");
				star = sc.nextInt();
				if (star >= 0 && star <= 5){
                    pr.Evaluate(star);
                }else{
                    System.out.println("Por favor, avalie de 0 a 5.");
			    }
            }while(!(star >= 1 && star <= 5));
		}
        Posts.add(p1);
	}



  public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    int op=1,q,p;
    Post p1;
    while (op!=0)
    {
    System.out.println("\nBLOG: O que voce quer fazer?\n");
    System.out.println("\n1 - Novo post de noticia\n2 - Nova resenha de produto\n3 - Novo post de outros assuntos\n4 - Listar todas as postagens\n5 - Curtir uma postagem\n6 - Nao curtir uma postagem\n10 - Sair\nEscolha uma opcao:");
    op = sc.nextInt();
		switch (op)
		{
			case 1: {

        System.out.println("Novo post de noticia.");
        p1 = new News();
        readData(p1);
        // System.out.println("Informe a data da postagem no formato ano-mes-dia.");
        // Date dat;
        // ToolBox.readDate(sc, "YYYY-MM-DD");
        // p1.setDate(dat);




        break;}

    case 2:{
      // String mark;
      // System.out.println("Nova resenha de produto.");
      // ProductReview resenha = new ProductReview();
      // System.out.println("Informe a marca do produto.");
      // mark = sc.next();
      // resenha.setBrand(mark);
      // System.out.println("Quantas estrelas vale o produto? (numa escala de 0 a 5)");
      // mark = sc.nextInt();
      p1 = new ProductReview();
      readData(p1);



      break;
    }

    case 3:{
      // String operadortitulo;
      // System.out.println("Novo post de outros assuntos.");
      // Post p1 = new Post();
      // System.out.println("Informe o titulo do post.");
      // operadortitulo = sc.next();
      // p1.setTitle(operadortitulo);
      // System.out.println("Informe o conteudo");
      // String contd;
      // contd = sc.nextLine();
      // p1.setContent(contd);
      p1 = new Post();
      readData(p1);

      break;
    }
    case 4:{
      System.out.println("Listar todas as postagens.");
      showAll();

      break;
    }

    case 5:{
      System.out.println("Curtir uma postagem.");
      System.out.println("Informe o numero correspondente ao post: ");
                   int xp = (sc.nextInt()-1);
                   if (xp >= 0 && xp <= Posts.size()){
                       Posts.get(xp).Like();
                       System.out.println("+1 like.");
                   }else{
                       System.out.println("Nao existem postagens com esse numero.");
                   }
      break;
    }

    case 6:{
      System.out.println("Nao curtir uma postagem.");
      System.out.print("Informe o umero do post:\n");
                   int xp = (sc.nextInt()-1);
                   if (xp >= 0 && xp <= Posts.size()){
                       Posts.get(xp).Dislike();
                       System.out.println("+1 dislike.");
                   }else{
                       System.out.println("Nao existem postagens com esse numero");
                   }
      break;
    }

    case 10:{
      System.out.println("\n");
      break;
    }


    default:{
      System.out.println("Comando inválido!\n");
      break;
    }

 }
}}}
