//Jepherson Silva de Sousa
import java.util.Scanner;
public class Exercicio1_3 {
 public static void main(String[] args) {
 
Scanner scan = new Scanner(System.in);

        System.out.print("digite um numero: ");
        int x = scan.nextInt();
        System.out.print("digite outro numero: ");
        int y = scan.nextInt();

        if(x == y){
            System.out.println("os numeros sao iguais");
        }
    else if(x > y){
           System.out.println("A diferença do primeiro pelo segundo é " + (x - y)); 
        }
        else if(x < y){
           System.out.println("A diferença do segundo pelo primeiro é " + (y - x)); 
        }
        scan.close();
    }
}
