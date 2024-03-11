import java.math.BigInteger;
import java.util.Random;

public class Generating_Keys {
    public int bitSize = 1024;
    public Random rnd;
    long longE = 65537;
    BigInteger e = BigInteger.valueOf(longE);
    
    



    public BigInteger initialize_BigInts(){
        BigInteger first_BigInteger = new BigInteger(bitSize, rnd);
        BigInteger second_BigInteger = new BigInteger(bitSize, rnd);
        BigInteger third_BigInteger;//This is the "n" they talk about
        BigInteger phiN;
        phiN = (first_BigInteger.subtract(BigInteger.ONE).multiply(second_BigInteger.subtract(BigInteger.ONE)));

        third_BigInteger = first_BigInteger.multiply(second_BigInteger);
        


        return;
    }

    public BigInteger find_d(BigInteger e, BigInteger phiN){
        BigInteger  return_the_D;
        BigInteger[] intermediaryArray = new BigInteger[3];
        intermediaryArray = Ch31.extended_euclid(e, phiN);
        return_the_D = intermediaryArray[1];
        
        return return_the_D;
    }

    public BigInteger[] publish_P_as_Public_Key(BigInteger e, BigInteger n){
        BigInteger[] returnThis = new BigInteger[2];
        returnThis[0] = e;
        returnThis[1] = n;


        return returnThis;
    }

    public BigInteger[] publish_S_as_Secret_Key(BigInteger d, BigInteger n){
        BigInteger[] returnThis = new BigInteger[2];
        returnThis[0] = d;
        returnThis[1] = n;

        return returnThis;
    }

    public 


}//End Class
