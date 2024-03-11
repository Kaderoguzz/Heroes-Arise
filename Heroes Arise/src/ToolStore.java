public class ToolStore extends NormalLoc {
    ToolStore(Player player) {
        super(player, "Store");
    }

    public boolean getLocation() {
        System.out.println("Money : " + this.player.getMoney() + "\n");
        System.out.println("1-Weapons");
        System.out.println("2-Armors");
        System.out.println("3-Exit");
        System.out.println("Your choice :");
        int selTool = this.scan.nextInt();
        int selItemID;
        switch (selTool) {
            case 1:
                selItemID = this.weaponMenu();
                this.buyWeapon(selItemID);
                break;
            case 2:
                selItemID = this.armorMenu();
                this.buyArmor(selItemID);
        }

        return true;
    }

    public int armorMenu() {
        System.out.println("1- Light\t \t Price: 15   Damage: 1");
        System.out.println("2- Average \t \t Price: 25   Damage: 3");
        System.out.println("3- Heavy\t \t Price: 40   Damage: 5");
        System.out.println("4- Exit");
        System.out.print("Chose an armor : ");
        return this.scan.nextInt();
    }

    public void buyArmor(int itemID) {
        int avoid = 0;
        int price = 0;
        String aName = null;
        switch (itemID) {
            case 1:
                avoid = 2;
                aName = "Light Armor";
                price = 15;
                break;
            case 2:
                avoid = 3;
                aName = "Average Armor";
                price = 25;
                break;
            case 3:
                avoid = 5;
                aName = "Heavy Armor";
                price = 40;
                break;
            case 4:
                System.out.println("Logging out...");
                break;
            default:
                System.out.println("Invalid Transaction!");
        }

        if (price > 0) {
            if (this.player.getMoney() >= price) {
                this.player.getInv().setArmor(avoid);
                this.player.getInv().setaName(aName);
                this.player.setMoney(this.player.getMoney() - price);
                System.out.println(aName + "The purchase has been completedPrevious damage: " + this.player.getDamage() + "New damage : " + this.player.getTotalDamage());
                System.out.println("Remaining balance:" + this.player.getMoney());
            } else {
                System.out.println("Insufficient balance!");
            }
        }

    }

    public int weaponMenu() {
        System.out.println("1- Sword\t Price: 20 Damage: 3");
        System.out.println("2- Wand\t \t Price: 31 Damage: 5");
        System.out.println("3- Hammer\t Price: 45 Damage: 7");
        System.out.println("4- Exit");
        System.out.print("Chose a weapon : ");
        return this.scan.nextInt();
    }

    public void buyWeapon(int itemID) {
        int damage = 0;
        int price = 0;
        String wName = null;
        switch (itemID) {
            case 1:
                damage = 3;
                wName = "Sword";
                price = 20;
                break;
            case 2:
                damage = 5;
                wName = "Wand";
                price = 31;
                break;
            case 3:
                damage = 7;
                wName = "Hammer";
                price = 45;
                break;
            case 4:
                System.out.println("Logging out...");
                break;
            default:
                System.out.println("Invalid Transaction!");
        }

        if (price > 0) {
            if (this.player.getMoney() >= price) {
                this.player.getInv().setDamage(damage);
                this.player.getInv().setwName(wName);
                this.player.setMoney(this.player.getMoney() - price);
                System.out.println(wName + "The purchase has been completedPrevious damage: " + this.player.getDamage() + "New damage : " + this.player.getTotalDamage());
                System.out.println("Remaining balance :" + this.player.getMoney());
            } else {
                System.out.println("Insufficient balance!");
            }
        }

    }
}
