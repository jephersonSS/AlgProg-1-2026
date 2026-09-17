//Jepherson Silva de Sousa
import java.util.Scanner;
public class Exercicio1_12
 {
 public static void main(String[] args) {
 
Scanner scan = new Scanner(System.in);

     System.out.print("Digite o salário do funcionário: ");
        double sal = scan.nextDouble();
            if (sal <= 600) {
                System.out.println("Insento de desconto");
            }   else if (sal <= 1200) {
                    double des = sal * 0.2;
                    System.out.println("Desconto do inss de: " + des);
                 }  else if (sal <= 2000) {
                        double des = sal * 0.25;
                        System.out.println("Desconto do inss de: " + des);
                    }   else {
                            double des = sal * 0.3;
                            System.out.println("Desconto do inss de: " + des);
                        }
        scan.close();      
     }
            
}

