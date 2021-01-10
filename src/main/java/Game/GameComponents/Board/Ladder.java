package Game.GameComponents.Board;

public class Ladder implements Cell {
    int end;

    public Ladder(int start, int end) {
        if(end<=start)
            throw new IllegalArgumentException("start is greater or equal than end for a Game.GameComponents.Board.Ladder");
        this.end = end;
    }

    @Override
    public int getDestinationCellIndex() {
        return end;
    }
}