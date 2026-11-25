import java.util.Random;

public class Titan implements Observer {
    private String name;
    private UI ui;
    private Random rand = new Random();

    public Titan(String name, UI ui, Subject eren) {
        this.name = name;
        this.ui = ui;
        eren.addObserver(this);
    }

    @Override
    public void update(int energy) {
        if (rand.nextBoolean()) {
            ui.print(name + " attacked eren");
        }
        if (energy > 40) {
            ui.print(name + ": now we got problems, and I don't think we can solve 'em");
        }
    }
}