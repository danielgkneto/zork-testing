import java.util.HashMap;

public class Room {
    private int id;
    private String name;
    private String description;
    private boolean isVisited;
    private Container container;
    private boolean thief;
    private HashMap<Border, Integer> borders;

    public Room(int id, String name, String description, boolean isVisited, Container container, boolean thief, HashMap<Border, Integer> borders) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isVisited = isVisited;
        this.container = container;
        this.thief = thief;
        this.borders = borders;
    }

    public Room(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Room() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public boolean isThief() {
        return thief;
    }

    public void setThief(boolean thief) {
        this.thief = thief;
    }

    public HashMap<Border, Integer> getBorders() {
        return borders;
    }

    public void setBorders(HashMap<Border, Integer> borders) {
        this.borders = borders;
    }
}

/*
public class Room {
    private int id;
    private String name;
    private String message;
    private int northtId;
    private int southId;
    private int eastId;
    private int westId;

    public Room(int id, String name, String message, int northtId, int southId, int eastId, int westId) {
        this.id = id;
        this.name = name;
        this.message = message;
        this.northtId = northtId;
        this.southId = southId;
        this.eastId = eastId;
        this.westId = westId;
    }

    public Room() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getNorthtId() {
        return northtId;
    }

    public void setNorthtId(int northtId) {
        this.northtId = northtId;
    }

    public int getSouthId() {
        return southId;
    }

    public void setSouthId(int southId) {
        this.southId = southId;
    }

    public int getEastId() {
        return eastId;
    }

    public void setEastId(int eastId) {
        this.eastId = eastId;
    }

    public int getWestId() {
        return westId;
    }

    public void setWestId(int westId) {
        this.westId = westId;
    }
}*/
