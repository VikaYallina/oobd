package domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Shop {
    private List<Client> clientList;
    private List<Provider> providerList;
    private List<Product> productList;

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @XmlElementWrapper(name="products")
    @XmlElement(name="product")
    public List<Product> getProductList() {
        return productList;
    }

    @XmlElementWrapper(name="clients")
    @XmlElement(name="client")
    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    @XmlElementWrapper(name="providers")
    @XmlElement(name="provider")
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
