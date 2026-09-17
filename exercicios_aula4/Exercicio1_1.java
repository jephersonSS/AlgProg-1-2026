//Jepherson Silva de Sousa
import java.util.Scanner;
public class Exercicio1_1 {
 public static void main(String[] args) {
 
Scanner scan = new Scanner(System.in);

    
   
        System.out.print("digite um numero: ");
        int x = scan.nextInt();

        if(x >=20){
            System.out.println("a metade do seu numero é: " + (x/2));
        }
        scan.close();
    }
}
