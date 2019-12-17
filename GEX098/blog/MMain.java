import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.ArrayList;

public class MMain{

static ArrayList<Post> Post = new ArrayList<Post>();

public static void showAll(){
if (Post.size() > 0){
		for (int i=0; i < Post.size(); i++){
			System.out.println("\n\tPost " + (i+1) + ":");
			Post.get(i).Show();}
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
    System.out.print("\n\tData (--/--/----): ");
    String quedia = sc.nextLine();
    DateFormat dt = new SimpleDateFormat("yy/mm/dddd");
    p1.setDate(dt.parse(quedia));
    }
catch (Exception ex){
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
			System.out.print("\n\tMarca do produto: ");
			p1.setBrand(sc.nextLine());

            do{
				System.out.print("\n\tEstrelas do produto (0 a 5): ");
				star = sc.nextInt();
				if (star >= 0 && star <= 5){
                    pr.Evaluate(star);
                }else{
                    System.out.println("\n\t*DE 0 A 5.*");
			    }
            }while(!(star >= 1 && star <= 5));
		}
        Post.add(p1);
	}
}


  public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    int op=1,q,p;
    while (op!=0)
    {
    System.out.println("\nBLOG: O que voce quer fazer?\n");
    System.out.println("\n1 - Novo post de noticia\n2 - Nova resenha de produto\n3 - Novo post de outros assuntos\n4 - Listar todas as postagens\n5 - Curtir uma postagem\n6 - Não curtir uma postagem\n10 - Sair\nEscolha uma opcao:");
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
      System.out.println("Numero do post: ");
                   int num_posts = (sc.nextInt()-1);
                   if (num_posts >= 0 && num_posts <= Post.size()){
                       Post.get(num_posts).Like();
                       System.out.println("\n\t+1 like.");
                   }else{
                       System.out.println("\n\tSem post c/ esse numero.");
                   }
      break;
    }

    case 6:{
      System.out.println("Nao curtir uma postagem.");
      System.out.print("\n\tNumero do post: ");
                   int num_posts = (sc.nextInt()-1);
                   if (num_posts >= 0 && num_posts <= Posts.size()){
                       Post.get(num_posts).Deslike();
                       System.out.println("\n\t+1 deslike.");
                   }else{
                       System.out.println("\n\tSem post c/ esse numero.");
                   }
      break;
    }

    case 10:{
      System.out.println("Tchau.");
      break;
    }


    default:{
      System.out.println("Comando inválido!\n");
      break;
    }

 }
}}
