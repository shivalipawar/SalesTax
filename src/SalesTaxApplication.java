import java.io.IOException;
import java.util.List;

public class SalesTaxApplication {
    public static void main(String[] args) throws IOException {
        InputReader reader=new InputReader();
        List<String> rawInputs = reader.readInput();
        InputProcessor inputProcessor = new InputProcessor();
        inputProcessor.processInput(rawInputs);
        ShopKeeper shopKeeper = new ShopKeeper(new TaxCalculator());
        shopKeeper.printReceipt(inputProcessor.products);
    }
}
