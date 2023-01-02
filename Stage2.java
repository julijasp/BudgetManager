import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Stage2 {

    public static Scanner scanner = new Scanner(System.in);
    public static Map<String, Double> purchases = new HashMap<String, Double>();
    public static double balance = 0;
    public static double productPrice = 0;
    public static double sum = 0;
    public static double roundSum = 0;

    public static void main(String[] args) {

        printMenu();
    }

    public static void addPurchase() {

        System.out.println();
        System.out.println("Enter purchase name:");
        scanner.nextLine();
        String productName = scanner.nextLine();

        System.out.println("Enter its price:");
        productPrice = scanner.nextDouble();
        purchases.put(productName, productPrice);
        System.out.println("Purchase was added!");
        System.out.println();
    }

    public static void printMenu() {
        int choice = -1;
        do {
            System.out.println("Choose your action:\n" +
                    "1) Add income\n" +
                    "2) Add purchase\n" +
                    "3) Show list of purchases\n" +
                    "4) Balance\n" +
                    "0) Exit");
            choice = scanner.nextInt();


            switch (choice) {
                case 1:
                    addIncome();
                    break;
                case 2:
                    addPurchase();
                    break;
                case 3:
                    printListOfPurchases();
                    break;
                case 4:
                    printBalance();
                    break;
                case 0:
                    System.out.println();
                    System.out.println("Bye!");
                    break;
            }

        } while (choice != 0);


    }

    public static void addIncome() {
        System.out.println();
        System.out.println("Enter income:");
        int income = scanner.nextInt();
        System.out.println("Income was added!");
        System.out.println();
        balance = balance + income;
    }

    public static void printListOfPurchases() {
        System.out.println();
        if (purchases.isEmpty()) {
            System.out.println("The purchase list is empty");
            System.out.println();
        } else {

            purchases.entrySet().forEach( entry -> {
                System.out.println( entry.getKey() + " $" + entry.getValue() );
                sum = purchases.values().stream().mapToDouble(Double::doubleValue).sum();
                roundSum = Math.round(sum*100)/100.f;
            });

            System.out.println("Total sum: $" + roundSum);
            System.out.println();
        }
    }

    public static void printBalance() {
        System.out.println();
        balance = balance - sum;
        System.out.println("Balance: $" + balance);
        System.out.println();
    }
}
