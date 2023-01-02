import java.io.*;
import java.util.*;


public class Stage4 {

    public static Scanner scanner = new Scanner(System.in);
    public static Map<String, String> food = new LinkedHashMap<String, String>();
    public static Map<String, String> clothes = new LinkedHashMap<String, String>();
    public static Map<String, String> entertainment = new LinkedHashMap<String, String>();
    public static Map<String, String> other = new LinkedHashMap<String, String>();
    public static Map<String, String> allPurchases = new LinkedHashMap<String, String>();
    public static ArrayList<Integer> categories = new ArrayList<Integer>();
    public static ArrayList<Double> costs = new ArrayList<Double>();
    public static double balance = 0;
    public static Double productPrice;
    public static String newProductPrice;
    public static double income = 0;
    public static String productName;
    public static double totalCosts = 0;

    public static int chooseCategory = -1;
    public static double sum = 0;

    public static int choice = -1;


    public static void main(String[] args) throws IOException {

        printMenu();
    }

    public static void printMenu() throws IOException {

        do {
            System.out.println();
            System.out.println("Choose your action:\n" +
                    "1) Add income\n" +
                    "2) Add purchase\n" +
                    "3) Show list of purchases\n" +
                    "4) Balance\n" +
                    "5) Save\n" +
                    "6) Load\n" +
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
                case 5:
                    savePurchases();
                    break;
                case 6:
                    loadPurchases();
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
        income = scanner.nextInt();
        System.out.println("Income was added!");
        balance = balance + income;
    }

    public static void printListOfPurchases() {
        if (allPurchases.isEmpty()) {
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
                        });
                        sum = food.values().stream().mapToDouble(num -> Double.parseDouble(num)).sum();
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
                            sum = clothes.values().stream().mapToDouble(num -> Double.parseDouble(num)).sum();

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
                            sum = entertainment.values().stream().mapToDouble(num -> Double.parseDouble(num)).sum();

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
                            sum = other.values().stream().mapToDouble(num -> Double.parseDouble(num)).sum();

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
                        sum = allPurchases.values().stream().mapToDouble(num -> Double.parseDouble(num)).sum();
                    });
                    System.out.println("Total sum: $" + sum);
                }
            } while (chooseCategory != 0);
        }
    }

    public static double printBalance() {
        System.out.println();
        Formatter formatter = new Formatter();
        formatter.format("%.2f", balance);
        System.out.println("Balance: $" + formatter.toString());
        return balance;
    }

    public static void choosePurchaseCategory() {
        do {
            System.out.println();
            System.out.println("Choose the type of purchase:\n" + "1) Food\n" + "2) Clothes\n" + "3) Entertainment\n" + "4) Other\n" + "5) Back");
            chooseCategory = scanner.nextInt();
            categories.add(chooseCategory);

            if (chooseCategory == 1) {
                buyProduct();
                food.put(productName, newProductPrice);

            }
            if (chooseCategory == 2) {
                buyProduct();
                clothes.put(productName, newProductPrice);

            }
            if (chooseCategory == 3) {
                buyProduct();
                entertainment.put(productName, newProductPrice);

            }
            if (chooseCategory == 4) {
                buyProduct();
                other.put(productName, newProductPrice);

            }
            if (chooseCategory == 5) {
                break;
            }
            allPurchases.put(productName, newProductPrice);
            totalCosts = allPurchases.values().stream().mapToDouble(num -> Double.parseDouble(num)).sum();
            balance = income - totalCosts;
        } while (chooseCategory != 0);
    }

    public static void buyProduct() {
        System.out.println();
        System.out.println("Enter purchase name:");
        scanner.nextLine();
        productName = scanner.nextLine();
        System.out.println("Enter its price:");
        productPrice = scanner.nextDouble();
        Formatter formatter = new Formatter();
        formatter.format("%.2f", productPrice);
        newProductPrice = formatter.toString();
        costs.add(Double.valueOf(newProductPrice));
        System.out.println("Purchase was added!");
    }

    public static void savePurchases() throws IOException {
        File purchases = new File("C:/Users/Julija/Documents/purchases.txt");
        FileWriter writer = new FileWriter(purchases);
        Formatter formatter = new Formatter();
        formatter.format("%.2f", balance);
        String saveBalance = formatter.toString();
        writer.write(String.valueOf(saveBalance));
        writer.write("\n");
        writer.write(String.valueOf(categories));
        writer.write("\n");
        writer.write(String.valueOf(allPurchases.values()));
        writer.write(String.valueOf(allPurchases.keySet()));
        System.out.println();
        System.out.println("Purchases were saved!");
        writer.close();
    }

    public static void loadPurchases() {
        String line, value = null;
        Double key = null;
        String[] categories = new String[0];
        ArrayList<String> values = new ArrayList<String>();
        ArrayList<String> keys = new ArrayList<String>();
        int x = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Julija/Documents/purchases.txt"))) {
            while ((line = reader.readLine()) != null) {
                if (x == 1) {
                    String categoriesFromLine = line.substring(1, line.length() - 1);
                    String[] tempCategories = categoriesFromLine.split(", ");
                    categories = Arrays.copyOf(tempCategories, tempCategories.length - 1);
                    for (String str : categories) {
                        chooseCategory = Integer.parseInt(str);
                    }
                } else if (x == 0) {
                    balance = Double.parseDouble(line);
                    Formatter formatter = new Formatter();
                    formatter.format("%.2f", balance);
                    balance = Double.parseDouble(formatter.toString());
                } else if (x == 2) {
                    line = line.substring(1, line.length() - 1);
                    String[] keyValuePair = line.split("\\]\\[", 2);
                    String[] tempKeys = keyValuePair[0].split(",");
                    String[] tempValues = keyValuePair[1].split(",");
                    for (String s : tempKeys) {
                        key = Double.parseDouble(s);
                        Formatter formatter = new Formatter();
                        formatter.format("%.2f", key);
                        String newKey = formatter.toString();
                        keys.add(newKey);
                    }
                    for (String s : tempValues) {
                        values.add(s.trim());
                    }
                    for (int i = 0; i < categories.length; i++) {
                        if (categories[i].equals("1")) {
                            food.put(values.get(i), String.valueOf(keys.get(i)));
                        }
                        if (categories[i].equals("2")) {
                            clothes.put(values.get(i), String.valueOf(keys.get(i)));
                        }
                        if (categories[i].equals("3")) {
                            entertainment.put(values.get(i), String.valueOf(keys.get(i)));
                        }
                        if (categories[i].equals("4")) {
                            other.put(values.get(i), String.valueOf(keys.get(i)));
                        }
                        allPurchases.put(values.get(i), String.valueOf(keys.get(i)));
                    }
                }
                x++;
                if (x == 3) {
                    x = 0;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        System.out.println("Purchases were loaded!");
    }
}