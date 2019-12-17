// import java.util.ArrayList;
// import java.util.Scanner;
// import java.util.Date;
// import java.text.DateFormat;
// import java.text.SimpleDateFormat;
// public class Blog{
//
// static ArrayList<Post> Post = new ArrayList<Post>();
//
// public static void showAll(){
// if (Post.size() > 0){
// 		for (int i=0; i < Post.size(); i++){
// 			System.out.println("\n\tPost " + (i+1) + ":");
// 			Post.get(i).Show();}
// 		}
//     else{
// 			System.out.println("Nao existem postagens a serem exibidas. \n");
// 		}
//     }
//
// public static void readData(Post p1){
// Scanner sc = new Scanner(System.in);
// System.out.print("\n\tTitulo: ");
// p1.setTitle(sc.nextLine());
//
// System.out.print("\n\tPost: ");
// p1.setContent(sc.nextLine());
//
// try{
//     System.out.print("\n\tData (--/--/----): ");
//     String quedia = sc.nextLine();
//     DateFormat dt = new SimpleDateFormat("yy/mm/dddd");
//     p1.setDate(dt.parse(quedia));
//     }
// catch (Exception ex){
//             ex.printStackTrace();
//         }
//
// if (p1 instanceof News){
// 			System.out.print("\n\tFonte: ");
// 			News nw = (News) p1;
// 			nw.setSource(sc.nextLine());
// 		}
//
// if (p1 instanceof ProductReview){
//       int star;
// 			ProductReview pr = (ProductReview) p1;
// 			System.out.print("\n\tMarca do produto: ");
// 			p1.setBrand(sc.nextLine());
//
//             do{
// 				System.out.print("\n\tEstrelas do produto (0 a 5): ");
// 				star = sc.nextInt();
// 				if (star >= 0 && star <= 5){
//                     pr.Evaluate(star);
//                 }else{
//                     System.out.println("\n\t*DE 0 A 5.*");
// 			    }
//             }while(!(star >= 1 && star <= 5));
// 		}
//         Post.add(p1);
// 	}
// }
