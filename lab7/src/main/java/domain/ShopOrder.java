package domain;

import annotation.Column;
import annotation.Entity;
import annotation.Id;
import annotation.OneToMany;

import java.util.Date;
import java.util.List;

@Entity
public class ShopOrder {
    @Id
    private Long id;
    @Column
    private int orderNumber;
    @Column
    @OneToMany
    private List<Product> productList;
    @Column
    private String deliveryAddress;
    @Column
    private Date orderDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShopOrder(int id, String deliveryAddress, List<Product> productList){
        this.orderNumber = id;
        this.productList = productList;
        this.deliveryAddress = deliveryAddress;
        this.orderDate = new Date();
    }
    public ShopOrder(){}

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
