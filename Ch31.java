import java.math.BigInteger;

public class Ch31 {
    static final String PRIME = "Prime";
    static final String COMPOSITE = "Composite";
    
    public static void main(String[] args) {
       /* BigInteger a = new BigInteger("11");
        BigInteger b = new BigInteger("13");
        BigInteger n = new BigInteger("8");
        int intValue = 8;



        System.out.println("Running Euclid's Algorithm: "+ euclid(a,b));
        //System.out.println(modularExponentiation(2, 5, 13));
        
        BigInteger[] printtemp = new BigInteger[3];
        printtemp = extended_euclid(a,b);
        System.out.println("Running Extended Euclid's Algorithm: ");
        for (int i = 0; i < 3; i++){
            System.out.print(printtemp[i] + ", ");
        }
        System.out.println();

        System.out.println("Running Modular Exponentiation Algorithm: " + modularExponentiation(a, b, n));

        System.out.println("Running Int Pseudo Prime Algorithm: " + pseudoPrime(intValue));
        System.out.println("Running Pseudo Prime Algorithm: " + pseudoPrime(n));
        */

        
        


    }






    public static BigInteger euclid(BigInteger a, BigInteger b){
        if (b == BigInteger.ZERO)
            return a;
        else 
            return euclid(b, a.mod(b));
    }//End Euclid()

    public static BigInteger[] extended_euclid(BigInteger a, BigInteger b){
        BigInteger[] returnThis = new BigInteger[3];
        if (b == BigInteger.ZERO){
            returnThis[0] = a;
            returnThis[1] = BigInteger.ONE;
            returnThis[2] = BigInteger.ZERO;
            return returnThis;
        } else {
            BigInteger[] temp = extended_euclid(b, a.mod(b));
            BigInteger[] temp2 = new BigInteger[3];
            temp2[0] = temp[0];
            temp2[1] = temp[2];
            temp2[2] = temp[1].subtract(a.divide(b).multiply(temp[2]));

            return temp2;
        }
        
    }//End Extended_Euclid()


    public static BigInteger modularExponentiation( BigInteger a, BigInteger ourLargeBitNum, BigInteger n){
        //int c = 1;
        BigInteger d = BigInteger.ONE;
        int bitLength = ourLargeBitNum.bitLength();

        for ( int i = bitLength; i > -1; i--){
            //c = 2*c;
            d = d.multiply(d).mod(n);
            if(ourLargeBitNum.testBit(i)){
                d = (d.multiply(a).mod(n));
            }
        }

        return d;
    }//End Modular_Exponentiation

    public static int modularExponentiation(int a, int b, int c){

        int result = 1;
        while (b>0){
            if ((b&1) != 0){
                result = result * a;
            }
            b = b >> 1;
            a = a * a;
        }

        return result % c;
    }

    public static String pseudoPrime(int n){
        if (modularExponentiation(2, n-1, n) != 1%n){
            return COMPOSITE;
        }else{
            return PRIME;
        }
    }//End PsuedoPrime()

    public static boolean pseudoPrime(BigInteger n){
        //BigInteger one = BigInteger.ONE;
        if (modularExponentiation(BigInteger.TWO, n.subtract(BigInteger.ONE), n).equals(BigInteger.ONE) != true){
            return false;
        } else {
            return true;
        }
    }

}//End Class Ch31
