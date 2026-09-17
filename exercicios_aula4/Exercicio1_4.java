//Jepherson Silva de Sousa
import java.util.Scanner;
public class Exercicio1_4 {
 public static void main(String[] args) {
 
Scanner scan = new Scanner(System.in);

        System.out.print("digite um numero: ");
        float x = scan.nextFloat();
        System.out.print("digite outro numero: ");
        float y = scan.nextFloat();

        if(x > y){
            System.out.println("os numeros são: "+ x +" e "+y);
        }
    else if(x < y){
           System.out.println("os numeros são: "+ y +" e "+x);
        }
        scan.close();
    }
}
