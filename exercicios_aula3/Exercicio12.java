import java.util.Scanner;

public class Exercicio12

 {
 public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.print("Digite um número: ");
    double n1 = scanner.nextDouble();
    double n2 = Math.pow(n1, 2);
    double n3 = Math.pow(n1, 3);
    double n4 = Math.pow(n1, 1.0/2.0);
    double n5 = Math.pow(n1, 10);
  
    
    System.out.printf("Seu número elevado ao quadrado é: %.2f%n", n2);
    System.out.printf("Seu número elevado ao cubo é: %.2f%n", n3);
    System.out.printf("A raiz quadrada do seu número é: %.2f%n", n4);
    System.out.printf("Seu número elevado à potência 10 é: %.2f%n", n5);

    scanner.close();
    }
}