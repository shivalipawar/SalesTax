import java.util.Iterator;
import java.util.List;

public class ShopKeeper {

    private TaxCalculator taxCalculator;

    public ShopKeeper(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public void printReceipt(List<Product> products) {
        Iterator iterator = products.iterator();
        double totalTax = 0.0;
        double totalPrice = 0.0;
        while (iterator.hasNext()) {
            Product product = (Product) iterator.next();
            double tax = taxCalculator.calculateApplicableTaxes(product);
            product.priceWithTax = product.price + tax;
            totalTax += tax;
            totalPrice += product.priceWithTax;
            System.out.println(product);
        }
        System.out.println("Sales Tax : "+ totalTax);
        System.out.println("Total : "+ totalPrice);
    }
}
