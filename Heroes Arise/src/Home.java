public class Home extends NormalLoc {
    public Home(Player player) {
        super(player, "Safe House");
    }

    public boolean getLocation() {
        this.player.setHealth(this.player.getRhealth());
        System.out.println("Your health is full");
        System.out.println("You are now in the safe house");
        return true;
    }
}
