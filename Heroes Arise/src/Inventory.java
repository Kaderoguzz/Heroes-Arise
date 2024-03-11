public class Inventory {
    private boolean water;
    private boolean elixir;
    private boolean food;
    private String wName;
    private String aName;
    private int damage;
    private int armor;

    Inventory() {
        this.setWater(false);
        this.setElixir(false);
        this.setFood(false);
        this.setDamage(0);
        this.setArmor(0);
    }

    public boolean isWater() {
        return this.water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isElixir() {
        return this.elixir;
    }

    public void setElixir(boolean elixir) {
        this.elixir = elixir;
    }

    public boolean isFood() {
        return this.food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public String getwName() {
        return this.wName;
    }

    public void setwName(String wName) {
        this.wName = wName;
    }

    public String getaName() {
        return this.aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getArmor() {
        return this.armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
}