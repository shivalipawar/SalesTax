import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InputProcessor {

    List<Product> products;
    public InputProcessor(){
        products  = new ArrayList<Product>();
    }

    public void processInput(List<String> inputStrings){
        String currentLineOfInput;
        Iterator iterator=inputStrings.iterator();
        while (iterator.hasNext()){
        currentLineOfInput= (String) iterator.next();
        Product product = parseInput(currentLineOfInput);
        products.add(product);
        }
    }

    private Product parseInput(String currentLineOfInput) {
        Product p;
        if (currentLineOfInput.contains("imported")){
            p = parseInputForImportedGoods(currentLineOfInput);
            return p;
        }
        p = parseInputForNonImportedGoods(currentLineOfInput);
        return p;
    }

    private Product parseInputForNonImportedGoods(String currentLineOfInput) {
        String[] currentLineInputArr=currentLineOfInput.split(" ");
        Product product = new Product();
        product.quantity= Integer.parseInt(currentLineInputArr[0]);
        product.isImported=false;
        product.price= Double.parseDouble(currentLineInputArr[currentLineInputArr.length-1]);
        product.productName=getProductName(currentLineOfInput,2,currentLineOfInput.length()- (currentLineInputArr[currentLineInputArr.length-1].length()+4));
        return product;
    }

    private Product parseInputForImportedGoods(String currentLineOfInput) {
        String[] currentLineInputArr=currentLineOfInput.split(" ");
        Product product = new Product();
        product.quantity= Integer.parseInt(currentLineInputArr[0]);
        product.isImported=true;
        product.price= Double.parseDouble(currentLineInputArr[currentLineInputArr.length-1]);
        product.productName=getProductName(currentLineOfInput,11,currentLineOfInput.length()- (currentLineInputArr[currentLineInputArr.length-1].length()+4));
        return product;
    }

    private String getProductName(String rawString, int startIndex, int endIndex) {
        return rawString.substring(startIndex,endIndex);
    }
}