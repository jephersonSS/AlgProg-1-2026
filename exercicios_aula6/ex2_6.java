import java.util.Scanner;

public class ex2_6 {
    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
            int cont = 0;
            int par = 0;
            int impar = 0;
            while (cont < 10) {
                System.out.println("Digite o " + (cont + 1) + "º número");
                int num = ent.nextInt();
                if (num % 2 == 0) {
                    par++;
                } else {
                    impar++;
                }
                cont++;
            
            System.out.println("Quantidade de numeros pares: " + par);
            System.out.println("Quantidade de numeros ímpares: " + impar);
        }
        ent.close();
    }
}