package domain;

import annotation.Column;
import annotation.Entity;
import annotation.Id;
import annotation.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Client implements Comparable<Client> {

    @Id
    private Long id;
    @Column
    @OneToMany
    private List<ShopOrder> shopOrderList = new ArrayList<>();
    @Column
    private String login;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return this.address;
    }
    public Client(String name, String address, String login, String password){
        this.name = name;
        this.address = address;
        this.login = login;
        this.password = password;
    }
    public Client(){
        super();
    }

    private ShopOrder findOpenOrder(){
        if (shopOrderList != null){
            for (ShopOrder shopOrder : shopOrderList) {
                return shopOrder;
            }
        }
        return null;
    }

    public void createOrder(int number, String address, List<Product> products) {
        ShopOrder newShopOrder = findOpenOrder();
        if (newShopOrder == null){
            shopOrderList.add(new ShopOrder(number, address, products));
        }

    }

    public void setOrderList(List<ShopOrder> shopOrderList){
        this.shopOrderList = shopOrderList;
    }

    public List<ShopOrder> getOrderList(){
        return this.shopOrderList;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public String getLogin(){
        return this.login;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

    @Override
    public String toString() {
        return "Client: " + getName() +
                ", orders=" + shopOrderList +
                '\n';
    }

    @Override
    public int compareTo(Client client) {
        return login.compareTo(client.getLogin());
    }
}
