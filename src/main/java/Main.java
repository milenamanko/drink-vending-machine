import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ProductProvider.initializeProducts();

        String command;

        Scanner scanner = new Scanner(System.in);

        System.out.println("VENDING MACHINE. AVAILABLE DRINKS:");
        Command.checkAvailableProducts();

        while (scanner.hasNext()) {

            command = scanner.nextLine();

            if (command.equalsIgnoreCase("check products")) {
                Command.checkAvailableProducts();
            } else if (command.equalsIgnoreCase("exit")) {
                System.out.println("Bye!");
                break;
            } else System.out.println("Unknown command!");
        }
    }
}
