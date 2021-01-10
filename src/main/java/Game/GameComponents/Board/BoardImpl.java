package Game.GameComponents.Board;

public class BoardImpl implements Board {
    private Cell[] cells;

    public BoardImpl(int boardSize){
        cells = new Cell[boardSize+1];
    }

    @Override
    public void addLadder(int start, int end){
        validateCell(start, end);
        Ladder ladder = new Ladder(start,end);
        cells[start] = ladder;
    }

    @Override
    public void addSnake(int start, int end){
        validateCell(start, end);
        Snake snake = new Snake(start,end);
        cells[start] = snake;
    }

    private void validateCell(int start, int end) {
        if(start<0 || end<0 || start>= cells.length || end>= cells.length)
            throw new IllegalArgumentException("Indices are out the bounds of Game.GameComponents.Board.Board");

        if(cells[start] == null)
            return;

        if(cells[start] instanceof Ladder){
            throw new IllegalArgumentException("Game.GameComponents.Board.Ladder already present at the cell");
        }
        if(cells[start] instanceof Snake){
            throw new IllegalArgumentException("Game.GameComponents.Board.Snake already present at the cell");
        }
    }

    @Override
    public Cell getBoardCell(int nextPosition) {
        return cells[nextPosition];
    }

    @Override
    public int getSize() {
        return cells.length-1;
    }
}
