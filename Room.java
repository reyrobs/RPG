package sample;

import java.util.ArrayList;
import java.util.List;

public class Room extends Inspectable {

    private List<Door> doors = new ArrayList<>();

    private NPC npc;

    public NPC getNpc() {
        return npc;
    }

    public List<Door> getDoors() {
        return doors;
    }

    public Room (String description, NPC npc) {
        super(description);
        this.npc = npc;
    }

    public void addDoor(Door door) {
        doors.add(door);
    }

    public void printDoor() {
        for(int i=0; i<doors.size(); i++) {
            System.out.print("(" + i + ") ");
            doors.get(i).inspect();
        }
    }
}
