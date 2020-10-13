import model.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String dbURL = "jdbc:postgresql://localhost:5432/oodb";

        Connection connection = DriverManager.getConnection(dbURL, "postgres","jessica17");
        List<Product> productList = DBservice.loadFromDB(connection);
        for (Product prod: productList
             ) {
            System.out.println(prod);
        }
        productList.get(1).setName("lamp");
        DBservice.saveDB(connection, productList);
    }
}
