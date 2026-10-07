import java.util.Scanner;
public class ex6_6 {
    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
            int i = 1;

            System.out.println("Digite o 1º número inteiro");
            int menor = ent.nextInt();

            while (i<10) {
               System.out.println("Digite o " + (i + 1) + "º número inteiro");
               int num = ent.nextInt();
               if( menor > num){
                menor = num;
               }
                i++;
            }
        System.out.println("O menor numero é: " + menor);
    ent.close();
        }
}