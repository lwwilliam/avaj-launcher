package parser;
import exception.InvalidScenario;
import factory.AircraftFactory;
import java.util.ArrayList;
import tower.WeatherTower;

public class Parser {
    private ArrayList<String> nameArr = new ArrayList<>();

    public void parse(String data, WeatherTower tower) throws InvalidScenario{
        String[] arrOfStr = data.split(" ");

        if (arrOfStr.length != 5)
            throw new InvalidScenario();
        if (nameArr.contains(arrOfStr[1]))
            throw new InvalidScenario();
        else
            nameArr.add(arrOfStr[1]);
        int longitude = Integer.parseInt(arrOfStr[2]);
        int latitude = Integer.parseInt(arrOfStr[3]);
        int height = Integer.parseInt(arrOfStr[4]);
        if (longitude < 1 || latitude < 1 || height < 1)
            throw new InvalidScenario();
        else if (height > 100)
            throw new InvalidScenario();

        AircraftFactory aircraftFactory = new AircraftFactory();
        aircraftFactory.newAirCraft(arrOfStr[0], arrOfStr[1], longitude, latitude, height).registerTower(tower);
    }
}

// System.out.println("type :" + arrOfStr[0]);
// System.out.println("name :" + arrOfStr[1]);
// System.out.println("long :" + arrOfStr[2]);
// System.out.println("latt :" + arrOfStr[3]);
// System.out.println("heig :" + arrOfStr[4]);