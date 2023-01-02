import java.util.ArrayList;
import java.util.Scanner;

public class Stage1 {

    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<String> strings = new ArrayList<String>();

    public static void main(String[] args) {
        countMoney();
    }

    public static void countMoney() {
        while (scanner.hasNext()) {
            strings.add(scanner.nextLine());
        }
        strings.toArray();
        for (String list : strings) {
            System.out.println(list);
        }
        double sum = 0;
        for (String i : strings) {
            String[] amounts = i.split("\\$");

            for (int j = 1; j < amounts.length; j = j + 2) {
                double price = Double.parseDouble(amounts[j]);
                sum = sum + price;
                System.out.println();
            }
        }
        System.out.println("Total: $" + sum);
    }
}

