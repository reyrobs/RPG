package sample;

import java.util.ArrayList;

public class Player {

    private String name;
    private Room room;
    private int health;
    boolean key = false;

    Player(String name, Room room, int health, boolean key) {
        this.name = name;
        this.room = room;
        this.health = health;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public Room getRoom() {
        return this.room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setKey(int i) {
        if(i==1) {
            key = false;
        }
        else if(i==0) {
            key = true;
        }
    }

    public void healhRemaining() {
        System.out.println("You now have " + this.health + " remaining");
    }

    public void dead() {
        System.out.println("Oh no you died. Better luck next time");
        System.exit(0);
    }
}
