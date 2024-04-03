package aircraft;
import coordinates.Coordinates;

public class Aircraft {
	long id;
	String name;
	Coordinates coordinates;

	Aircraft() {
	}

	Aircraft(long p_id, String p_name, Coordinates p_coordinate) {
		this.id = p_id;
		this.name = p_name;
		this.coordinates = p_coordinate;
	}
}