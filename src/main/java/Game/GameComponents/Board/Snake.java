package Game.GameComponents.Board;

public class Snake extends BoardCell {
    int end;

    public Snake(int start, int end) {
        super(start);
        if(end>=start)
            throw new IllegalArgumentException("start is lesser or equal than end for a snake");
        this.end = end;
    }

    public int getEnd() {
        return end;
    }
}
