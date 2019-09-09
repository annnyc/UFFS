import java.util.Scanner;
import java.util.Arrays;


public class mainn {
 public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
   pett vetor[] = new pett[10];
   for(int i=0;i<vetor.length;i++){
     if(i%2==0){
       vetor[i] = new dog();
     }

    else{
      vetor[i]= new cat();
    }
    vetor[i].emitirsom();
   }
}
}
