package weatherprovider;
import coordinates.Coordinates;
import java.util.Random;

public class WeatherProvider {
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
    private static WeatherProvider weatherProvider = null;

    private WeatherProvider() {
    }

    public static WeatherProvider getInstance() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int index = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();
        index += new Random().nextInt(100);

        return weather[index % 4];
    }
}