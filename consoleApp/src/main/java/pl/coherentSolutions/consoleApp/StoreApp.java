package pl.coherentSolutions.consoleApp;

import pl.coherentSolutions.products.Product;
import pl.coherentSolutions.store.Store;
import pl.coherentSolutions.store.utils.Interaction;
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
        Interaction interaction=new Interaction(sortHelper);
        interaction.runInteraction();
    }
}
