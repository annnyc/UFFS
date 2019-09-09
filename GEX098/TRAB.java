import java.util.Scanner;
import java.util.Date;

public class Main{
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
        break;}

    case 2:{
      System.out.println("Nova resenha de produto.");

      break;
    }

    case 3:{
      System.out.println("Novo post de outros assuntos.");
      break;
    }
    case 4:{
      System.out.println("Listar todas as postagens.");
      break;
    }

    case 5:{
      System.out.println("Curtir uma postagem.");
      break;
    }

    case 6:{
      System.out.println("Nao curtir uma postagem.");
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
}
\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ main

public class Post{
  private String Title;
  private Date date;
  private String content;
  private int likes;
  private int dislikes;


  public void show(){
    System.out.println("SOBRE O POST:");
    System.out.print("Titulo: "+this.Title);
    System.out.println("Data: "+this.date);
    System.out.println("Conteudo: "+this.content);
    System.out.println("Likes: "+this.likes);
    System.out.println("Dislikes: "+this.dislikes);
  }

  public int getLikes(){
    return this.likes;
  }

  public void setLikes(int lk){
    this.likes = lk;
  }

  public int getDislikes(){
    return this.dislikes;
  }

  public void setDislikes(int disk){
    this.dislikes = disk;
  }


}
\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\post

public class ProductReview extends Post  implements Evaluable{
  private String brand;
  private int stars;

  @Override
  public void show(){
    System.out.println("REVIEW DE: ");
    System.out.println("MARCA:"+this.brand);
    System.out.printtln("ESTRELAS:"+this.stars);
  }

  public String getBrand(){
    return this.brand;
  }

  public void setBrand(String b){
    this.brand = n;
  }

  public int getStars(){
    return this.stars;
  }

  public void setStars(int estrelas){
    this.stars = estrelas;
  }

  public void Evaluate(int value){

  }
}
\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\review

public class News extends Post{
  private String source;

  @Override
  public void show(){
    System.out.println("FONTE: "+this.source);
  }

  public String getSource(){
    return this.source;
  }

  public void setSource(String fonte){
    this.source = fonte;
  }
}
\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\news


public interface Evaluable{
  public abstract void Evaluate(int value);
}
\\\\\\\\\\\\\\\\\evaluable

