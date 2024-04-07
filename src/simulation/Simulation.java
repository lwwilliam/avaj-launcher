package simulation;
import tower.Tower;

public class Simulation {
    public Simulation(int runTimes, Tower tower) {

        for (int i = 0; i < runTimes; i++) {
            tower.conditionsChanged();
        }
    }
}