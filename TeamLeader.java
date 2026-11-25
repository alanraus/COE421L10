public class TeamLeader implements Observer {
    private String name;
    private int patience;
    private UI ui;
    private Subject eren;

    public TeamLeader(String name, int patience, UI ui, Subject eren) {
        this.name = name;
        this.patience = patience;
        this.ui = ui;
        this.eren = eren;
        this.eren.addObserver(this);
    }

    @Override
    public void update(int energy) {
        if (patience <= 0) return;

        patience -= 5;
        if (patience == 10) {
            ui.print(name + ": my patience is waning!");
        } else if (patience == 5) {
            ui.print(name + ": is this entertaining?");
        } else if (patience <= 0) {
            ui.print(name + ": omae wa mou shindeiru");
            eren.removeObserver(this);
        }
    }
}