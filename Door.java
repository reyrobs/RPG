package sample;

public class Door extends Inspectable implements Interactable {

    private Room roomBehind;

    public Door (String description, Room roomBehind) {
        super(description);
        this.roomBehind = roomBehind;
    }

    public Room getRoomBehind() {
        return roomBehind;
    }

    public void interact(Player player) {
        player.setRoom(roomBehind);
    }

    public void damage(int damage, Player player) {
        System.out.println("You lose " + damage + " health points as you go through this door from it's spikes");
        player.setHealth(player.getHealth() - damage);
        player.healhRemaining();
    }

}