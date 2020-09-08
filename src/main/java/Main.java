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
            } else if (command.startsWith("buy")) {
                if (command.split(" ").length < 2) {
                    System.out.println("Please specify correct drink name");
                } else {
                    Command.buyDrink(command.substring(4));
                }
            } else if (command.equalsIgnoreCase("exit")) {
                System.out.println("Bye!");
                break;
            } else System.out.println("Unknown command!");
        }
    }
}
