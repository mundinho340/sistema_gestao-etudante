import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nome -> ");
        String nome = scanner.next();

        System.out.println("O seu nome é "+nome);
    }
}
