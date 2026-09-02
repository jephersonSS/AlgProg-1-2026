//Jepherson Silva de Sousa
import java.util.Scanner;

public class Exercicio3 {
 public static void main(String[] args) {

    Scanner en = new Scanner(System.in);
    
        System.out.print("digite seu primeiro número: ");
        int n1 = en.nextInt();

        System.out.print("digite seu segundo número: ");
        int n2 = en.nextInt();

        System.out.println("O produto dos dois número é: " + (n1*n2));
        
        en.close();


    }
}
