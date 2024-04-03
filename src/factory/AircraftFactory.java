package factory;
import coordinates.Coordinates;
import aircraft.Aircraft;
import aircraft.Helicopter;
import aircraft.JetPlane;
import aircraft.Baloon;


public class AircraftFactory {
    public AircraftFactory() {
    }

    public Aircraft newAirCraft(String type, String name, int longitude, int latitude, int height) {
        switch (type) {
            case "Helicopter":
                return new Helicopter(name, name, new Coordinates(longitude, latitude, height));
            case "JetPlane":
                return new JetPlane(name, name, new Coordinates(longitude, latitude, height));
            case "Baloon":
                return new Baloon(name, name, new Coordinates(longitude, latitude, height));
        }
    }
}