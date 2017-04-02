import java.util.ArrayList;
import java.util.List;

public class TaxCalculator {
    public static final int SALES_TAX_RATE = 10;
    public static final int IMPORT_DUTY_RATE = 5;
    private List<String> exemptedFoodItems;
    private List<String> exemptedMedicalItems;
    private List<String> exemptedBookItems;

    public TaxCalculator() {
        exemptedBookItems = new ArrayList<String>();
        exemptedFoodItems = new ArrayList<String>();
        exemptedMedicalItems = new ArrayList<String>();
        exemptedFoodItems.add("chocolate bar");
        exemptedFoodItems.add("box of chocolates");
        exemptedMedicalItems.add("pills");
        exemptedBookItems.add("book");
    }

    public double calculateApplicableTaxes(Product product){
        if (product.isImported){
            return calculateSalesTax(product.quantity,product.productName,product.price)+
                    calculateImportDuty(product.quantity,product.productName,product.price);
        }
        return calculateSalesTax(product.quantity,product.productName,product.price);
    }

    private double calculateSalesTax(int quantity, String nameOfItem, double price) {
        double salesTax = 0.0;
        if (isTaxableItem(nameOfItem)) {
            salesTax = ((SALES_TAX_RATE * price) / 100) * quantity;
            return salesTax;
        }
        return salesTax;
    }

    private double calculateImportDuty(int quantity, String nameOfItem, double price) {
        return ((IMPORT_DUTY_RATE * price) / 100) * quantity;
    }

    private boolean isTaxableItem(String nameOfItem) {
        return !isFood(nameOfItem) && !isBook(nameOfItem) && !isMedicine(nameOfItem);
    }

    private boolean isMedicine(String nameOfItem) {
        return exemptedMedicalItems.contains(nameOfItem);
    }

    private boolean isBook(String nameOfItem) {
        return exemptedBookItems.contains(nameOfItem);
    }

    private boolean isFood(String nameOfItem) {
        return exemptedFoodItems.contains(nameOfItem);
    }
}
