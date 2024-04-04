package factory;
import coordinates.Coordinates;
import aircraft.Aircraft;
import aircraft.Helicopter;
import aircraft.JetPlane;
import aircraft.Baloon;
import exception.InvalidAircraft;


public class AircraftFactory {
    private static long p_id = 0;

    public AircraftFactory() {
    }

    public Aircraft newAirCraft(String type, String name, int longitude, int latitude, int height) {
        p_id++;
        try {
            switch (type) {
                case "Helicopter":
                    return new Helicopter(p_id, name, new Coordinates(longitude, latitude, height));
                case "JetPlane":
                    return new JetPlane(p_id, name, new Coordinates(longitude, latitude, height));
                case "Baloon":
                    return new Baloon(p_id, name, new Coordinates(longitude, latitude, height));
                default:
                    throw new InvalidAircraft();
            }
        }
        catch (InvalidAircraft e) {
            e.printStackTrace();
        }
        return null;
    }
}