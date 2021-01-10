package Game.GameComponents.Board;

public class Snake implements Cell {
    int end;

    public Snake(int start, int end) {
        if(end>=start)
            throw new IllegalArgumentException("start is lesser or equal than end for a snake");
        this.end = end;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public int getDestinationCellIndex() {
        return end;
    }
}
