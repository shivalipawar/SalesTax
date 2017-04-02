import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InputProcessorTest {
    @Test
    public void processInputShouldCreateListOfProducts(){
        List<String> rawString = new ArrayList();
        rawString.add("1 book at 12.49");
        rawString.add("1 imported box of chocolates at 10.00");
        InputProcessor inputProcessor=new InputProcessor();
        inputProcessor.processInput(rawString);
        Assert.assertEquals("book",inputProcessor.products.get(0).productName);
        Assert.assertEquals(12.49,inputProcessor.products.get(0).price,0.0);
        Assert.assertEquals(1,inputProcessor.products.get(0).quantity,0.0);
        Assert.assertFalse(inputProcessor.products.get(0).isImported);

        Assert.assertEquals("box of chocolates",inputProcessor.products.get(1).productName);
        Assert.assertEquals(10.00,inputProcessor.products.get(1).price,0.0);
        Assert.assertEquals(1,inputProcessor.products.get(1).quantity,0.0);
        Assert.assertTrue(inputProcessor.products.get(1).isImported);
    }
}
