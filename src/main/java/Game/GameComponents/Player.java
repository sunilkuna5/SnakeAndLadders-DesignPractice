package Game.GameComponents;

public class Player {
    private int position;
    private String name;

    public Player(String name) {
        this.name = name;
        position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
