public class Precos{
  //Quilometragem máxima por mês: 3.000km;
    //Quilometragem por ano: 36.000km;
    // Limpeza 4x/mês = R$160,00 p/ mês;
    // Seguro = 1.300,00 p/ ano;
    // IPVA + Licenciamento = R$900,00 p/ ano;
    double Diaria = 150, Quilometragem;
    double Combustivel = 0.37, Limpeza = 0.53, Seguro = 0.036, IPVA_Licenc = 0.025;
    double Taxa_Quilo = (Combustivel+Limpeza+Seguro+IPVA_Licenc);




  public void setDiaria(double dia){
    this.Diaria = dia;
  }

   public void setQuilometragem(double km){
    this.Quilometragem = km;
  }

  public void setCombustivel(double combs){
    this.Combustivel = combs;
  }

  public double getDiaria(){
    return this.Diaria;

  }

   public double getQuilometragem(){
     return this.Quilometragem;
   }

  public double getCombustivel(){
    return this.Combustivel;
  }

  public double calculacombustivel(double combustivelfaltando){
    double gasto;
    gasto = combustivelfaltando*4.8;
    return gasto;

  }

  // public void setTaxquilometragem(double km){
  //   this.Taxquilometragem = km;
  //
  // }
  //
  // public double getTaxquilometragem(){
  //   return this.Taxquilometragem;
  // }

  public void Show(){
          System.out.println();
          System.out.print("\t-|-------------------------------|-");
          System.out.print("\n\t | Valor da diaria R$" + this.Diaria + "       |");
          System.out.print("\n\t |-------------------------------|");
          System.out.printf("\n\t | Combustivel p/ km R$%.2f", this.Combustivel);
          System.out.print("      |");
          System.out.print("\n\t |-------------------------------|");
          System.out.printf("\n\t | Taxa de quilometragem R$%.2f", this.Taxa_Quilo);
          System.out.print("  |");
          System.out.print("\n\t-|-------------------------------|-\n");
      }
/*

    3. Classe Preços – valores das diárias, taxa de quilometragem e valor do combustível;
     O valor cobrado pela locação é composto de uma taxa diária + a quilometragem rodada.
     O cliente recebe o veiculo com o tanque cheio.
     Ao entregar o veiculo será realizado a cobrança das diárias, da quilometragem e a reposição do
    combustível caso não esteja com o tanque cheio.
     Os valores das diárias, da taxa de quilometragem e do valor do combustível estão registrados em uma
    tabela de preços.
*/
}
