package pl.coherentSolutions.store.utils;

import lombok.SneakyThrows;
import pl.coherentSolutions.store.Store;
import pl.coherentSolutions.store.constant.CredentialsDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBHelper {

    Store store;
    private static Statement statement;
    private static Connection connection;

    @SneakyThrows
    public void connectDB() throws RuntimeException {
        connection = DriverManager.getConnection(CredentialsDB.JDBC_URL, CredentialsDB.USER_NAME, CredentialsDB.PASSWORD);
        statement = connection.createStatement();
    }

    @SneakyThrows
    public void createCategoryTable() {
        String createCategoryTable = "CREATE TABLE IF NOT EXISTS CATEGORY" +
                "(ID int PRIMARY KEY AUTO_INCREMENT, " +
                " NAME VARCHAR(255) NOT NULL)";
        statement.executeUpdate(createCategoryTable);
    }

    @SneakyThrows
    public void createProductTable() {
        String createProductTable = "CREATE TABLE IF NOT EXISTS PRODUCT " +
                "(ID int PRIMARY KEY AUTO_INCREMENT, " +
                " CATEGORY_ID int NOT NULL, " +
                " NAME VARCHAR(255) NOT NULL, " +
                " PRICE DECIMAL NOT NULL, " +
                " RATE DECIMAL NOT NULL, " +
                " FOREIGN KEY(CATEGORY_ID) REFERENCES CATEGORY(ID))";
        statement.executeUpdate(createProductTable);
    }

    @SneakyThrows
    public void clearDB() {
        String dropCategory = "DROP TABLE IF EXISTS CATEGORY";
        String dropProduct = "DROP TABLE IF EXISTS PRODUCT";
        statement.executeUpdate(dropProduct);
        statement.executeUpdate(dropCategory);
    }

    @SneakyThrows
    public void quitStatementConnection() {
        statement.close();
        connection.close();
    }


}
