import java.util.Scanner;

public class ex6Aula5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

           double totalGeral = 0.0;
            String continuar;

            do {
                System.out.println("\nCódigo    Produto           Preço");
                System.out.println("100        Cachorro Quente   R$1,20");
                System.out.println("101        Bauru Simples     R$1,30");
                System.out.println("102        Bauru com ovo     R$1,50");
                System.out.println("103        Hambúrguer        R$1,20");
                System.out.println("104        Cheeseburguer     R$1,30");
                System.out.println("105        Refrigerante      R$1,00");
                
                System.out.print("\nDigite o Código do produto: ");
                int produto1 = scan.nextInt();
                
                System.out.print("Digite a quantidade desejada: ");
                int quant1 = scan.nextInt();

                double subtotal = 0.0;

                switch (produto1) {
                    case 100:
                        subtotal = 1.20 * quant1;
                        System.out.printf("Item: %d x Cachorro Quente | Subtotal: R$ %.2f\n", quant1, subtotal);
                        break;
                    case 101:
                        subtotal = 1.30 * quant1;
                        System.out.printf("Item: %d x Bauru Simples | Subtotal: R$ %.2f\n", quant1, subtotal);
                        break;
                    case 102:
                        subtotal = 1.50 * quant1;
                        System.out.printf("Item: %d x Bauru com ovo | Subtotal: R$ %.2f\n", quant1, subtotal);
                        break;
                    case 103:
                        subtotal = 1.20 * quant1;
                        System.out.printf("Item: %d x Hambúrguer | Subtotal: R$ %.2f\n", quant1, subtotal);
                        break;
                    case 104:
                        subtotal = 1.30 * quant1;
                        System.out.printf("Item: %d x Cheeseburguer | Subtotal: R$ %.2f\n", quant1, subtotal);
                        break;
                    case 105:
                        subtotal = 1.00 * quant1;
                        System.out.printf("Item: %d x Refrigerante | Subtotal: R$ %.2f\n", quant1, subtotal);
                        break;
                    default:
                        System.out.println("Código inválido! Tente novamente.");
                        break;
                }

                totalGeral += subtotal;

              
                System.out.print("\nDeseja pedir mais alguma coisa? (S/N): ");
                continuar = scan.next();

            } while (continuar.equalsIgnoreCase("S"));

            System.out.println("\n----------------------------------");
            System.out.printf("Pedido finalizado! Total a pagar: R$ %.2f\n", totalGeral);
            System.out.println("----------------------------------");
            scan.close();
        }
        
    }
