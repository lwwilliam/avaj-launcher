package simulation;
import tower.WeatherTower;

public class Simulation {
    public Simulation(int runTimes, WeatherTower tower) {

        for (int i = 0; i < runTimes; i++) {
            tower.changeWeather();
        }
    }
}