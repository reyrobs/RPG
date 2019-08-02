package sample;
import java.util.Scanner;

public class NPC extends Inspectable implements Interactable {

    boolean friendly;
    private int healthPoints;
    private int damage;
    Scanner scanner = new Scanner(System.in);
    int i;

    public NPC(String description, boolean friendly, int healthPoints, int damage) {
        super(description);
        this.friendly = friendly;
        this.healthPoints = healthPoints;
        this.damage = damage;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getDamage() {
        return damage;
    }

    public void interact(Player player) {

    }

    public void fight(Player player, NPC npc) {
        if (npc.friendly) {
            System.out.println("This NPC is friendly, so no need to fight");
        } else {
            System.out.println("Get ready for battle! You have " + player.getHealth() + " health points remaining");
            while (npc.getHealthPoints() > 0 && player.getHealth() > 0) {
                System.out.println("Press (1) to attack");
                i = scanner.nextInt();
                System.out.println("The monster has " + (npc.getHealthPoints() - 20) + "health points left");
                System.out.println("The monster now hits you and you lose " + npc.getDamage() + " health points");
                player.setHealth(player.getHealth() - npc.getDamage());
                npc.setHealthPoints(npc.getHealthPoints() - 20);
                player.healhRemaining();
            }
            if (player.getHealth() <= 0) {
                player.dead();
            } else {
                System.out.println("Well done you defeated the monster!");
            }
        }
    }
}
