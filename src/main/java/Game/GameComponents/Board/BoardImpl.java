package Game.GameComponents.Board;

public class BoardImpl implements Board {
    private BoardCell[] boardCells;

    public BoardImpl(int boardSize){
        boardCells = new BoardCell[boardSize+1];
        for(int i=0;i<boardCells.length;i++)
            boardCells[i] = new BoardCell(i);
    }

    @Override
    public void addLadder(int start, int end){
        validateCell(start, start);
        Ladder ladder = new Ladder(start,end);
        boardCells[start] = ladder;
    }

    @Override
    public void addSnake(int start, int end){
        validateCell(start, end);
        Snake snake = new Snake(start,end);
        boardCells[start] = snake;
    }

    private void validateCell(int start, int end) {
        if(start>=boardCells.length || end>= boardCells.length)
            throw new IllegalArgumentException("Indices are out the bounds of Game.GameComponents.Board.Board");

        if(boardCells[start] instanceof Ladder){
            throw new IllegalArgumentException("Game.GameComponents.Board.Ladder already present at the cell");
        }
        if(boardCells[start] instanceof Snake){
            throw new IllegalArgumentException("Game.GameComponents.Board.Snake already present at the cell");
        }
    }

    @Override
    public BoardCell getBoardCell(int nextPosition) {
        return boardCells[nextPosition];
    }

    @Override
    public int getSize() {
        return boardCells.length-1;
    }
}
