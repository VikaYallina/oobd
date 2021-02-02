import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBservice {
    public static List<Product> loadFromDB(Connection connection) throws SQLException {
        List<Product> products = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT product FROM t_product");
        ResultSet resultSet = statement.executeQuery();

        Product product;
        String productStr;
        List<Product> resultList = new ArrayList<>();
        while (resultSet.next()){
            productStr = resultSet.getString("product");
            product = new Product();
            product.setValue(productStr);
            resultList.add(product);
        }
        statement.close();

        return resultList;
    }

    public static void saveDB(Connection connection, List<Product> list) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("UPDATE t_product SET product=cast(? as product) where id=cast(? as integer)");
        int i =1;
        for (Product product:
                list) {
            statement.setString(1, product.getValue());
            statement.setString(2, String.valueOf(i));
            statement.executeUpdate();
        }
        statement.close();

    }
}
