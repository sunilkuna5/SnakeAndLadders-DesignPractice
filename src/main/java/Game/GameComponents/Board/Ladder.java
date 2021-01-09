package Game.GameComponents.Board;

public class Ladder extends BoardCell {
    int end;

    public Ladder(int start, int end) {
        super(start);
        if(end<=start)
            throw new IllegalArgumentException("start is greater or equal than end for a Game.GameComponents.Board.Ladder");
        this.end = end;
    }

    public int getEnd() {
        return end;
    }
}