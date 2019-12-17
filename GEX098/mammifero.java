public abstract ANIMAL{
  protected float peso;
  protected int idade;
  protected int membros;

  public abstract locomover(){
    System.out.println("Correndo");
  }

  public abstract alimentar(){
    System.out.println("Tomando uns bons drink");
  }

  public abstract emitirsom(){
    System.out.println("RAWWWNNN");
  }
}
