package Game;

import Game.GameComponents.*;
import Game.GameComponents.Board.Board;
import Game.GameComponents.Board.BoardImpl;
import Game.GameComponents.Board.Ladder;
import Game.GameComponents.Board.Snake;

import java.util.Iterator;
import java.util.List;

public class Game {

    Board board;
    Iterator<Player> playerIterator;
    List<Player> players;
    Dice dice;

    int boardSize = 100;
    int diceSides = 6;

    public Game(Board board, List<Player> players, Dice dice) {
        this.board = board;
        this.players = players;
        this.dice = dice;
        boardSize = board.getSize();
        diceSides = dice.getSides();
    }

    public void addPlayer(String name){
        players.add(new Player(name));
    }

    public void addSnake(int start, int end){
        board.addSnake(start,end);
    }

    public void addLadder(int start, int end){
        board.addLadder(start,end);
    }

    public Chance play(){
        if(playerIterator == null || !playerIterator.hasNext())
            playerIterator = players.iterator();

        Player player = playerIterator.next();
        int diceValue = dice.roll();

        Chance chance = new Chance();
        chance.setCurrentPlayer(player);
        chance.setRolledValue(diceValue);
        chance.setInitialPosition(player.getPosition());

        int nextPosition = player.getPosition()+diceValue;
        while (true){
            if(nextPosition == boardSize){
                chance.setWonGame(true);
                break;
            } else if(nextPosition>boardSize){
                nextPosition = player.getPosition();
                break;
            } else if(board.getBoardCell(nextPosition) instanceof Ladder){
                Ladder ladder = (Ladder) board.getBoardCell(nextPosition);
                nextPosition = ladder.getEnd();
            } else if(board.getBoardCell(nextPosition) instanceof Snake){
                Snake snake = (Snake) board.getBoardCell(nextPosition);
                nextPosition = snake.getEnd();
            } else {
                break;
            }
        }

        player.setPosition(nextPosition);
        chance.setFinalPosition(nextPosition);
        return chance;
    }

}
