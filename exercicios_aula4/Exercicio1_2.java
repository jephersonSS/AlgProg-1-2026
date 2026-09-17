//Jepherson Silva de Sousa
import java.util.Scanner;
public class Exercicio1_2 {
 public static void main(String[] args) {
 
Scanner scan = new Scanner(System.in);

    
   
        System.out.print("digite um numero: ");
        int x = scan.nextInt();

        if(x >=18){
            System.out.println("Maior de idade");
        }
    else{
           System.out.println("Menor de idade"); 
        }
        scan.close();
    }
}
