//Jepherson Silva de Sousa
import java.util.Scanner;

public class Exercicio4 {
 public static void main(String[] args) {

    Scanner en = new Scanner(System.in);
    
        System.out.print("digite seu primeiro número: ");
        int n1 = en.nextInt();
        System.out.print("digite seu segundo número: ");
        int n2 = en.nextInt();
        System.out.print("digite seu terceiro número: ");
        int n3 = en.nextInt();
        System.out.print("digite seu quarto número: ");
        int n4 = en.nextInt();

        System.out.println("A soma dos seus números é: " + (n1+n2+n3+n4));
        
        en.close();
    }
}
