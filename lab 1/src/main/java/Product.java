public class Product {
    private String productName;
    private double productPrice;
    private int productAmount;
    private Arrival productArrival;

    public Product(String name, double price, int amount, Arrival arrival){
        this.productAmount = amount;
        this.productName = name;
        this.productPrice = price;
        this.productArrival = arrival;
    }

    public boolean isInStock() throws Exception {
        if (productAmount>0)
            return true;
        else if (productAmount==0)
            return false;
        else
            throw new Exception("The product amount cannot be negative");
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Product: " + getProductName() +
                ", amount=" + getProductAmount() +
                ", price=" + getProductPrice() +
                ", arrival date=" + productArrival.getDate() +
                ", arrival provider=" + productArrival.getProvider() +
                '\n';
    }
}
