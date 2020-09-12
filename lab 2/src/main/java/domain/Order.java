package domain;

import java.util.Date;
import java.util.List;

public class Order {
    private int orderNumber;
    private List<Product> productList;
    private Status orderStatus;
    private String deliveryAddress;
    private Date orderDate;

    public Order(int id, String deliveryAddress, List<Product> productList, Status status){
        this.orderNumber = id;
        this.productList = productList;
        this.deliveryAddress = deliveryAddress;

        this.orderDate = new Date();
    }

    public boolean addProduct(Product product) throws Exception {
        if (product.isInStock()){
            productList.add(product);

            return true;
        }
        else return false;
    }

    public int getOrderPrice(){
        int totalPrice = 0;
        for(Product product : productList){
            totalPrice+=product.getProductPrice();
        }
        return totalPrice;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public int getOrderNumber() {
        return orderNumber;
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
        return "Order: " + getOrderNumber() +
                ", date= " + getOrderDate() +
                ", address=" + getDeliveryAddress() +
                ", products=" + productList +
                '\n';
    }
}
