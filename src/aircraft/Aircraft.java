package aircraft;
import coordinates.Coordinates;
import flyable.Flyable;

public class Aircraft extends Flyable{
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinate) {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinate;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "#" + this.name + "(" + this.id + ")";
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public void updateConditions() {
    }
}