import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import exception.InvalidScenario;

public class Main {
    public static void main(String[] args) {
        try {
            File myObj = new File(args[0]);
            Scanner myReader = new Scanner(myObj);
            int firstNum = Integer.parseInt(myReader.nextLine());
            if (firstNum <= 0) {
                myReader.close();
                throw new InvalidScenario();
            }
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println("------------------");
                System.out.println(data);
                
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
        catch (InvalidScenario e) {
            e.printStackTrace();
        }
    }
}