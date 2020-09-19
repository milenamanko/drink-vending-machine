import payment.MoneyInitializer;
import products.ProductProvider;

import java.util.Scanner;

public class VendingMachine {

    public static void main(String[] args) {

        ProductProvider.initializeProducts();
        MoneyInitializer.initializeMoney();

        String instruction;

        Scanner scanner = new Scanner(System.in);

        System.out.println("VENDING MACHINE. AVAILABLE DRINKS:");
        Instruction.checkAvailableProducts();

        while (scanner.hasNext()) {

            instruction = scanner.nextLine();

            if (instruction.equalsIgnoreCase("check products")) {
                Instruction.checkAvailableProducts();
            } else if (instruction.startsWith("buy")) {
                if (instruction.split(" ").length < 2) {
                    System.out.println("Please specify correct drink name");
                } else {
                    Instruction.buyDrink(instruction.substring(4));
                }
            } else if (instruction.equalsIgnoreCase("exit")) {
                System.out.println("Bye!");
                break;
            } else System.out.println("Please specify instruction");
        }
    }
}
