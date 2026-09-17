//Jepherson Silva de Sousa
import java.util.Scanner;
public class Exercicio1_6 {
 public static void main(String[] args) {
 
Scanner scan = new Scanner(System.in);

    System.out.print("Digite o seu gênero (1 para masculino, 2 para feminino): ");
    int gen = scan.nextInt();

    System.out.print("Digite a sua altura em metros (ex: 1.85): ");
    double alt = scan.nextDouble();

        if (gen == 1) {
            double pesoIdeal = (72.7 * alt) - 58;
            System.out.println("O seu peso ideal é: " + pesoIdeal + " kg");
        } else if (gen == 2) {
            double pesoIdeal = (62.1 * alt) - 44.7;
            System.out.println("O seu peso ideal é: " + pesoIdeal + " kg");
            } else {
                System.out.println("Gênero inválido. Digite 1 para masculino ou 2 para feminino.");
                }
        scan.close();
    }
}
