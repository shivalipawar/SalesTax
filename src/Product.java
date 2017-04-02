
public class Product {
    String productName;
    int quantity;
    double price;
    boolean isImported;
    double priceWithTax;

    @Override
    public String toString() {
        return ""+ this.quantity +" " + (isImported?"imported ":"") + productName + ":" + " "+ priceWithTax;
    }

    public Product(){

    }
    public Product(String productName,int quantity,double price,boolean isImported){
        this.productName=productName;
        this.quantity=quantity;
        this.price=price;
        this.isImported=isImported;
    }

}
