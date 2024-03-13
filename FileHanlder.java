import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Formatter;
import java.util.Scanner;
public class FileHanlder {
    String _filePath;


public static String scannerIn(String filePath) throws FileNotFoundException {
    String Num_as_String;
    File fileToReadFrom = new File(filePath);
    Scanner myScanner = new Scanner(fileToReadFrom);
    Num_as_String = myScanner.nextLine();
    myScanner.close();
    return Num_as_String;
}//End Scanner method

public static void writeToFile (String filePath, BigInteger key)throws FileNotFoundException{
        Formatter formatter = new Formatter(new File(filePath));
        formatter.format(key.toString());
        formatter.close();
    }



}
