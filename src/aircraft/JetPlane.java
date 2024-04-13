package aircraft;
import coordinates.Coordinates;
import parser.PrintToFile;

public class JetPlane extends Aircraft{
    public JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
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
                latitude += 10;
                height += 2;
                message = "Sunny weather for jetplane!";
                break;
            case "RAIN":
                latitude += 5;
                message = "Rainny weather for jetplane!";
                break;
            case "FOG":
                latitude += 1;
                message = "Foggy weather for jetplane!";
                break;
            case "SNOW":
                height -= 7;
                message = "Snowy weather for jetplane!";
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
        PrintToFile.Write("JetPlane#" + this.name + "(" + this.id + "): " + message + "\n");
        // System.out.println("JetPlane#" + this.name + "(" + this.id + "): " + message);
    }
}