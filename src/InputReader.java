import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputReader {

    FileReader fileReader;
    BufferedReader bufferedReader;
    List<String> input =new ArrayList<String>();
    public InputReader() {
        try {
            fileReader = new FileReader("D:\\Shivali\\Code\\Object-Oriented-Codes\\SalesTax\\resource\\input");
            bufferedReader=new BufferedReader(fileReader);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public List<String> readInput() throws IOException {
        String currentLineOfInput;
        while ((currentLineOfInput=bufferedReader.readLine())!=null){
            input.add(currentLineOfInput);
        }
        return input;
    }



}
