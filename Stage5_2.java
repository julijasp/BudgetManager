import java.io.*;
import java.util.*;


public class Stage5_2 {

    public static Scanner scanner = new Scanner(System.in);
    public static Map<String, Double> food = new LinkedHashMap<String, Double>();
    public static Map<String, Double> clothes = new LinkedHashMap<String, Double>();
    public static Map<String, Double> entertainment = new LinkedHashMap<String, Double>();
    public static Map<String, Double> other = new LinkedHashMap<String, Double>();
    public static Map<String, Double> allPurchases = new LinkedHashMap<String, Double>();
    public static ArrayList<Integer> categories = new ArrayList<Integer>();
    public static ArrayList<Double> costs = new ArrayList<Double>();
    public static Double balance = 0.00d;
    public static Double productPrice;
    public static Double newProductPrice;
    public static Double income = 0.00d;
    public static String productName;
    public static Double totalCosts = 0.00d;

    public static int chooseCategory = -1;
    public static double sum = 0;

    public static int choice = -1;


    public static void main(String[] args) throws IOException {

        printMenu();
    }

    public static void printMenu() throws IOException {
        System.out.println();

        do {
            System.out.println("Choose your action:\n" +
                    "1) Add income\n" +
                    "2) Add purchase\n" +
                    "3) Show list of purchases\n" +
                    "4) Balance\n" +
                    "5) Save\n" +
                    "6) Load\n" +
                    "7) Analyze (Sort)\n" +
                    "0) Exit");
            choice = scanner.nextInt();
            System.out.println();


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
                    System.out.println("Bye!");
                    break;
                case 7:
                    analyze();
                    break;
            }
        } while (choice != 0);
    }


    public static void addIncome() {
        //System.out.println();
        System.out.println("Enter income:");
        income = scanner.nextDouble();
        System.out.println("Income was added!");
        System.out.println();
        balance = balance + income;
    }

    public static void printListOfPurchases() {
        if (allPurchases.isEmpty()) {
            System.out.println();
            System.out.println("The purchase list is empty!");
            System.out.println();

        } else {
            do {
                System.out.println();
                System.out.println("Choose the type of purchase:\n" + "1) Food\n" + "2) Clothes\n" + "3) Entertainment\n" + "4) Other\n" + "5) All\n" + "6) Back");
                chooseCategory = scanner.nextInt();

                if (chooseCategory == 1) {
                    if (food.isEmpty()) {
                        System.out.println("Food: \n" + "The purchase list is empty!");
                        System.out.println();
                    } else {
                        System.out.println();
                        System.out.println("Food:");
                        food.entrySet().forEach(entry -> {
                            System.out.println(entry.getKey() + " $" + String.format("%.2f", entry.getValue()));
                        });
                        sum = food.values().stream().mapToDouble(num -> (num)).sum();
                        System.out.println("Total sum: $" + String.format("%.2f", sum));
                    }
                }
                if (chooseCategory == 2) {
                    if (clothes.isEmpty()) {
                        System.out.println("Clothes:\n" + "The purchase list is empty!");
                        System.out.println();

                    } else {
                        System.out.println();
                        System.out.println("Clothes:");
                        clothes.entrySet().forEach(entry -> {
                            System.out.println(entry.getKey() + " $" + String.format("%.2f", entry.getValue()));
                            sum = clothes.values().stream().mapToDouble(num -> (num)).sum();

                        });
                        System.out.println("Total sum: $" + String.format("%.2f", sum));
                        System.out.println();

                    }
                }
                if (chooseCategory == 3) {
                    if (entertainment.isEmpty()) {
                        System.out.println("Entertainment: \n" + "The purchase list is empty!");
                        System.out.println();

                    } else {
                        System.out.println();
                        System.out.println("Entertainment:");
                        entertainment.entrySet().forEach(entry -> {
                            System.out.println(entry.getKey() + " $" + String.format("%.2f", entry.getValue()));
                            sum = entertainment.values().stream().mapToDouble(num -> (num)).sum();

                        });
                        System.out.println("Total sum: $" + String.format("%.2f", sum));
                        System.out.println();
                    }
                }
                if (chooseCategory == 4) {
                    if (other.isEmpty()) {
                        System.out.println("Other:\n" + "The purchase list is empty!");
                        System.out.println();
                    } else {
                        System.out.println();
                        System.out.println("Other:");
                        other.entrySet().forEach(entry -> {
                            System.out.println(entry.getKey() + " $" + String.format("%.2f", entry.getValue()));
                            sum = other.values().stream().mapToDouble(num -> (num)).sum();

                        });
                        System.out.println("Total sum: $" + String.format("%.2f", sum));
                        System.out.println();
                    }
                }
                if (chooseCategory == 6) {
                    System.out.println();
                    break;
                }
                if (chooseCategory == 5) {
                    System.out.println();
                    System.out.println("All:");
                    allPurchases.entrySet().forEach(entry -> {
                        System.out.println(entry.getKey() + " $" + String.format("%.2f", entry.getValue()));
                        sum = allPurchases.values().stream().mapToDouble(num -> (num)).sum();
                    });
                    System.out.println("Total sum: $" + String.format("%.2f", sum));
                }
            } while (chooseCategory != 0);
        }
    }

    public static double printBalance() {
        // System.out.println();
        System.out.println("Balance: $" + String.format("%.2f", balance));
        System.out.println();
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
                food.put(productName, Double.valueOf(newProductPrice));

            }
            if (chooseCategory == 2) {
                buyProduct();
                clothes.put(productName, Double.valueOf(newProductPrice));

            }
            if (chooseCategory == 3) {
                buyProduct();
                entertainment.put(productName, Double.valueOf(newProductPrice));

            }
            if (chooseCategory == 4) {
                buyProduct();
                other.put(productName, Double.valueOf(newProductPrice));

            }
            if (chooseCategory == 5) {
                break;
            }
            allPurchases.put(productName, Double.valueOf(newProductPrice));
            totalCosts = allPurchases.values().stream().mapToDouble(num -> (num)).sum();
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
        newProductPrice = Double.valueOf(String.format("%.2f", productPrice));
        costs.add(newProductPrice);
        System.out.println("Purchase was added!");
        System.out.println();
    }

    public static void savePurchases() throws IOException {
        File purchases = new File("C:/Users/Julija/Documents/purchases.txt");
        FileWriter writer = new FileWriter(purchases);
        Double saveBalance = Double.valueOf(String.format("%.2f", balance));
        writer.write(String.valueOf(saveBalance));
        writer.write("\n");
        writer.write(String.valueOf(categories));
        writer.write("\n");
        writer.write(String.valueOf(allPurchases.values()));
        writer.write(String.valueOf(allPurchases.keySet()));
        System.out.println();
        System.out.println("Purchases were saved!");
        System.out.println();
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
                        Double newKey = Double.parseDouble(s);
                        keys.add(String.valueOf(newKey));
                    }

                    for (String s : tempValues) {
                        values.add(s.trim());
                    }

                    for (int i = 0; i < categories.length; i++) {
                        if (categories[i].equals("1")) {
                            food.put(values.get(i), Double.valueOf(String.valueOf(keys.get(i))));
                        }
                        if (categories[i].equals("2")) {
                            clothes.put(values.get(i), Double.valueOf(String.valueOf(keys.get(i))));
                        }
                        if (categories[i].equals("3")) {
                            entertainment.put(values.get(i), Double.valueOf(String.valueOf(keys.get(i))));
                        }
                        if (categories[i].equals("4")) {
                            other.put(values.get(i), Double.valueOf(String.valueOf(keys.get(i))));
                        }
                        allPurchases.put(values.get(i), Double.valueOf(keys.get(i)));

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
        // System.out.println();
        System.out.println("Purchases were loaded!");
        System.out.println();
    }

    public static void analyze() {
        do {
            // System.out.println();
            System.out.println("How do you want to sort?\n" +
                    "1) Sort all purchases\n" +
                    "2) Sort by type\n" +
                    "3) Sort certain type\n" +
                    "4) Back");
            chooseCategory = scanner.nextInt();

            double sumFood = food.values().stream().mapToDouble(num -> (num)).sum();
            double sumClothes = clothes.values().stream().mapToDouble(num -> (num)).sum();
            double sumEntertainment = entertainment.values().stream().mapToDouble(num -> (num)).sum();
            double sumOther = other.values().stream().mapToDouble(num -> (num)).sum();
            double sumAll = allPurchases.values().stream().mapToDouble(num -> (num)).sum();

            double[] ints = {sumFood, sumClothes, sumEntertainment, sumOther};
            Arrays.sort(ints);

            switch (chooseCategory) {
                case 1:
                    if (allPurchases.isEmpty()) {
                        System.out.println();
                        System.out.println("The purchase list is empty!");
                        System.out.println();

                    } else {
                        System.out.println();
                        LinkedHashMap<String, Double> reverseSortedMap = new LinkedHashMap<>();
                        allPurchases.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
                        System.out.println("All:");
                        reverseSortedMap.entrySet().forEach(entry -> {
                            System.out.println(entry.getKey() + " $" + String.format("%.2f", entry.getValue()));
                        });
                        System.out.println("Total: $" + String.format("%.2f", sumAll));
                        System.out.println();

                    }

                    break;
                case 2:
                    System.out.println();
                    System.out.println("Types:");
                    if (allPurchases.isEmpty()) {
                        System.out.println("Food - $0\n" +
                                "Entertainment - $0\n" +
                                "Clothes - $0\n" +
                                "Other - $0\n" +
                         "Total sum: $0");
                        System.out.println();
                    } else {
                        String food = "Food - $";
                        String entertainment = "Entertainment - $";
                        String clothes = "Clothes - $";
                        String other = "Other - $";

                        Map<String, Double> purchases = new LinkedHashMap<String, Double>();
                        purchases.put(food, sumFood);
                        purchases.put(entertainment, sumEntertainment);
                        purchases.put(clothes, sumClothes);
                        purchases.put(other, sumOther);
                        LinkedHashMap<String, Double> reverseSortedMap5 = new LinkedHashMap<>();
                        purchases.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                                .forEachOrdered(x -> reverseSortedMap5.put(x.getKey(), x.getValue()));
                        reverseSortedMap5.entrySet().forEach(entry -> {
                            System.out.println(entry.getKey() + String.format("%.2f", entry.getValue()));
                        });

                        System.out.println("Total sum: $" + String.format("%.2f", sumAll));
                        System.out.println();

                    }
                    break;
                case 3:
                    System.out.println();
                    System.out.println("Choose the type of purchase\n" +
                            "1) Food\n" +
                            "2) Clothes\n" +
                            "3) Entertainment\n" +
                            "4) Other");
                    int chooseCategory1 = scanner.nextInt();
                    if (allPurchases.isEmpty()) {
                        System.out.println();
                        System.out.println("The purchase list is empty!");

                    } else {

                        switch (chooseCategory1) {
                            case 1:
                                System.out.println("");
                                System.out.println("Food:");
                                LinkedHashMap<String, Double> reverseSortedMap4 = new LinkedHashMap<>();
                                food.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                                        .forEachOrdered(x -> reverseSortedMap4.put(x.getKey(), x.getValue()));
                                reverseSortedMap4.entrySet().forEach(entry -> {
                                    System.out.println(entry.getKey() + " $" + String.format("%.2f", entry.getValue()));
                                });
                                System.out.println("Total sum: $" + String.format("%.2f", sumFood));

                                break;
                            case 2:
                                System.out.println();
                                System.out.println("Clothes:");
                                LinkedHashMap<String, Double> reverseSortedMap1 = new LinkedHashMap<>();
                                clothes.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                                        .forEachOrdered(x -> reverseSortedMap1.put(x.getKey(), x.getValue()));
                                reverseSortedMap1.entrySet().forEach(entry -> {
                                    System.out.println(entry.getKey() + " $" + String.format("%.2f", entry.getValue()));
                                });
                                System.out.println("Total sum: $" + String.format("%.2f", sumClothes));

                                break;
                            case 3:
                                System.out.println();
                                System.out.println("Entertainment:");
                                LinkedHashMap<String, Double> reverseSortedMap2 = new LinkedHashMap<>();
                                entertainment.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                                        .forEachOrdered(x -> reverseSortedMap2.put(x.getKey(), x.getValue()));
                                reverseSortedMap2.entrySet().forEach(entry -> {
                                    System.out.println(entry.getKey() + " $" + String.format("%.2f", entry.getValue()));
                                });
                                System.out.println("Total sum: $" + String.format("%.2f", sumEntertainment));

                                break;
                            case 4:
                                System.out.println();
                                System.out.println("Other:");
                                LinkedHashMap<String, Double> reverseSortedMap3 = new LinkedHashMap<>();
                                other.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                                        .forEachOrdered(x -> reverseSortedMap3.put(x.getKey(), x.getValue()));
                                reverseSortedMap3.entrySet().forEach(entry -> {
                                    System.out.println(entry.getKey() + " $" + String.format("%.2f", entry.getValue()));
                                });
                                System.out.println("Total sum: $" + String.format("%.2f", sumOther));

                                break;
                        }
                    }
                case 4:
                    System.out.println();
                    //break;
            }
        } while (chooseCategory != 4);
    }
}
