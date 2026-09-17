//Jepherson Silva de Sousa
import java.util.Scanner;
public class Exercicio1_8
 {
 public static void main(String[] args) {
 
Scanner scan = new Scanner(System.in);

    System.out.print("Insira a senha do usuário: ");
        String sen = scan.nextLine();

    

        if (sen.equals("R10p5")) {
            System.out.println("acesso concedido" );
        } else {
                System.out.println("acesso negado ");
                }
    scan.close();
    }
}
