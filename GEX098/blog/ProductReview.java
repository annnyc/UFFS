public class ProductReview extends Post  implements Evaluable{
  private String brand;
  private int Stars = 0;

  @Override
  public void Show(){
    System.out.println("REVIEW DE: ");
    System.out.println("MARCA:"+getBrand());
    System.out.println("ESTRELAS:"+getStars());
  }

  public String getBrand(){
    return this.brand;
  }

  public void setBrand(String b){
    this.brand = b;
  }

  public int getStars(){
    return this.Stars;
  }

  public void setStars(int estrelas){
    this.Stars = estrelas;
  }

  public void Evaluate(int value){
      setStars(value);
  }
  public void Evaluate(){

    }
}
