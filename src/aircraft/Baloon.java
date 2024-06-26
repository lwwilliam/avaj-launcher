package aircraft;
import coordinates.Coordinates;
import parser.PrintToFile;

public class Baloon extends Aircraft{
    public Baloon(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    @Override
    public void updateConditions() {
        int longitude = this.coordinates.getLongitude();
        int latitude = this.coordinates.getLatitude();
        int height = this.coordinates.getHeight();
        String message = "";

        switch (weatherTower.getWeather(this.coordinates)) {
            case "SUN":
                longitude += 2;
                height += 4;
                message = "Sunny weather for baloon!";
                break;
            case "RAIN":
                height -= 5;
                message = "Rainny weather for baloon!";
                break;
            case "FOG":
                height -= 3;
                message = "Foggy weather for baloon!";
                break;
            case "SNOW":
                height -= 15;
                message = "Snowy weather for baloon!";
                break;
        }
        if (height > 100)
            height = 100;
        if (height < 0) {
            height = 0;
            weatherTower.unregister(this);
            message = "landing.";
        }
        this.coordinates = new Coordinates(longitude, latitude, height);
        PrintToFile.Write("Baloon#" + this.name + "(" + this.id + "): " + message + "\n");
        // System.out.println("Baloon#" + this.name + "(" + this.id + "): " + message);
    }
}