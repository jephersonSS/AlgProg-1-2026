import java.util.Scanner;

public class ex3Aula5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

         System.out.println("Em qual periodo você estuda?");
            System.out.println("Matutino - digite (M)");
            System.out.println("Vespertino - digite (V)");
            System.out.println("Noturno - digite (N)");
            System.out.println("");
            String periodo = scan.nextLine();

            switch (periodo) {
                case "M":
                    System.out.println("Bom dia");
                    break;
                case "m":
                    System.out.println("Bom dia");
                    break;
                case "V":
                    System.out.println("Bom tarde");
                    break;
                case "v":
                    System.out.println("Bom tarde");
                    break;
                case "N":
                    System.out.println("Boa noite");
                    break;
                case "n":
                    System.out.println("Boa noite");
                    break;
            
                default:
                    break;
        }
        scan.close();
    }
}