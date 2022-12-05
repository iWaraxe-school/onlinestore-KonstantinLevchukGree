package pl.coherentSolutions.store.utils;

import pl.coherentSolutions.products.Product;
import pl.coherentSolutions.store.constant.CommandKey;

import java.util.List;
import java.util.Scanner;

import static pl.coherentSolutions.store.constant.SortKey.*;

public class Interaction {
    SortHelper sortHelper;

    public Interaction(SortHelper sortHelper) {
        this.sortHelper = sortHelper;
    }

    public void runInteraction() {
        printLabelStore();
        Boolean flag = true;
        while (flag) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            switch (command) {
                case "sort":
                    printLabelSort();
                    List<Product> sorted = sortHelper.sortByXml(scanner.nextLine());
                    sortHelper.printListProduct(sorted);
                    printInfo();
                    break;
                case "top":
                    printLabelTop();
                    List<Product> sortedTop = sortHelper.topExpensiveProduct(Integer.parseInt(scanner.nextLine()));
                    sortHelper.printListProduct(sortedTop);
                    printInfo();
                    break;
                case "quit":
                    flag = false;
                    printLabelQuit();
                    break;
                default:
                    printInfo();
            }
        }
    }

    private void printLabelStore() {
        System.out.println("Welcome to online store\nCommands:\n" + CommandKey.SORT.getKey() + "\n" + CommandKey.TOP.getKey() + "\n" + CommandKey.QUIT.getKey());
    }

    private void printLabelSort() {
        System.out.println("Enter product value:\n" + NAME.getKey() + "\n" + PRICE.getKey() + "\n" + RATE.getKey());
    }

    private void printLabelTop() {
        System.out.println("Enter the number of products from 0 to " + sortHelper.getProductList().size());
    }

    private void printLabelQuit() {
        System.out.println("Application stopped");
    }

    private void printInfo() {
        System.out.println("Enter command:\n" + CommandKey.SORT.getKey() + "\n" + CommandKey.TOP.getKey() + "\n" + CommandKey.QUIT.getKey());
    }
}
