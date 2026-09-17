//Jepherson Silva de Sousa
import java.util.Scanner;
public class Exercicio1_9
 {
 public static void main(String[] args) {
 
Scanner scan = new Scanner(System.in);

    System.out.print("Digite o seu salário: ");
            double sal = scan.nextDouble();
            System.out.print("Digite o valor do empréstimo: ");
            double emp = scan.nextDouble();

            double por = emp / sal;

            if (por <= 0.3) {
                System.out.println("Empréstimo aprovado!");
            } else {
                System.out.println("Empréstimo não pode ser concedido!");
            }
    scan.close();
        }

    }

