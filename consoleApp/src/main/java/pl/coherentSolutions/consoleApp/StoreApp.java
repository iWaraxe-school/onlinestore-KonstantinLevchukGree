package pl.coherentSolutions.consoleApp;

import pl.coherentSolutions.store.Store;
import pl.coherentSolutions.store.utils.StoreHelper;
import pl.coherentSolutions.store.utils.XmlParser;

import java.util.Map;

public class StoreApp {
    public static void main(String[] args) {
        Store store = new Store();
        StoreHelper helper = new StoreHelper(store);
        helper.fillStoreRandomly();
        store.printStore();
        XmlParser xmlParser=new XmlParser();
        Map<String, String> sortConfigFromXml = xmlParser.getSortConfigFromXml();
        System.out.println(sortConfigFromXml.toString());
        int i = 0;
    }
}
