import java.util.Scanner;

public class ex7_6 {
    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
            int i = 0;
            int cont = 0;
            System.out.println("Esse codigo calcula o IMC (índice de Massa Corporal) de 10 pessoas ");
            while (i<10){
                System.out.println("Digite a altura em metros da "+(i+1)+"º pessoa ");
                double altura = ent.nextDouble();

                System.out.println("Digite peso em kilos da "+(i+1)+"º pessoa ");
                double peso = ent.nextDouble();
                
                double imc = peso/(altura*altura);

                if (imc >= 18.5 && imc <= 24.9){
                    cont++;
                }
                i++;
            }
            System.out.println(cont + " pessoa(s) então com o peso que é considerado sem obesidade");
        ent.close();
    }
}