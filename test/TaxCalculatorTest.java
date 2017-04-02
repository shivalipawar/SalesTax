import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TaxCalculatorTest {

    TaxCalculator taxCalculator;
    @Before
    public void init()
    {
        taxCalculator=new TaxCalculator();
    }

    @Test
    public void TaxCalculatorShouldCalculateCorrectTaxIfProductNotImported(){
        double result=taxCalculator.calculateApplicableTaxes(new Product("book",1,12.49,false));
        double result1=taxCalculator.calculateApplicableTaxes(new Product("music CD",1,14.99,false));
        double result2=taxCalculator.calculateApplicableTaxes(new Product("pills",1,12.10,false));
        Assert.assertEquals(0.0,result,0.0);
        Assert.assertEquals(1.49,result1,0.05);
        Assert.assertEquals(0.0,result2,0.05);
    }

    @Test
    public void TaxCalculatorShouldCalculateCorrectTaxIfProductImported(){
        double result=taxCalculator.calculateApplicableTaxes(new Product("book",1,12.49,true));
        double result1=taxCalculator.calculateApplicableTaxes(new Product("music CD",1,14.99,true));
        double result2=taxCalculator.calculateApplicableTaxes(new Product("pills",1,12.10,true));
        Assert.assertEquals(0.62,result,0.05);
        Assert.assertEquals(2.24,result1,0.05);
        Assert.assertEquals(0.60,result2,0.05);
    }
}
