import java.io.PrintStream;
import java.util.Scanner;

public abstract class BattleLoc extends Location {
    protected Obstacle obstacle;
    protected String award;
    Scanner scan;

    BattleLoc(Player player, String name, Obstacle obstacle, String award) {
        super(player);
        this.scan = new Scanner(System.in);
        this.obstacle = obstacle;
        this.name = name;
        this.award = award;
    }

    public boolean getLocation() {
        int obsCount = this.obstacle.count();
        System.out.println("You are here now : " + this.getName());
        System.out.println("Be careful ! " + obsCount + " " + this.obstacle.getName() + " live ");
        System.out.println("<W>ar or <E>scape");
        String selCase = this.scan.nextLine();
        selCase = selCase.toUpperCase();
        if (selCase.equals("W")) {
            if (this.combat(obsCount)) {
                System.out.println("You have defeated all the enemies in the " + this.getName() + " area");
                if (this.award.equals("Elixir") && !this.player.getInv().isElixir()) {
                    System.out.println("You won the " + this.award);
                    this.player.getInv().setElixir(true);
                } else if (this.award.equals("Water") && !this.player.getInv().isWater()) {
                    System.out.println("You won the " + this.award);
                    this.player.getInv().setWater(true);
                } else if (this.award.equals("Food") && !this.player.getInv().isFood()) {
                    System.out.println("You won the " + this.award);
                    this.player.getInv().setFood(true);
                }

                return true;
            }

            if (this.player.getHealth() <= 0) {
                System.out.println("You dead !");
                return false;
            }
        }

        return true;
    }

    public boolean combat(int obsCount) {
        for(int i = 0; i < obsCount; ++i) {
            int defObsHealth = this.obstacle.getHealth();
            this.playerStats();
            this.enemyStats();

            while(this.player.getHealth() > 0 && this.obstacle.getHealth() > 0) {
                System.out.print("<W>ar or <E>scape");
                String selCase = this.scan.nextLine();
                selCase = selCase.toUpperCase();
                if (!selCase.equals("W")) {
                    return false;
                }

                System.out.println("You attacked!");
                this.obstacle.setHealth(this.obstacle.getHealth() - this.player.getTotalDamage());
                this.afterHit();
                if (this.obstacle.getHealth() > 0) {
                    System.out.println();
                    System.out.println(this.obstacle.getName() + " attack you!");
                    this.player.setHealth(this.player.getHealth() - (this.obstacle.getDamage() - this.player.getInv().getArmor()));
                    this.afterHit();
                }
            }

            if (this.obstacle.getHealth() >= this.player.getHealth()) {
                return false;
            }

            System.out.println("You defeated " + this.obstacle.getName());
            this.player.setMoney(this.player.getMoney() + this.obstacle.getAward());
            System.out.println("Your current money " + this.player.getMoney());
            this.obstacle.setHealth(defObsHealth);
            System.out.println("----------------------");
        }

        return true;
    }

    public void playerStats() {
        System.out.println("Player Information\n-----------");
        System.out.println("Health : " + this.player.getHealth());
        System.out.println("Damage : " + this.player.getTotalDamage());
        System.out.println("Money : " + this.player.getMoney());
        if (this.player.getInv().getDamage() > 0) {
            System.out.println("Weapon : " + this.player.getInv().getwName());
        }

        if (this.player.getInv().getArmor() > 0) {
            System.out.println("Armor : " + this.player.getInv().getaName());
        }

    }

    public void enemyStats() {
        System.out.println(this.obstacle.getName() + " Information\n------");
        System.out.println("Health : " + this.obstacle.getHealth());
        System.out.println("Damage : " + this.obstacle.getDamage());
        System.out.println("Award : " + this.obstacle.getAward());
    }

    public void afterHit() {
        System.out.println("Player Health: " + this.player.getHealth());
        PrintStream var10000 = System.out;
        String var10001 = this.obstacle.getName();
        var10000.println(var10001 + " Health: " + this.obstacle.getHealth());
        System.out.println();
    }
}