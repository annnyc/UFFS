import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Post{
  private String Title;
  private Date date;
  private String Content;
  private int Likes = 0;
  private int Dislikes = 0;


  public void Show(){
    System.out.println("SOBRE O POST:");
    System.out.print("Titulo: "+getTitle());
    DateFormat dt = new SimpleDateFormat("yy/mm/dddd");
    System.out.println("Data: "+(dt.format(getDate())));
    System.out.println("Conteudo: "+getContent());
    System.out.println("Likes: "+getLikes());
    System.out.println("Dislikes: "+getDislikes());
  }

  public int getLikes(){
    return this.Likes;
  }

  public void setLikes(int lk){
    this.Likes = lk;
  }

  public int getDislikes(){
    return this.Dislikes;
  }

  public void setDislikes(int disk){
    this.Dislikes = disk;
  }

  public void setTitle(String nomedopost){
    this.Title = nomedopost;
  }

  public String getTitle(){
    return this.Title;
  }

  public void setDate(Date diax){
    this.date = diax;}
    // boolean checkFormat;

  //   if (input.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")){
  //   checkFormat=true;
  //   this.date = diax;}
  //      else{
  //  checkFormat=false;}
  //
  // }

  public Date getDate(){
    return this.date;
  }

  public void setContent(String conteudo){
    this.Content = conteudo;
  }

  public String getContent(){
    return this.Content;
  }
public void Like(){
          setLikes(getLikes()+1);
      }
public void Dislike(){
          setDislikes(getDislikes()+1);
      }




}
