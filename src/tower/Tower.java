package tower;
import java.util.ArrayList;
import java.util.List;
import flyable.Flyable;
import parser.PrintToFile;

public class Tower {
    private List<Flyable> observers;

    public Tower() {
        this.observers = new ArrayList<>();
    }

    public void register(Flyable p_flyable) {
        PrintToFile.Write("Tower says: " + p_flyable + " registered to weather tower.\n");
        observers.add(p_flyable);
    }

    public void unregister(Flyable p_flyable) {
        PrintToFile.Write("Tower says: " + p_flyable + " unregistered from weather tower.\n");
        observers.remove(p_flyable);
    }

    public void conditionsChanged() {
        for (Flyable flyable : observers) {
            flyable.updateConditions();
        }
    }

    // public void printAllObservers() {
    //     for (Flyable flyable : observers) {
    //         System.out.println(flyable);
    //     }
    // }
}