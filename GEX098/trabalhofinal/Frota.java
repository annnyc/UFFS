public class Frota{
    String Marca, Modelo, Placa;
    double Quilometragem;
    public int IDC;

    public void setIDC(int x){
      this.IDC = x;
    }


    public void setMarca(String marca){
        this.Marca = marca;
    }
    public String getMarca(){
        return this.Marca;
    }

    public void setModelo(String model){
        this.Modelo = model;
    }
    public String getModelo(){
        return this.Modelo;
    }

    public void setPlaca(String placa){
        this.Placa = placa;
    }
    public String getPlaca(){
        return this.Placa;
    }

    public void setQuilometragem(double km){
        this.Quilometragem = km;
    }
    public double getQuilometragem(){
        return this.Quilometragem;
    }

//    @Override
    public void Show(){
        System.out.println("\n\tMarca: " + getMarca());
        System.out.println("\tModelo: " + getModelo());
        System.out.println("\tPlaca: " + getPlaca());
        System.out.println("\tQuilometragem: " + getQuilometragem());
    }
}
