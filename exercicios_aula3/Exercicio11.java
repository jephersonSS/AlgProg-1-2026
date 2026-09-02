//Jepherson Silva de Sousa
import java.util.Scanner;

public class Exercicio11
 {
 public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.print("Digite o ano que você nasceu: ");
    int ano1 = scanner.nextInt();
    System.out.print("Digite o ano atual: ");
    int ano2 = scanner.nextInt();

    int idade1 = ano2-ano1;
    int idade2 = 2030-ano1;

    System.out.println("Você atualmente tem :" + idade1 + " anos ");
    System.out.println("em 2030 você terá ou tinha: " + idade2 + " anos");
        
    scanner.close();
    }
}