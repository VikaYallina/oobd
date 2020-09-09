import java.util.Date;

public class Arrival {
    private Product product;
    private Provider provider;
    private int amount;
    private Date date;

    Arrival(Product product, Provider provider, int amount){
        this.product = product;
        this.provider = provider;
        this.amount = amount;
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Provider getProvider() {
        return provider;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Arrival: " +
                ", product=" + getProduct() +
                ", provider=" + getProvider() +
                ", amount=" + getAmount() +
                ", date=" + getDate() +
                '\n';
    }
}
