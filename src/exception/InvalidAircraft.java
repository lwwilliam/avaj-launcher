package exception;

public class InvalidAircraft extends Exception{
    public InvalidAircraft() {
        super("Invalid aircraft type!!");
    }
}