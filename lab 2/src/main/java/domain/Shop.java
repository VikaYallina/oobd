package domain;

import java.util.List;

public class Shop {
    private List<Client> clientList;
    private List<Provider> providerList;
    private List<Product> productList;

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

//    public List<Order> getOrderList() {
//        return orderList;
//    }
//
//    public void setOrderList(List<Order> orderList) {
//        this.orderList = orderList;
//    }

    public List<Provider> getProviderList() {
        return providerList;
    }

    public void setProviderList(List<Provider> providerList) {
        this.providerList = providerList;
    }

    @Override
    public String toString() {
        return "Shop: " +
                "clientList=" + clientList + '\n' +
                ", providerList=" + providerList + '\n' +
             //   ", orderList=" + orderList + '\n' +
                ", productList=" + productList +
                '\n';
    }
}
