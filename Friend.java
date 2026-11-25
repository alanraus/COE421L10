import java.util.Random;

public class Friend implements Observer {
    private String name;
    private UI ui;
    private Random rand = new Random();

    public Friend(String name, UI ui, Subject eren) {
        this.name = name;
        this.ui = ui;
        eren.addObserver(this);
    }

    @Override
    public void update(int energy) {
        if (rand.nextBoolean()) {
            ui.print(name + ": Eren, please be safe!");
        }
        if (energy < 20) {
            ui.print(name + ": Rage, rage against the dying of the light");
        }
    }
}