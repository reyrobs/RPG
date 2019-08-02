package sample;

import sample.Room;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /**
         * Creation of NPCs
         */

        NPC cat = new NPC("A little cat is sleeping in the corner of the room", true, 100, 0);
        NPC vampire = new NPC("A scary looking vampire shows up", false, 100, 10);
        NPC witch = new NPC("A deadly witch throws a spell at you", false,  100, 20);
        NPC sphynx = new NPC("A sphynx rewards you with a beer for escaping the haunted house", false,  100, 0);
        NPC ghost = new NPC ("", true, 100, 0);

        /**
         * Creation of Rooms and Doors
         */

        Room initialRoom = new Room("You see a white room with a red door and a black door", cat);
        Room ghostRoom = new Room("You're now in the Ghost Room, a friendly ghost may appear with a key", ghost);
        Room vampireRoom = new Room("The scary vampire comes up to you", vampire);

        Room witchRoom = new Room("Loud screaming witches throw a spell at you and make you lose health" +
                "points", witch);
        Room exitRoom = new Room("You've made it out, give yourself a pat on the back and have a beer", sphynx);

       // Door redDoor = new Door("A red door", initialRoom);
        Door blackDoor = new Door("A black door", ghostRoom);
        Door dustyDoor = new Door("A dirty and dusty door", vampireRoom);
        Door bloodedDoor = new Door("A blooded door", witchRoom);
        Door exitDoor = new Door("A door that seems locked", exitRoom);

        /**
         * Adding the doors to the corresponding rooms
         */
        // initialRoom.addDoor(redDoor);
        initialRoom.addDoor((blackDoor));

        ghostRoom.addDoor(dustyDoor);
        ghostRoom.addDoor(bloodedDoor);

        vampireRoom.addDoor(dustyDoor);

        witchRoom.addDoor(bloodedDoor);
        witchRoom.addDoor(exitDoor);

        exitRoom.addDoor(exitDoor);


        /**
         * Start of the game
         */

        System.out.println("Hello there soldier, it seems you've awoken in a gloomy room, what is your name?");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Alright " + username + ", let's look for a way out!\nUse the keyboard numbers to navigate and explore. Good luck!\n");
        //int i = scanner.nextInt();

        Player playerOne = new Player(username, initialRoom, 100, false);
        Room currentRoom = initialRoom;
        Door currentDoor;


        while (true) {
            printOptions();
            int i = scanner.nextInt();

            switch (i) {

                case 0:
                    System.out.println("You look around.");
                    currentRoom.inspect();
                    break;

                case 1:
                    System.out.println("Which door do you take? (-1 : stay here)");
                    currentRoom.printDoor();
                    i = scanner.nextInt();

                    currentDoor = currentRoom.getDoors().get(i);
                    currentDoor.interact(playerOne);
                    currentRoom = playerOne.getRoom();
                    System.out.println(currentRoom.getNpc().getDescription() + "\n" + currentRoom.getDescription());
                    currentRoom.getNpc().fight(playerOne, currentRoom.getNpc());

                    if (currentRoom == ghostRoom && !playerOne.key) {
                        System.out.println("Oh snap " + playerOne.getName()+ ", Brownie the ghost appears, but it looks friendly, he hands you a key that looks like it could be helpful for later on");
                        System.out.println("(0) Take his key");
                        System.out.println("(1) Send his ass back to Ghost City");
                        i = scanner.nextInt();
                        playerOne.setKey(i);
                    }

                case 2:

                    break;
                }
            }
        }

    private static void printOptions() {
        System.out.println("What do you want to do?");
        System.out.println("(0) Look Around");
        System.out.println("(1) Look for a way out");
        System.out.println("(2) Look for company");
    }
}
