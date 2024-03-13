import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Formatter;
import java.util.Random;

public class Generating_Keys {
    public static int bitSize = 1024;
    public static Random rnd= new Random();
    static long longE = 65537;
    static BigInteger e = BigInteger.valueOf(longE);
    static String _filePath_n = ".txt files/n.txt";
    static String _filePath_e = ".txt files/e.txt";
    static String _FilePath_d = ".txt files/d.txt";
    
    public static void main(String[] args) {
        initialize_BigInts();
    }

    public static BigInteger get_prime(int bitSize){
        BigInteger creatingBigInteger = new BigInteger(bitSize, rnd);
        if (Ch31.pseudoPrime(creatingBigInteger) == false) {
            creatingBigInteger =  get_prime(bitSize);
        }
            return creatingBigInteger;

    }//End Get Prime

    public static BigInteger calculate_n(BigInteger p, BigInteger q){
        BigInteger n = p.multiply(q);
        return n;
    }

    public static void initialize_BigInts(){
        BigInteger first_BigInteger = get_prime(bitSize); //This is p
        BigInteger second_BigInteger = get_prime(bitSize); // this is q
        BigInteger third_BigInteger_n = calculate_n(second_BigInteger, first_BigInteger); /*This is the "n" they talk about*/ 

        BigInteger phiN = (first_BigInteger.subtract(BigInteger.ONE).multiply(second_BigInteger.subtract(BigInteger.ONE)));

        BigInteger the_D = find_d(e, phiN);

        BigInteger[] public_Key = publish_P_as_Public_Key(e, third_BigInteger_n);
        BigInteger[] private_key = publish_S_as_Secret_Key(the_D, third_BigInteger_n);
        
    }

    public static BigInteger find_d(BigInteger e, BigInteger phiN){
        BigInteger  return_the_D;
        BigInteger[] intermediaryArray = new BigInteger[3];
        intermediaryArray = Ch31.extended_euclid(e, phiN);
        return_the_D = intermediaryArray[1];

        if (return_the_D.compareTo(BigInteger.ZERO) < 0){
            return_the_D.add(phiN);
        }
        
        return return_the_D; //this is the d they are talking bout
    }//End find D

    public static BigInteger[] publish_P_as_Public_Key(BigInteger e, BigInteger n){
        BigInteger[] returnThis = new BigInteger[2];
        returnThis[0] = e;
        returnThis[1] = n;
        
        try {
            writeToFile(_filePath_e, e);
            writeToFile(_filePath_n, n);
        } catch (FileNotFoundException f){
        
        }


        return returnThis;
    }//End public key

    public static BigInteger[] publish_S_as_Secret_Key(BigInteger d, BigInteger n){
        BigInteger[] returnThis = new BigInteger[2];
        returnThis[0] = d;
        returnThis[1] = n;
        try{
            writeToFile(_FilePath_d, d);
        } catch (FileNotFoundException e){

        }
        

        return returnThis;
    }//End private key

    public static void writeToFile (String filePath, BigInteger key)throws FileNotFoundException{
        Formatter formatter = new Formatter(new File(filePath));
        formatter.format(key.toString());
        formatter.close();
    }
}//End Class
