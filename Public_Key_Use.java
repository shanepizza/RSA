import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class Public_Key_Use {
    static String _message = "This is the message";

    static BigInteger _BigInt_Message = new BigInteger(_message);
    static String _filePath_n = ".txt files/n.txt";
    static String _filePath_e = ".txt files/e.txt";
    static String _FilePath_d = ".txt files/d.txt";
    static String _filePath_MyMessege = ".txt files/MyMessege.txt";
    static BigInteger n;
    static BigInteger e;
    static BigInteger d;



public static void main(String[] args) {
    n = pull_num(_filePath_n);
    e = pull_num(_filePath_e);
        
    _BigInt_Message = Ch31.modularExponentiation(e, _BigInt_Message, n);
    System.out.println(_BigInt_Message);
    
    try {
        FileHanlder.writeToFile(_filePath_MyMessege, e);
    } catch (Exception e) {
        // TODO: handle exception
    }
}//End Main

public static BigInteger pull_num(String filePath){
    BigInteger x = BigInteger.ZERO;
    try{
        x = new BigInteger(scannerIn(filePath));
    } catch (Exception e) {

    }
        return x;
} // End pull

public static String scannerIn(String filePath) throws FileNotFoundException {
    String Num_as_String;
    File fileToReadFrom = new File(filePath);
    Scanner myScanner = new Scanner(fileToReadFrom);
    Num_as_String = myScanner.nextLine();
    myScanner.close();
    return Num_as_String;
}//End Scanner method





}//End Class
