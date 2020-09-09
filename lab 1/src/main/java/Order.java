import java.util.Date;
import java.util.List;

public class Order {
    private int orderID;
    private List<Product> productList;
    private Status orderStatus;
    private String deliveryAddress;
    private Date orderDate;

    public Order(int id, String deliveryAddress, List<Product> productList){
        this.orderID = id;
        this.productList = productList;
        this.deliveryAddress = deliveryAddress;
        this.orderStatus = Status.ORDERED;
        this.orderDate = new Date();
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public int getOrderID() {
        return orderID;
    }

    public Status getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Status orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList(){
        return this.productList;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    @Override
    public String toString() {
        return "Order: " + getOrderID() +
                ", date= " + getOrderDate() +
                ", address=" + getDeliveryAddress() +
                ", products=" + productList +
                '\n';
    }
}
