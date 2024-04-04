package parser;
import java.io.FileWriter;
import java.io.IOException;  

public class PrintToFile {
    
    public static void Write(String content) {
        try {
            FileWriter myWriter = new FileWriter("simulation.txt", true);
            myWriter.write(content);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}