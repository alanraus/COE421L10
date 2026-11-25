import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Eren implements Subject, Runnable {
    private int energy;
    private UI ui;
    private List<Observer> observers;

    public Eren(int energy, UI ui) {
        this.energy = energy;
        this.ui = ui;
        this.observers = new ArrayList<>();
        new Thread(this).start();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : new ArrayList<>(observers)) {
            o.update(energy);
        }
    }

    @Override
    public void run() {
        Random rand = new Random();
        while (energy > 0) {
            try {
                int delay = (rand.nextInt(6) + 5) * 1000;
                Thread.sleep(delay);
                energy -= 5;
                ui.print("eren transformed into a titan current energy: " + energy);
                notifyObservers();
                Thread.sleep(10000);
                ui.print("eren transformed to human");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        ui.print("eren is out of energy");
    }
}