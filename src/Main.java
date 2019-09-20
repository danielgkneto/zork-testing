import java.util.*;

public class Main {
    public static Scanner kb = new Scanner(System.in);
    public static String answer;
    public static Map<Integer, Room> rooms = new HashMap();
    public static boolean isGameOver = false;
    public static Room currentRoom;

    public static void main(String[] args) {

        rooms.put(1, new Room(1, "foyer", "You see a dead scorpion."));
        rooms.put(2, new Room(2, "front room", "You see a piano."));
        rooms.put(3, new Room(3, "library", "You see spiders."));
        rooms.put(4, new Room(4, "kitchen", "You see bats."));
        rooms.put(5, new Room(5, "dinning room", "You see an empty box and the exit from the castle."));
        rooms.put(6, new Room(6, "vault", "You see 3 walking skeletons."));
        rooms.put(7, new Room(7, "parlor", "You see a treasure chest."));
        rooms.put(8, new Room(8, "secret room", "You found a pile of gold! Congratulations!."));
        rooms.put(9, new Room(9, "exit", "You found the exit."));

        for (int i = 1; i <= rooms.size(); i++){
            HashMap<Border, Integer> borders = new HashMap<>();
            switch (rooms.get(i).getName()){
                case "foyer": {
                    borders.put(Border.NORTH, 2);
                    rooms.get(i).setBorders(borders);
                    break;
                }
                case "front room": {
                    borders.put(Border.SOUTH, 1);
                    borders.put(Border.WEST, 3);
                    borders.put(Border.EAST, 4);
                    rooms.get(i).setBorders(borders);
                    break;
                }
                case "library": {
                    borders.put(Border.NORTH, 5);
                    borders.put(Border.EAST, 2);
                    rooms.get(i).setBorders(borders);
                    break;
                }
                case "kitchen": {
                    borders.put(Border.NORTH, 7);
                    borders.put(Border.WEST, 2);
                    rooms.get(i).setBorders(borders);
                    break;
                }
                case "dinning room": {
                    borders.put(Border.SOUTH, 3);
                    borders.put(Border.EAST, 9);
                    rooms.get(i).setBorders(borders);
                    break;
                }
                case "vault": {
                    //25% chance for secret room to appear
                    int secretRoomId = (new Random().nextInt(4) == 0) ? 1 : 0;
                    secretRoomId += 7;
                    borders.put(Border.EAST, secretRoomId);
                    rooms.get(i).setBorders(borders);
                    break;
                }
                case "parlor": {
                    borders.put(Border.WEST, 6);
                    borders.put(Border.SOUTH, 4);
                    rooms.get(i).setBorders(borders);
                    break;
                }
                case "secret room": {
                    borders.put(Border.WEST, 6);
                    rooms.get(i).setBorders(borders);
                    break;
                }
                default: break;
            }
        }

        //25% chance to be followed by a ghost
        rooms.get(9).setDescription((new Random().nextInt(4) == 0) ? "You found the exit, but you were followed by a ghost": "You found the exit");

        currentRoom = rooms.get(1);
        System.out.println("\nWELCOME TO DANIEL'S CASTLE!\n");

        while (!isGameOver) currentRoom = checkAnswer(currentRoom);

        System.out.println("\nGAME OVER\n\nThanks for playing!\n");
    }

    private static Room checkAnswer(Room currentRoom){
        boolean isValidAnswer = false;
        int nextRoomId = currentRoom.getId();
        String options = " Which direction do you want to go? ( ";

        if (currentRoom.getId() == 9){
            isGameOver = true;
            System.out.println(currentRoom.getDescription());
            return null;
        }

        if (currentRoom.getBorders().containsKey(Border.NORTH)) {
            options = options.concat("north ");
        }
        if (currentRoom.getBorders().containsKey(Border.SOUTH)) {
            options = options.concat("south ");
        }
        if (currentRoom.getBorders().containsKey(Border.EAST)) {
            options = options.concat("east ");
        }
        if (currentRoom.getBorders().containsKey(Border.WEST)) {
            options = options.concat("west ");
        }
        options = options.concat(")");

        System.out.println("You are in the " + currentRoom.getName() + ". " + currentRoom.getDescription() + options);

        while (!isValidAnswer){
            answer = kb.nextLine();

            if (options.contains(answer)) {
                isValidAnswer = true;
                switch (answer) {
                    case "north" : {
                        nextRoomId = currentRoom.getBorders().get(Border.NORTH);
                        break;
                    }
                    case "south" : {
                        nextRoomId = currentRoom.getBorders().get(Border.SOUTH);
                        break;
                    }
                    case "east" : {
                        nextRoomId = currentRoom.getBorders().get(Border.EAST);
                        break;
                    }
                    case "west" : {
                        nextRoomId = currentRoom.getBorders().get(Border.WEST);
                        break;
                    }
                    default: break;
                }
                return rooms.get(nextRoomId);
            }
        }
        return currentRoom;
    }
}