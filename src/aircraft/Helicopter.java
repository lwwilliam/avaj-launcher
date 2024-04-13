package aircraft;
import coordinates.Coordinates;
import parser.PrintToFile;

public class Helicopter extends Aircraft{
    public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
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
                longitude += 10;
                height += 2;
                message = "Sunny weather for helicopter!";
                break;
            case "RAIN":
                longitude += 5;
                message = "Rainny weather for helicopter!";
                break;
            case "FOG":
                longitude += 1;
                message = "Foggy weather for helicopter!";
                break;
            case "SNOW":
                height -= 12;
                message = "Snowy weather for helicopter!";
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
        PrintToFile.Write("Helicopter#" + this.name + "(" + this.id + "): " + message + "\n");
        // System.out.println("Helicopter#" + this.name + "(" + this.id + "): " + message);
    }
}