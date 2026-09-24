import java.util.Scanner;

public class ex5Aula5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

           System.out.println("Qual operação você deseja? ");
            System.out.println("Media - digite (M)");
            System.out.println("Diferença do maior para o menor - digite (S)");
            System.out.println("Produto entre os numeros - digite (P)");
            System.out.println("Divisão do primeiro pelo segundo - digite (D)");
            System.out.print("Digite qual operação você dejase: ");
            String operacao = scan.nextLine();


            System.out.print("Digite o primeiro numero: ");
            double n1 = scan.nextDouble();
            System.out.print("Digite o segundo numero: ");
            double n2 = scan.nextDouble();
            switch (operacao) {
                case "M":
                    System.out.println("A media é: " + ((n1 + n2) / 2));
                    break;
                case "S":
                    if (n1 > n2) {
                        System.out.println("A diferença deles é: " + (n1 - n2));
                    } else if (n2 > n1) {
                        System.out.println("A diferença deles é: " + (n2 - n1));
                    }
                    break;
                case "P":
                    System.out.println("O produto deles é: " + (n1 * n2));
                    break;
                case "D":
                    System.out.println("Divisão do primeiro numero pelo segundo: " + (n1 / n2));
                    break;
                case "m":
                    System.out.println("A media é: " + ((n1 + n2) / 2));
                    break;
                case "s":
                    if (n1 > n2) {
                        System.out.println("A diferença deles é: " + (n1 - n2));
                    } else if (n2 > n1) {
                        System.out.println("A diferença deles é: " + (n2 - n1));
                    }
                    break;
                case "p":
                    System.out.println("O produto deles é: " + (n1 * n2));
                    break;
                case "d":
                    System.out.println("Divisão do primeiro numero pelo segundo: " + (n1 / n2));
                    break;
                default:
                    System.out.println("Você errou alguma coisa tente novamente");
        }
        scan.close();
    }
}