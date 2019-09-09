/*
Alunas: Any Cruz Silva e Nicole Ribas de Abreu.

4. Classe Locação – registar as locações da frota, associando o cliente, veiculo da frota, total das
diárias, total da quilometragem, total da reposição do combustível.

*/
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class Main{
    static ArrayList<Clientes> Cliente = new ArrayList<Clientes>();
    static ArrayList<Frota> Carro = new ArrayList<Frota>();
    // static ArrayList<Precos> Preco = new ArrayList<Precos>();
    static ArrayList<Locacao> Loca = new ArrayList<Locacao>();

//op5
    public static void ListarClientes(){
      if(Cliente.size() > 0){
            for (int i=0; i<Cliente.size(); i++){
                System.out.print("\n\tCliente " + (i+1) + ":");
                Cliente.get(i).Show();
            }
        }else{
            System.out.println("\n\t*SEM CLIENTES!*\n");
        }
    }
//op6
    public static void ListarFrota(){
      if(Carro.size() > 0){
            for (int i=0; i<Carro.size(); i++){
                System.out.print("\n\tCarro " + (i+1) + ":");
                Carro.get(i).Show();
            }
        }else{
            System.out.println("\n\t*SEM CARROS!*\n");
        }
    }
// op7
// public static void ListarLocacoes(){
//   if(Locacao.size() > 0){
//        for (int i=0; i<Locacao.size(); i++){
//          if(Clientes.ID()==Frota.IDC()){
//          System.out.println("Cliente:"+Locacao.get(i));
//          }
//            // System.out.print("\n\tLocacao " + (i+1) + ":");
//            // Locacao.get(i).Show();
//        }
//    }else{
//        System.out.println("\n\t*NENHUM CARRO FOI LOCADO!*\n");
//      }}



    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int menu = 1;
        Clientes cliente = new Clientes();
        Frota carro = new Frota();
        Precos preco = new Precos();
        Locacao loca = new Locacao();
        // Locacao.add(loca);
        do{
            System.out.println();
            System.out.println("\t\t********");
            System.out.println("\t\t* MENU *");
            System.out.println("\t\t********");
            System.out.println("\t1. Cadastrar clientes;");
            System.out.println("\t2. Cadastrar Frota;");
            System.out.println("\t3. Cadastrar precos;");
            System.out.println("\t4. Cadastrar a locacao de um veiculo;");
            System.out.println("\t5. Listar os clientes cadastrados;");
            System.out.println("\t6. Listar os veiculos da frota;");
            System.out.println("\t7. Listar as Locacoes;"); ////
            System.out.println("\t8. Calcular o total das diarias;");
            System.out.println("\t9. Calcular o total da quilometragem;");
            System.out.println("\t10. Calcular o total da reposicao do combustivel;");
            System.out.println("\t11. Calcular o total final da locacao;");
            System.out.println("\t12. Listar os dados da locacao (extrato para o cliente);");
            System.out.println("\t0. Sair;");
            System.out.print("\tOpcao: ");
            menu = sc.nextInt();

            switch(menu){
                case 1:{
                    // cliente = new Cliente();


                    System.out.print("\tCarteira de habilitacao: ");
                    cliente.setCnh(sc.nextInt());

                    System.out.print("\tID: ");
                    cliente.setId(sc.nextInt());
                    System.out.println("\tDigite novamente o ID, por favor");
                    carro.setIDC(sc.nextInt());

                    System.out.print("\n\tNome do cliente: ");
                    cliente.setName(sc.next());

                    Cliente.add(cliente);
                  break;

                }
                case 2:{
                  carro = new Frota();
                  System.out.print("\n\tMarca: ");
                  carro.setMarca(sc.next());

                  System.out.print("\tModelo: ");
                  carro.setModelo(sc.next());

                  System.out.print("\tPlaca: ");
                  carro.setPlaca(sc.next());

                  System.out.print("\tQuilometragem: ");
                  carro.setQuilometragem(sc.nextDouble());
                  Carro.add(carro);
                    break;
                }
                case 3:{
                    preco = new Precos();
                    preco.Show();
                    break;
                }

                case 5:{
                  if(Cliente.size() > 0){
                        for (int i=0; i<Cliente.size(); i++){
                            System.out.print("\n\tCliente " + (i+1) + ":");
                            Cliente.get(i).Show();
                        }
                    }else{
                        System.out.println("\n\t*SEM CLIENTES!*\n");
                    }
                  ListarClientes();
                  break;
                }

                case 6:{
                  if(Carro.size() > 0){
                        for (int i=0; i<Carro.size(); i++){
                            System.out.print("\n\tCarro " + (i+1) + ":");
                            Carro.get(i).Show();
                        }
                    }else{
                        System.out.println("\n\t*SEM CARROS!*\n");
                    }
                  ListarFrota();
                  break;
                }
                // case 7:{
                // //   if(Locacao.Size() > 0){
                // //        for (int i=0; i<Locacao.size(); i++){
                // //            System.out.print("\n\tLocacao " + (i+1) + ":");
                // //            Locacao.get(i).Show();
                // //        }
                // //    }else{
                // //        System.out.println("\n\t*NENHUM CARRO FOI LOCADO!*\n");
                // //    }
                // ListarLocacao();
                //   break;
                // }

                case 8:{
                  System.out.print("\n\tTotal de horas com o carro: ");
                   int horas = sc.nextInt();
                   double total_diaria = (preco.Diaria/24)*horas;
                   System.out.println("\tTotal das diarias R$" + total_diaria);

                  break;
                }


                case 9:{
                    System.out.print("\n\tQuilometragem rodada: ");
                    double km = sc.nextDouble();
                    double total_km = preco.Taxa_Quilo*km;
                    System.out.printf("\tTotal da quilometragem R$%.2f", total_km);
                    preco.setQuilometragem(total_km);
                    System.out.println("\n");
                  break;
                }

                case 10:{//em media  um tanque comporta 45L de combustivel
                  System.out.printf("\tInforme a quantidade utilizada de combustivel do tanque (em porcentagem) quando o carro foi retornado.");
                  double combs = sc.nextDouble();
                  double totcomb = 0.45;
                  totcomb=combs*0.45;
                  double dif = 100-combs;
                  System.out.printf("\tA diferenca do tanque cheio para o valor informado e de (em porcentagem):"+dif);
                  if(totcomb==0){
                    System.out.println("\t\n\tSem cobranca de taxa de combustivel.");
                  }
                  else{
                    System.out.println("\n");
                    System.out.println("\tUm carro da frota percorre 13km com 1L de combustivel, para completar o tanque devera ser pago um total de R$:"+preco.calculacombustivel(totcomb));

                  }
                  break;
                }



                case 11:{
                  System.out.println("\n\t O valor cobrado pela locacao é composto de uma taxa diaria + a quilometragem rodada.");

                  double totaldelocacao = preco.Diaria + preco.Quilometragem;
                  System.out.println("\tValor a ser pago referente a taxa de locacao:"+totaldelocacao);

                  break;
                }

                case 12:{
                  System.out.println("\n\tExtrato.");
                  System.out.println("\n\tInforme seu numero de cadastro");
                  int bav = sc.nextInt();
                  if(Cliente.size() > 0){
                        for (int i=0; i<Cliente.size(); i++){
                          // if(Cliente.getID()==Frota.IDC()){
                          //   Frota.IDC() = bav;
                          //
                          //   System.out.println("\n\t",Cliente.get(bav));
                          // }

                            if(Cliente.get(i)==Cliente.get(bav)){
                                Cliente.get(bav).Show();}
                                System.out.print("\n\tCliente " + (i) + ":");
                        }
                    }else{
                        System.out.println("\n\t*SEM CLIENTES!*\n");
                    }

                    if(Carro.size() > 0){

                          for (int i=0; i<Carro.size(); i++){
                            if(Cliente.get(i)==Cliente.get(bav))
                              System.out.print("\n\tCarro " + (bav) + ":");
                              Carro.get(i).Show();
                          }
                      }else{
                          System.out.println("\n\t*SEM CARROS!*\n");
                      }
                    break;
                }



            }
            if(menu != 1 && menu != 2 && menu != 3 && menu != 4 && menu != 5 && menu != 6 && menu != 7 && menu != 8 && menu != 9 && menu != 10 && menu != 11 && menu != 12 && menu != 0){
                System.out.println("\n\t\tOPCAO INVALIDA!\n");
            }
        }while(menu != 0);
    }
}
