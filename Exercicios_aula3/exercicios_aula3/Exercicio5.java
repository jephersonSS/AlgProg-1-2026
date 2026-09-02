import java.util.Scanner;

public class Exercicio5{
 public static void main(String[] args) {

    Scanner en = new Scanner(System.in);
    
        System.out.print("digite sua primeira nota: ");
        int n1 = en.nextInt();
        System.out.print("digite sua segunda nota: ");
        int n2 = en.nextInt();
        System.out.print("digite sua terceira nota: ");
        int n3 = en.nextInt();
    double media = (n1+n2+n3)/3;

        System.out.printf("Sua média aritmética é: %.2f.%n", media);
        
        en.close();

    }
}
