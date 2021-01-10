package Game.GameComponents.Board;

public interface Board {
    void addLadder(int start, int end);

    void addSnake(int start, int end);

    Cell getBoardCell(int nextPosition);

    int getSize();
}
