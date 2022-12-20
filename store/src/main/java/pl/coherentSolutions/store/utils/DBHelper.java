package pl.coherentSolutions.store.utils;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import pl.coherentSolutions.domain.Category;
import pl.coherentSolutions.products.Product;
import pl.coherentSolutions.store.Store;
import pl.coherentSolutions.store.constant.CredentialsDB;

import java.sql.*;
import java.util.List;

@Slf4j

public class DBHelper {
    private static final Store store = Store.getInstance();
    private static Statement statement;
    private static Connection connection;
    private static ResultSet resultSet;

    private final List<Category> categories = store.getCategoryList();
    private final List<Product> products = store.getAllProducts();

    @SneakyThrows
    public void connectDB() throws RuntimeException {
        log.info("Start connect DataBase");

        connection = DriverManager.getConnection(CredentialsDB.JDBC_URL, CredentialsDB.USER_NAME, CredentialsDB.PASSWORD);
        statement = connection.createStatement();

        log.info("DataBase connected");
    }

    @SneakyThrows
    public void createCategoryTable() {
        log.info("Start create Categories in Table");

        String createCategoryTable = "CREATE TABLE IF NOT EXISTS CATEGORIES (" +
                "ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL," +
                "NAME VARCHAR(255) NOT NULL);";
        statement.executeUpdate(createCategoryTable);

        log.info("Categories created in Table");
    }

    @SneakyThrows
    public void createProductTable() {
        log.info("Start create Products in Table");

        String createProductTable = "CREATE TABLE IF NOT EXISTS PRODUCTS (" +
                "ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL, " +
                "CATEGORY_ID INT NOT NULL," +
                "NAME VARCHAR(255) NOT NULL, " +
                "PRICE DECIMAL NOT NULL," +
                "RATE DECIMAL NOT NULL," +
                "FOREIGN KEY(CATEGORY_ID) REFERENCES CATEGORIES(ID));";
        statement.executeUpdate(createProductTable);

        log.info("Products created in Table");
    }

    @SneakyThrows
    public void clearDB() {
        log.info("Start clear DataBase");

        String dropCategory = "DROP TABLE IF EXISTS CATEGORIES";
        String dropProduct = "DROP TABLE IF EXISTS PRODUCTS";
        statement.executeUpdate(dropProduct);
        statement.executeUpdate(dropCategory);

        log.info("DataBase cleared");
    }

    @SneakyThrows
    public void closeConnection() {
        log.info("Start close Statement and Connection");

        connection.close();

        log.info("Statement and Connection closed");
    }

    @SneakyThrows
    public void addProductsToDataBase() {
        log.info("Start add Categories in DataBase");

        int j = 1;
        for (Category category : categories) {
            PreparedStatement insertCategories = connection.prepareStatement("INSERT INTO CATEGORIES (NAME) VALUES(?)");
            insertCategories.setString(1, category.getName());
            insertCategories.execute();

            log.info("Categories added to DataBase");
            log.info("Start add Products in DataBase");

            PreparedStatement addProductToDB = connection.prepareStatement("INSERT INTO PRODUCTS (CATEGORY_ID, NAME, PRICE, RATE) VALUES(?,?,?,?)");

            for (int i = 0; i < products.size(); i++) {
                addProductToDB.setInt(1, j);
                addProductToDB.setString(2, products.get(i).getName());
                addProductToDB.setDouble(3, products.get(i).getPrice());
                addProductToDB.setDouble(4, products.get(i).getRate());
                addProductToDB.executeUpdate();
            }
            j++;
        }
        log.info("Products added to DataBase");
    }


    @SneakyThrows
    public void printProductsFromDataBase() {

        String sql = "SELECT * FROM PRODUCTS";
        resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {

            String name = resultSet.getString("NAME");
            double price = resultSet.getDouble("PRICE");
            double rate = resultSet.getDouble("RATE");

            System.out.print("Product name: " + name);
            System.out.print(", Product price: " + price);
            System.out.println(", Product rate: " + rate);
        }
    }
}
