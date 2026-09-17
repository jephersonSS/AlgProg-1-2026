//Jepherson Silva de Sousa
import java.util.Scanner;
public class Exercicio1_10
 {
 public static void main(String[] args) {
 
Scanner scan = new Scanner(System.in);

    System.out.print("Digite o primeiro número inteiro:" );
        int n1 = scan.nextInt();
    System.out.print("Digite o segundo número inteiro:" );
        int n2 = scan.nextInt();
    System.out.print("Digite o terceiro número inteiro:" );
        int n3 = scan.nextInt();

            if  (n1 == n2 && n2 == n3) {
                System.out.println("Os números são iguais.");
            } else{ int maior = n1;
                if (n2 > maior) {
                    maior = n2;
                 } if (n3 > maior) {
                        maior = n3;
                    }
                    System.out.println("O maior numero e: " + maior);
                }
            scan.close();
        }

    }

