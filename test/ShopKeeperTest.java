import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ShopKeeperTest {
    @Test
    public void printReceiptShouldPrintReceipt(){
        List<Product> products=new ArrayList<Product>();
        products.add(new Product("book",1,12.49,false));
        products.add(new Product("music CD",1,14.99,false));
        products.add(new Product("pills",1,12.10,false));
        products.add(new Product("box of chocolates",1,10.00,true));
        TaxCalculator taxCalculator=new TaxCalculator();
        ShopKeeper shopKeeper=new ShopKeeper(taxCalculator);
        shopKeeper.printReceipt(products);
    }
}
