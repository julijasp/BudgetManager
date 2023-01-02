import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Stage3 {

    public static Scanner scanner = new Scanner(System.in);
    public static Map<String, Double> food = new HashMap<String, Double>();
    public static Map<String, Double> clothes = new HashMap<String, Double>();
    public static Map<String, Double> entertainment = new HashMap<String, Double>();
    public static Map<String, Double> other = new HashMap<String, Double>();
    public static Map<String, Double> allPurchases = new HashMap<String, Double>();
    public static double balance = 0;
    public static double productPrice = 0;
    public static String productName;
    public static int chooseCategory = -1;
    public static double sum = 0;
    public static double roundSum = 0;

    public static void main(String[] args) {

        printMenu();
    }

    public static void printMenu() {
        int choice = -1;
        do {
            System.out.println();
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
                    choosePurchaseCategory();
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
        balance = balance + income;
    }

    public static void printListOfPurchases() {
        if (food.isEmpty() && clothes.isEmpty() && entertainment.isEmpty() && other.isEmpty()) {
            System.out.println();
            System.out.println("The purchase list is empty!");

        } else {
            do {
                System.out.println();
                System.out.println("Choose the type of purchase:\n" + "1) Food\n" + "2) Clothes\n" + "3) Entertainment\n" + "4) Other\n" + "5) All\n" + "6) Back");
                chooseCategory = scanner.nextInt();

                if (chooseCategory == 1) {
                    if (food.isEmpty()) {
                        System.out.println("Food: \n" + "The purchase list is empty!");
                    } else {
                        System.out.println();
                        System.out.println("Food:");
                        food.entrySet().forEach(entry -> {
                            System.out.println(entry.getKey() + " $" + entry.getValue());
                            sum = food.values().stream().mapToDouble(Double::doubleValue).sum();
                        });

                        System.out.println("Total sum: $" + sum);

                    }
                }
                if (chooseCategory == 2) {
                    if (clothes.isEmpty()) {
                        System.out.println("Clothes:\n" + "The purchase list is empty!");

                    } else {
                        System.out.println();
                        System.out.println("Clothes:");
                        clothes.entrySet().forEach(entry -> {
                            System.out.println(entry.getKey() + " $" + entry.getValue());
                            sum = clothes.values().stream().mapToDouble(Double::doubleValue).sum();

                        });
                        System.out.println("Total sum: $" + sum);

                    }
                }
                if (chooseCategory == 3) {
                    if (entertainment.isEmpty()) {
                        System.out.println("Entertainment: \n" + "The purchase list is empty!");

                    } else {
                        System.out.println();
                        System.out.println("Entertainment:");
                        entertainment.entrySet().forEach(entry -> {
                            System.out.println(entry.getKey() + " $" + entry.getValue());
                            sum = entertainment.values().stream().mapToDouble(Double::doubleValue).sum();

                        });
                        System.out.println("Total sum: $" + sum);

                    }
                }
                if (chooseCategory == 4) {
                    if (other.isEmpty()) {
                        System.out.println("Other:\n" + "The purchase list is empty!");
                    } else {
                        System.out.println();
                        System.out.println("Other:");
                        other.entrySet().forEach(entry -> {
                            System.out.println(entry.getKey() + " $" + entry.getValue());
                            sum = other.values().stream().mapToDouble(Double::doubleValue).sum();

                        });
                        System.out.println("Total sum: $" + sum);
                    }
                }
                if (chooseCategory == 6) {
                    break;
                }
                if (chooseCategory == 5) {
                    System.out.println();
                    System.out.println("All:");
                    allPurchases.entrySet().forEach(entry -> {
                        System.out.println(entry.getKey() + " $" + entry.getValue());
                        sum = allPurchases.values().stream().mapToDouble(Double::doubleValue).sum();
                    });
                    System.out.println("Total sum: $" + sum);
                }
            } while (chooseCategory != 0);
        }
    }

    public static void printBalance() {
        System.out.println();
        balance = balance - sum;
        System.out.println("Balance: $" + balance);
        System.out.println();
    }

    public static void choosePurchaseCategory() {
        do {
            System.out.println();
            System.out.println("Choose the type of purchase:\n" + "1) Food\n" + "2) Clothes\n" + "3) Entertainment\n" + "4) Other\n" + "5) Back");
            chooseCategory = scanner.nextInt();

            if (chooseCategory == 1) {
                buyProduct();
                food.put(productName, productPrice);

            }
            if (chooseCategory == 2) {
                buyProduct();
                clothes.put(productName, productPrice);

            }
            if (chooseCategory == 3) {
                buyProduct();
                entertainment.put(productName, productPrice);

            }
            if (chooseCategory == 4) {
                buyProduct();
                other.put(productName, productPrice);

            }
            if (chooseCategory == 5) {
                break;
            }
        allPurchases.put(productName, productPrice);

        } while (chooseCategory != 0);
    }

    public static void buyProduct() {
        System.out.println();
        System.out.println("Enter purchase name:");
        scanner.nextLine();
        productName = scanner.nextLine();

        System.out.println("Enter its price:");
        productPrice = scanner.nextDouble();

        System.out.println("Purchase was added!");
    }
}

