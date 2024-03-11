import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    Scanner scan;

    public Game() {
        this.scan = new Scanner(System.in);
    }

    public void login() {
        System.out.println("--------------HEROES ARİSE-----------------\n");
        System.out.print("Enter your name before the game starts: ");
        String playerName = this.scan.nextLine();
        this.player = new Player(playerName);
        this.player.selectCha();
        this.start();
    }

    public void start() {
        while(true) {
            System.out.println();
            System.out.println();
            System.out.println("Select where you want to take action:\n");
            System.out.println("1-Home ----------->hint: Your own safe space,No Enemies!");
            System.out.println("2-Laboratory ----->hint: Your may encounter a Crazy Scientist");
            System.out.println("3-Dusty Castle --->hint: Your may encounter a Dracula");
            System.out.println("4-Mars ----------->hint: Your may encounter an Alien");
            System.out.println("5-Store ---------->hint: Where you can buy weapons and armor");
            int selLog = this.scan.nextInt();
            System.out.println();

            while(selLog < 0 || selLog > 5) {
                System.out.println("Select a valid location: ");
                selLog = this.scan.nextInt();
            }

            switch (selLog) {
                case 2:
                    this.location = new Laboratory(this.player);
                    break;
                case 3:
                    this.location = new DustyCastle(this.player);
                    break;
                case 4:
                    this.location = new Mars(this.player);
                    break;
                case 5:
                    this.location = new ToolStore(this.player);
                    break;
                default:
                    this.location = new Home(this.player);
            }

            if (this.location.getClass().getName().equals("Home") && this.player.getInv().isFood() && this.player.getInv().isElixir() && this.player.getInv().isWater()) {
                System.out.println("Congratulations you win");
            } else {
                if (this.location.getLocation()) {
                    continue;
                }

                System.out.println("Game Over!");
            }

            return;
        }
    }
}