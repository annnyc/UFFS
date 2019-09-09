//ingresso
import java.util.Scanner;
import java.util.Arrays;
public class Ingresso {
private  float valor;

public float Ingresso(){
  return this.valor = 50.0f;
}

  public float MostraValor(){
    System.out.println("O valor integral do ingresso é:"+this.valor);
    return this.valor;
  }
}

//ingresso normal

public class IngressoNormal extends Ingresso{
  private int Qntd;
  private float desconto;
  private float total;
  private float val; //NAO CONSIGO PUXAR O VALOR DA CLASSE INGRESSO :(


  public void CalcValor(float quant){

      if(quant>5 && quant<10){
        this.total=47.5f*quant;
      }

      if(quant>10 && quant<15){
        this.total=45.0f*quant;
      }
      if(quant>16.0f){

        this.total=42.5f;
      }
      else{
        this.total=50.0f*quant;
      }
      System.out.println("O total da compra foi de:"+this.total);


  }

  public float Showvalor(){
    System.out.println("O valor do ingresso comum é:"+this.total);
    return this.val;
  }

  public float getValor(){
    return this.val;
  }
  //
  // public float setValor(){}
}


//ingresso vip

public class IngressoVIP extends Ingresso{
  private float ValorAdicional;

  public void IngressoVIP(){
     this.ValorAdicional = 100.0f;
  }
  public float VlrIngressoVIP(){
    System.out.println("O valor do ingresso VIP é:"+this.ValorAdicional);
    return this.ValorAdicional;
  }

  public float getValorVIP(){
    IngressoVIP();
    return this.ValorAdicional;
  }



  public void setquantidadeVIP(float u){
    u=u*this.ValorAdicional;
    System.out.println(u);
  }


}
 
 
//camarote superior
public class CamaroteSuperior extends IngressoVIP{
  private float ValorAdicional;

  public void CamaroteSuperior(){
     this.ValorAdicional = 200.0f;
  }

  public float getCS(){
    CamaroteSuperior();
    return this.ValorAdicional;
  }

  public float MostVal(){
    System.out.println("O valor do camarote superior é:"+this.ValorAdicional);
    return this.ValorAdicional;
  }




  public void setQuantidadeCS(float xxx){
    xxx=xxx*this.ValorAdicional;
    System.out.println(xxx);
  }
}

//camarote inferior

public class CamaroteInferior extends IngressoVIP{

  private String Local;
  private float VlrAdicional;
  private float DescontoConsumo;
  private float Consumototal;


  // public void CamaroteInferior(){
  //    this.VlrAdicional = 300.0f;}
  // }

public void setValorcam(){
  float ko=250.0f;
  this.VlrAdicional = ko;
}

  public String MostrarLocal(){
    System.out.println("O camarote inferior é localizado em:"+this.Local);
    return this.Local;
  }

  public void setConsumoh(float consumo){
    this.Consumototal=consumo;

    System.out.println("O total consumido foi de:"+this.Consumototal);
    System.out.println("Total do valor consumido com desconto:"+DSCON(consumo));
  }


  public float DSCON(float descon){
     if(descon>200.0f){
       descon=descon-(descon*0.11f);
       this.DescontoConsumo=descon;
       return this.DescontoConsumo;
     }

     if(descon>500.0f){
       descon=descon-(descon*0.15f);
       this.DescontoConsumo=descon;
       return this.DescontoConsumo;
     }
     return 0;
   }

  public void setLocalC(String lugar){
    this.Local = lugar;
    System.out.println(lugar);
  }

  public float getCamaroteInf(){
    setValorcam();
    return this.VlrAdicional;
  }

  public void setQuantidadeCI(float rt){
   rt=rt*this.VlrAdicional;
    System.out.println(rt);
  }
}

//main

import java.util.Scanner;
import java.util.Arrays;

public class Main {

 public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
   int op=1,q,p;
    while (op!=0)
    {
    System.out.println("\nBEM-VIND@!\n");
    System.out.println("\nPor favor, digite o numero correspondente a opcao desejada.\n\n1- Comprar ingresso normal.\n2- Comprar ingresso VIP\n\n\n\n");
    op = sc.nextInt();
		switch (op)
		{
			case 1: {
        System.out.println("INGRESSO NORMAL\n\n");
        Ingresso x = new Ingresso();
        System.out.println("O valor unitario do ingresso comum eh de:"+x.Ingresso()+"\n");
        System.out.println("Por favor, informe a quantidade de ingressos:");
        q = sc.nextInt();
        IngressoNormal j = new IngressoNormal();
        j.CalcValor(q);

        break;

        // if(0<q<5){
        //   IngressoNormal j = new IngressoNormal();
        //   j.CalcValor(q);
        // }
        //
        // if(5<=q<=10){
        //   IngressoNormal a =  new IngressoNormal();
        //   a.CalcValor(q);
        // }
        // if(q>15){
        //   IngressoNormal l =  new IngressoNormal();
        //   l.CalcValor(q);
        // }
      }

    case 2:{

      float vip;
      System.out.println("INGRESSO VIP E CAMAROTES\n\n");
      System.out.println("Informe a opcao desejada:");
      System.out.println("1- Ingresso VIP\n2- Camarote Superior\n3-Camarote Inferior\n");
      p = sc.nextInt();
      if(p==1){
        IngressoVIP w = new IngressoVIP();
        System.out.println("O valor do ingresso vip consiste em "+w.getValorVIP()+ " + Adicional\n");
        System.out.println("Informe a quantidade desejada de ingressos VIP.");
        vip = sc.nextFloat();
        System.out.print("Total a ser pago: R$");
        w.setquantidadeVIP(vip);
      }
      if(p==2){
        float cm;
        CamaroteSuperior d = new CamaroteSuperior();
        System.out.println("O valor do camarote superior consiste em "+d.getCS()+" + Adicional");
        System.out.println("Informe a quantidade desejada de reservas correspondentes ao camarote superior.");
        cm = sc.nextFloat();
        System.out.print("Total a ser pago: R$");
        d.setQuantidadeCS(cm);
      }

      if(p==3){
        float ci,consumo;
        String place;


        CamaroteInferior z = new CamaroteInferior();
        z.setValorcam();
        System.out.println("O valor do camarote inferior consiste em "+z.getCamaroteInf());
        System.out.println("Digite em qual area deseja ficar:\n- Sul\n- Norte\n- Oeste\n- Leste.");
        place = sc.next();
        z.setLocalC(place);
        System.out.println("Informe a quantidade desejada de reservas correspondentes ao camarote inferior.");
        ci = sc.nextFloat();
        System.out.print("Total a ser pago: R$");
        z.setQuantidadeCI(ci);
        // z.getQuantidadeCI();
        System.out.println("Informe o total consumido.");
        consumo = sc.nextFloat();
        if(consumo<200.5f){
          z.setConsumoh(consumo);
        }
        if(consumo>=200.5f){
          z.setConsumoh(consumo);
        }



      }



      break;
    }

    // case 3:{
    //   exit(0);
    //
    // }

    default:{
      System.out.println("Comando inválido!\n");
      break;
    }

      }}}






   // IngressoNormal b = new IngressoNormal();
   // b.Showvalor();
   //
   // CamaroteInferior h = new CamaroteInferior();
   // h.Consumo();


 }

