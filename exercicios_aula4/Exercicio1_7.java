//Jepherson Silva de Sousa
import java.util.Scanner;
public class Exercicio1_7
{
 public static void main(String[] args) {
 
Scanner scan = new Scanner(System.in);

    System.out.print("Você é funcionário a quantos anos?: ");
    int ano = scan.nextInt();

    System.out.print("qual o seu salario?: ");
    double sal = scan.nextDouble();

        if (ano >= 5) {
            System.out.println("O seu bônus será de: "+ sal*0.2 );
        } else if (ano >=0 && ano <=4) {
            System.out.println("O seu bônus será de: "+ sal*0.1 );
            } else {
                System.out.println("Digite um numero de anos trabalhados igual ou superior a *0* ");
                }
    scan.close();
    }
}
