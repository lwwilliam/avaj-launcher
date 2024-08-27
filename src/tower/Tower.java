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
        observers.remove(p_flyable);
    }

    protected void conditionsChanged() {
        List<Flyable> copyOfObservers = new ArrayList<>(observers);
        for (Flyable flyable : copyOfObservers) {
            flyable.updateConditions();
        }
    }
}