import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException; 
import java.util.Scanner;
import exception.InvalidScenario;
import parser.Parser;
import tower.Tower;

public class Main {
    public static void main(String[] args) {
        Tower tower = new Tower();
        try {
            FileWriter myWriter = new FileWriter("simulation.txt", false);
            myWriter.close();
            if (args.length == 0)
                throw new InvalidScenario();
            File scenarioFile = new File(args[0]);
            Scanner myReader = new Scanner(scenarioFile);
            int runTimes = Integer.parseInt(myReader.nextLine());
            if (runTimes <= 0) {
                myReader.close();
                throw new InvalidScenario();
            }
            Parser parser = new Parser();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                try {
                    tower.register(parser.parse(data));
                } catch (InvalidScenario e) {
                    e.printStackTrace();
                    break;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
        catch (InvalidScenario e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}