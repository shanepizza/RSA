import java.math.BigInteger;

public class Private_Key_Use {
    
    
    
    static String _filePath_n = ".txt files/n.txt";
    static String _filePath_e = ".txt files/e.txt";
    static String _filePath_d = ".txt files/d.txt";
    static String _filePath_MyMessege = ".txt files/MyMessege.txt";
    



    
    
    
    static BigInteger n;
    static BigInteger e;
    static BigInteger d;

    public static void main(String[] args) {
        try {
            String _message = FileHanlder.scannerIn(_filePath_MyMessege);
            byte[] _messageByte = _message.getBytes();
            BigInteger _BigInt_Message = new BigInteger(_messageByte);
        
        
            n = pull_num(_filePath_n);
            d = pull_num(_filePath_d);
                
            System.out.println(_BigInt_Message = Ch31.modularExponentiation(d, _BigInt_Message, n));
            
            try {
                //FileHanlder.writeToFile(_filePath_MyMessege, _BigInt_Message);
            } catch (Exception e) {
                // TODO: handle exception
            }
    
        } catch (Exception e) {
            // TODO: handle exception
        }
    }//End Main
    
    public static BigInteger pull_num(String filePath){
        BigInteger x = BigInteger.ZERO;
        try{
            x = new BigInteger(FileHanlder.scannerIn(filePath));
        } catch (Exception e) {
    
        }
            return x;
    } // End pull
}
