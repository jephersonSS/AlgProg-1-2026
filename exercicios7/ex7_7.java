import java.util.Scanner;

public class ex7_7 {

    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
            int qtdMaior50 = 0;
            int qtd10a20 = 0;
            double somaAltura10a20 = 0;
            int qtdPesoMenor40 = 0;

            for (int i = 0; i < 10; i++) {
                System.out.println("Pessoa " + (i + 1) + ":");
                System.out.print("Digite a idade: ");
                int idade = ent.nextInt();

                System.out.print("Digite a altura (ex: 1.75): ");
                double altura = ent.nextDouble();

                System.out.print("Digite o peso (kg): ");
                double peso = ent.nextDouble();

                if (idade > 50) {
                    qtdMaior50++;
                } else if (peso < 40) {
                    qtdPesoMenor40++;
                } else if (idade >= 10 && idade <= 20) {
                    somaAltura10a20 += altura;
                    qtd10a20++;
                }

                System.out.println();
            }

            System.out.println("--- RESULTADOS ---");
            System.out.println("Quantidade de pessoas maiores de 50 anos: " + qtdMaior50);

            if (qtd10a20 > 0) {
                double mediaAltura = somaAltura10a20 / qtd10a20;
                System.out.printf("Média das alturas (10 a 20 anos): %.2fm%n", mediaAltura);
            } else {
                System.out.println("Nenhuma pessoa com idade entre 10 e 20 anos foi cadastrada.");
            }

            double porcentagemPeso = (qtdPesoMenor40 / 10.0) * 100;
            System.out.printf("Porcentagem com peso inferior a 40kg: %.2f%%%n", porcentagemPeso);
         ent.close();
    }
}