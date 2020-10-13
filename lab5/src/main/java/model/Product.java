package model;

import org.postgresql.util.PGobject;
import org.postgresql.util.PGtokenizer;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Product extends PGobject {

    private String model;
    private String name;
    private int stock;
    private Date firstDateAvailable;

    public Product(){
        setType("product");
    }

    public void setValue(String value) throws SQLException {
        String s = value.substring(1, value.length()-1);
        PGtokenizer t = new PGtokenizer(s, ',');
        if(t.getSize() != 4) throw new SQLException("Failed to convert to type Product");
        model = t.getToken(0);
        name = t.getToken(1);
        stock = Integer.parseInt(t.getToken(2));
        try {
            firstDateAvailable = new SimpleDateFormat("yyyy-MM-dd").parse(t.getToken(3).substring(1, 11));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getValue() {
        return "('" + model + "','" + name + "'," + stock + ",'" +
                 new SimpleDateFormat("yyyy-MM-dd").format(firstDateAvailable) + "')";
    }


    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFirstDateAvailable() {
        return firstDateAvailable;
    }

    public void setFirstDateAvailable(Date firstDateAvailable) {
        this.firstDateAvailable = firstDateAvailable;
    }

    @Override
    public String toString() {
        return "Product{" +
                "model='" + model + '\'' +
                ", name='" + name + '\'' +
                ", stock=" + stock +
                ", firstDateAvailable=" + firstDateAvailable +
                '}';
    }
}
