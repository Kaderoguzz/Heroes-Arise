import java.util.Scanner;

public abstract class Location {
    protected Player player;
    protected String name;
    Scanner scan;

    public Location(Player player) {
        this.scan = new Scanner(System.in);
        this.player = player;
    }

    public abstract boolean getLocation();

    public String getName() {
        return this.name;
    }

}