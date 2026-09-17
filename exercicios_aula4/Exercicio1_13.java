//Jepherson Silva de Sousa
import java.util.Scanner;
public class Exercicio1_13
 {
 public static void main(String[] args) {
 
Scanner scan = new Scanner(System.in);

     System.out.print("Digite um numero: ");
            float n1 = scan.nextFloat();

            System.out.print("Digite um sinal (+, -, *, /): ");
            char sinal = scan.next().charAt(0);

            System.out.print("Digite um numero: ");
            float n2 = scan.nextFloat();

            if (sinal == '+') {
                System.out.println("A soma é " + (n1 + n2));
            } else if (sinal == '-') {
                System.out.println("A subtração é " + (n1 - n2));
            } else if (sinal == '*') {
                System.out.println("A multiplicação é " + (n1 * n2));
            } else if (sinal == '/') {
                if (n2 != 0) {
                    System.out.println("A divisão é " + (n1 / n2));
                } else {
                    System.out.println("Impossível dividir!!");
                }
            } else {
                System.out.println("Sinal inválido. Por favor, use apenas +, -, * ou /.");
            }
        scan.close();      
     }
            
}

