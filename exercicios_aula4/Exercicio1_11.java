//Jepherson Silva de Sousa
import java.util.Scanner;
public class Exercicio1_11
 {
 public static void main(String[] args) {
 
Scanner scan = new Scanner(System.in);

    System.out.print("Digite sua idade:" );
        int n1 = scan.nextInt();
    

            if  (n1 >= 5 && n1 <= 7) {
                    System.out.println("Sua categoria é Infantil A");
                } else if  (n1 >= 8 && n1 <= 10) {
                    System.out.println("Sua categoria é Infantil B");
                } else if  (n1 >= 11 && n1 <= 13) {
                    System.out.println("Sua categoria é Juvenil A");
                } else if  (n1 >= 14 && n1 <= 17) {
                    System.out.println("Sua categoria é Juvenil B");
                } else if  (n1 >= 18) {
                    System.out.println("Sua categoria é Sênior");
                }
              scan.close();      
     }
            
}

