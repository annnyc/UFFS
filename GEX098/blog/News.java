public class News extends Post{
  private String Source;
  private String getSource;
  // @Override
  // public void show(){
  //   System.out.println("FONTE: "+this.source);
  // }
@Override
public void Show(){
        super.Show();
        System.out.println("Fonte: " + getSource());
    }

  public String getSource(){
    return this.Source;
  }

  public void setSource(String fonte){
    this.Source = fonte;
  }
}
