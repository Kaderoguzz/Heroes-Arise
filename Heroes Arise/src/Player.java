import java.io.PrintStream;
import java.util.Scanner;

public class Player {
    private int health;
    private int money;
    private int damage;
    private int rhealth;
    private final String name;
    private String charactername;
    Inventory inv;
    Scanner scan;

    public void initPlayer(String Cname, int dmg, int health, int mny) {
        this.setCharactername(Cname);
        this.setDamage(dmg);
        this.setHealth(health);
        this.setMoney(mny);
        this.setRhealth(health);
    }

    public void selectCha() {
        switch (this.chaMenu()) {
            case 2:
                this.initPlayer("Mage", 7, 18, 20);
                break;
            case 3:
                this.initPlayer("God", 8, 24, 30);
                break;
            default:
                this.initPlayer("Warrior", 5, 21, 10);
        }

        System.out.println();
        PrintStream var10000 = System.out;
        String var10001 = this.getCharactername();
        var10000.println("Character: " + var10001 + "\t Damage: " + this.getDamage() + "\t Health: " + this.getHealth() + "\t Money: " + this.getMoney());
    }

    public int chaMenu() {
        System.out.println("Choose your character:\n ");
        System.out.println("1-Warrior \t Damage:5 \t Health:21 \t Money:10");
        System.out.println("2-Mage \t \t Damage:7 \t Health:18 \t Money:20");
        System.out.println("3-God \t  \t Damage:8 \t Health:24 \t Money:30");

        int chaID;
        for(chaID = this.scan.nextInt(); chaID < 1 || chaID > 3; chaID = this.scan.nextInt()) {
            System.out.println("Please enter a valid character.");
        }

        return chaID;
    }

    public int getTotalDamage() {
        return this.getDamage() + this.getInv().getDamage();
    }

    public Player(String name) {
        this.scan = new Scanner(System.in);
        this.name = name;
        this.inv = new Inventory();
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getCharactername() {
        return this.charactername;
    }

    public void setCharactername(String charactername) {
        this.charactername = charactername;
    }

    public Inventory getInv() {
        return this.inv;
    }

    public int getRhealth() {
        return this.rhealth;
    }

    public void setRhealth(int rhealth) {
        this.rhealth = rhealth;
    }
}