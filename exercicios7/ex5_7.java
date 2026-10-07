import java.util.Scanner;

public class ex5_7 {

    public static void main(String[] args) {
       Scanner ent = new Scanner(System.in);
            int repovado = 0;
            int exame = 0;
            int aprovado = 0;
            double somaMediasTurma = 0;

            for (int i = 0; i < 6; i++) {
                System.out.println("Digite a primeira nota do " + (i + 1) + "º aluno:");
                double nota1 = ent.nextDouble();
                System.out.println("Digite a segunda nota do " + (i + 1) + "º aluno:");
                double nota2 = ent.nextDouble();

                double mediaAluno = (nota1 + nota2) / 2.0;
                somaMediasTurma += mediaAluno;

                if (mediaAluno <= 3) {
                    System.out.println("O aluno foi REPROVADO");
                    repovado++;
                } else if (mediaAluno > 3 && mediaAluno < 7) {
                    System.out.println("O aluno em EXAME");
                    exame++;
                } else {
                    System.out.println("O aluno foi APROVADO");
                    aprovado++;
                }
                System.out.println();
            }

            System.out.println("Total de alunos Aprovados: " + aprovado);
            System.out.println("Total de alunos de exame: " + exame);
            System.out.println("Total de alunos reprovados: " + repovado);
            System.out.printf("Média da turma: %.2f%n", (somaMediasTurma / 6.0));
         ent.close();
    }
}