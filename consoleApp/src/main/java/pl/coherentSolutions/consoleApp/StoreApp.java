package pl.coherentSolutions.consoleApp;

import pl.coherentSolutions.products.Product;
import pl.coherentSolutions.store.Store;
import pl.coherentSolutions.store.utils.SortHelper;
import pl.coherentSolutions.store.utils.StoreHelper;

import java.util.List;
import java.util.Scanner;

public class StoreApp {
    public static void main(String[] args) {
        Store store = new Store();
        StoreHelper helper = new StoreHelper(store);
        SortHelper sortHelper = new SortHelper(store);
        helper.fillStoreRandomly();

        System.out.println("Welcome to online store\nCommands:\nsort\ntop\nquit\nEnter command:");
        Boolean flag = true;
        while (flag) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            switch (command) {
                case "sort":
                    List<Product> sorted = sortHelper.sortByXml("name");
                    sorted.forEach(System.out::println);
                    scanner.close();
                    flag = false;
                    break;
                case "top":
                    List<Product> sortedTop = sortHelper.topExpensiveProduct(5);
                    sortedTop.forEach(System.out::println);
                    flag = false;
                case "quit":
                    flag = false;
                    break;
                default:
                    System.out.println("Command is not supported. Enter commands: sort or top or quit");
            }
        }
    }
}
