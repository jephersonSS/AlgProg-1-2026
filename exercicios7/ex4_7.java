import java.util.Scanner;

public class ex4_7 {
    public static void main(String[] args) {

        Scanner ent = new Scanner(System.in);

        int cont = 0;
        double mediaAltura = 0;

        for (int i = 1; i <= 10; i++) {

            System.out.println("Digite a idade da " + i + "ª pessoa:");
            int idade = ent.nextInt();

            System.out.println("Digite a altura da " + i + "ª pessoa:");
            double altura = ent.nextDouble();

            if (idade > 50) {
                cont++;
                mediaAltura += altura;
            }
        }

        if (cont > 0) {
            mediaAltura = mediaAltura / cont;
            System.out.printf("A média das alturas daquelas com mais de 50 anos: %.2f%n", mediaAltura);
        } else {
            System.out.println("Nenhuma pessoa tem mais de 50 anos.");
        }

        ent.close();
    }
}