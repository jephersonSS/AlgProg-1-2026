import java.util.Scanner;

public class ex4Aula5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

          System.out.println("Qual seu plano de trabalho (A, B, C)");
            String planoDeTrabalho = scan.nextLine();

            System.out.println("Digite seu salario atual");
            double salario = scan.nextDouble();

            switch (planoDeTrabalho) {
                case "A":
                    System.out.println("Seu novo salario é: " + (salario + salario * 0.10));
                    break;
                case "a":
                    System.out.println("Seu novo salario é: " + (salario + salario * 0.10));
                    break;
                case "B":
                    System.out.println("Seu novo salario é: " + (salario + salario * 0.15));
                    break;
                case "b":
                    System.out.println("Seu novo salario é: " + (salario + salario * 0.15));
                    break;
                case "C":
                    System.out.println("Seu novo salario é: " + (salario + salario * 0.20));
                    break;
                case "c":
                    System.out.println("Seu novo salario é: " + (salario + salario * 0.20));
                    break;
                default:
                    System.out.println("Você errou alguma coisa tente novamente");
        }
        scan.close();
    }
}