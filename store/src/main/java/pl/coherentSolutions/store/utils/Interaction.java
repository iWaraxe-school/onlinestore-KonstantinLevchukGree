package pl.coherentSolutions.store.utils;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import pl.coherentSolutions.products.Product;
import pl.coherentSolutions.store.constant.CommandKey;
import pl.coherentSolutions.store.threads.CreateOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static pl.coherentSolutions.store.constant.SortKey.*;

@Slf4j
@RequiredArgsConstructor

public class Interaction {
    private final SortHelper sortHelper;

   /* public Interaction(SortHelper sortHelper) {
        this.sortHelper = sortHelper;
    }*/

    @SneakyThrows
    public void runInteraction() {
        printLabelStore();
        boolean flagFirst = true;
        boolean flagSecond = true;
        while (flagFirst) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            switch (command) {
                case "sort":
                    printLabelSort();
                    List<Product> sorted = sortHelper.sortedProductList();
                    sortHelper.printListProduct(sorted);
                    printInfo();
                    break;
                case "top":
                    printLabelTop();
                    List<Product> sortedTop = sortHelper.topExpensiveProduct(Integer.parseInt(scanner.nextLine()));
                    sortHelper.printListProduct(sortedTop);
                    printInfo();
                    break;
                case "create order":
                    List<Product> selectedProducts = new ArrayList<>();
                    while (flagSecond) {
                        printCreateOrder();
                        String productName = scanner.nextLine();
                        if ("stop".equals(productName)) {
                            flagSecond = false;
                        } else {
                            selectedProducts.addAll(0, sortHelper.findProducts(productName));
                        }
                    }
                    System.out.println(selectedProducts);
                    log.info("Start create new Thread");
                    new CreateOrder(selectedProducts).start();
                    printInfo();
                    break;
                case "quit":
                    flagFirst = false;
                    printLabelQuit();
                    break;
                default:
                    printInfo();
            }
        }
    }

    private void printLabelStore() {
        System.out.println("Welcome to online store\nCommands:\n" + CommandKey.SORT.getKey() + "\n" + CommandKey.TOP.getKey() + "\n" + CommandKey.QUIT.getKey() + "\n" + CommandKey.CREATE_ORDER.getKey());
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
        System.out.println("Enter command:\n" + CommandKey.SORT.getKey() + "\n" + CommandKey.TOP.getKey() + "\n" + CommandKey.QUIT.getKey() + "\n" + CommandKey.CREATE_ORDER.getKey());
    }

    private void printCreateOrder() {
        System.out.println("Enter product 'name' or '" + CommandKey.STOP.getKey() + "' to exit");
    }
}
