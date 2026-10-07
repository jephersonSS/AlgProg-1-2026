import java.util.Scanner;
public class ex8_6 {

    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
            int i = 0;

            while (i < 5) {
                double nota1;
                double nota2;
                do {
                    System.out.println("Digite a primeira nota do " + (i + 1) + "º aluno (0 a 10):");
                    nota1 = ent.nextDouble();
                    
                    if (nota1 < 0 || nota1 > 10) {
                        System.out.println("Nota inválida! Digite um valor entre 0 e 10");
                    }
                } while (nota1 < 0 || nota1 > 10);

                do {
                    System.out.println("Digite a segunda nota do " + (i + 1) + "º aluno (0 a 10):");
                    nota2 = ent.nextDouble();

                    if (nota2 < 0 || nota2 > 10) {
                        System.out.println("Nota inválida! Digite um valor entre 0 e 10");
                    }
                } while (nota2 < 0 || nota2 > 10);

                double media = (nota1 + nota2) / 2;
                System.out.println("A média do " + (i + 1) + "º aluno é de: " + media);

                i++;
            }
        ent.close();
    }
}