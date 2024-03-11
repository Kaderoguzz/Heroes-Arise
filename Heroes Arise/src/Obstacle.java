import java.util.Random;

public class Obstacle {
    private final String name;
    private final int damage;
    private final int award;
    private int health;
    private final int maxNumber;

    public Obstacle(String name, int damage, int health, int award, int maxNumber) {
        this.name = name;
        this.damage = damage;
        this.award = award;
        this.health = health;
        this.maxNumber = maxNumber;
    }

    public int count() {
        Random r = new Random();
        return r.nextInt(this.maxNumber) + 1;
    }

    public String getName() {
        return this.name;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getAward() {
        return this.award;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}