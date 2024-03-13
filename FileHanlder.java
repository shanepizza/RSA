import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileHanlder {
    String _filePath;
    
    FileHanlder(String filePath){
        this._filePath = filePath;
    }
    
    
    
    
    
    try {
        FileWriter fileToWriteTo = new FileWriter(_filePath);

        BufferedWriter Bufferedwriter = new BufferedWriter(fileToWriteTo);
    } catch {

    }






}
