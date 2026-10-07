import java.util.Scanner;

public class ex6_7 {
    public static void main(String[] args) {
      Scanner ent = new Scanner(System.in);
            int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
            int votosNulo = 0;
            int votosBranco = 0;

            for (int i = 0; i < 10; i++) {
                System.out.println("Eleitor " + (i + 1) + " - Digite seu voto (1 a 4: Candidatos | 5: Nulo | 6: Branco):");
                int voto = ent.nextInt();

                if (voto == 1) {
                    c1++;
                } else if (voto == 2) {
                    c2++;
                } else if (voto == 3) {
                    c3++;
                } else if (voto == 4) {
                    c4++;
                } else if (voto == 5) {
                    votosNulo++;
                } else if (voto == 6) {
                    votosBranco++;
                } else {
                    System.out.println("Voto inválido! Não será contabilizado.");
                    
                }
                System.out.println();
            }

            double percentualNulosEBrancos = ((votosNulo + votosBranco) / 10.0) * 100;

            System.out.println("--- RESULTADO DA ELEIÇÃO ---");
            System.out.println("Total Candidato 1: " + c1);
            System.out.println("Total Candidato 2: " + c2);
            System.out.println("Total Candidato 3: " + c3);
            System.out.println("Total Candidato 4: " + c4);
            System.out.println("Total Votos Nulos: " + votosNulo);
            System.out.println("Total Votos em Branco: " + votosBranco);
            System.out.printf("Percentual de votos nulos e brancos: %.2f%%%n", percentualNulosEBrancos);
         ent.close();
    }
}