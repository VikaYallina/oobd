package com.example.demo.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Entity
public class Shop {

    @Id
    private Long id;
    @Column
    @OneToMany
    private List<Client> clientList;
    @Column
    @OneToMany
    private List<Provider> providerList;
    @Column
    @OneToMany
    private List<Product> productList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
