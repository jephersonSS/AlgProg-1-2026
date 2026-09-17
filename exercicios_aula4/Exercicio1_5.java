//Jepherson Silva de Sousa
import java.util.Scanner;
public class Exercicio1_5 {
 public static void main(String[] args) {
 
Scanner scan = new Scanner(System.in);

        System.out.print("digite um numero: ");
        int x = scan.nextInt();
        
        if(x >= 50 && x<=100){
            System.out.println("Pertence ao invervalo");
        }
    else {
           System.out.println("Não pertence ao intervalo");
        }
        scan.close();
    }
}
