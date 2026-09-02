import java.util.Scanner;

public class SeusLivros{
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Cadastre seus 5 livros favoritos\n");

        System.out.print("digite seu livro favorito 1: ");
        String livro1 = entrada.nextLine();

        System.out.print("digite seu livro favorito 2: ");
        String livro2 = entrada.nextLine();

        System.out.print("digite seu livro favorito 3: ");
        String livro3 = entrada.nextLine();

        System.out.print("digite seu livro favorito 4: ");
        String livro4 = entrada.nextLine();

        System.out.print("digite seu livro favorito 5: ");
        String livro5 = entrada.nextLine();

        System.out.println("\nSeus livros favoritos são: ");
        System.out.println("1. " + livro1);
        System.out.println("2. " + livro2);
        System.out.println("3. " + livro3);
        System.out.println("4. " + livro4);
        System.out.println("5. " + livro5);

        entrada.close();
    }
}