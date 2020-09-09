import java.util.List;

public class Client extends Person{
    private List<Order> orderList;

    private String login;
    private String password;

    public Client(String name, String address, String login, String password){
        super(name, address);
        this.login = login;
        this.password = password;
    }

    public void makeOrder(int id, String address, List<Product> products){
        orderList.add(new Order(id, address, products));
    }

    public void setOrderList(List<Order> orderList){
        this.orderList = orderList;
    }

    public List<Order> getOrderList(){
        return this.orderList;
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
                ", orders=" + orderList +
                '\n';
    }
}
