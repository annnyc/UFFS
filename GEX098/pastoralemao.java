public class pastoralemao extends cachorro{
  public void cacar(){
    System.out.println("ESTOU CACANDO!");
  }

  //metodo abaixo sera sobreposto
  //@Override
  public void latir(){
    super.latir();
    // System.out.println("woof woof!");
    System.out.println("Terminei o latido.");
  }
}
