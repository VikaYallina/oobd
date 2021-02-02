package domain;

import annotation.Column;
import annotation.Entity;
import annotation.OneToMany;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Entity
public class Shop {
    @Column
    @OneToMany
    private List<Client> clientList;
    @Column
    @OneToMany
    private List<Provider> providerList;
    @Column
    @OneToMany
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
