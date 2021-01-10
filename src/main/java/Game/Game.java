package Game;

import Game.GameComponents.*;
import Game.GameComponents.Board.*;

import java.util.Iterator;
import java.util.List;

public class Game {

    Board board;
    PlayerSelector playerSelector;
    List<Player> players;
    Dice dice;

    int boardSize = 100;
    int diceSides = 6;

    public Game(Board board, List<Player> players, Dice dice, PlayerSelector playerSelector) {
        this.board = board;
        this.players = players;
        this.dice = dice;
        this.playerSelector = playerSelector;
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
        Player player = playerSelector.getNextPlayer();
        int diceValue = dice.roll();

        Chance chance = new Chance();
        chance.setCurrentPlayer(player);
        chance.setRolledValue(diceValue);
        chance.setInitialPosition(player.getPosition());

        int nextPosition = player.getPosition()+diceValue;
        while(true){
            if(nextPosition == boardSize){
                chance.setWonGame(true);
                break;
            } else if(nextPosition>boardSize){
                nextPosition = player.getPosition();
                break;
            } else {
                Cell cell = board.getBoardCell(nextPosition);
                if(cell == null)
                    break;
                nextPosition = cell.getDestinationCellIndex();
            }
        }

        player.setPosition(nextPosition);
        chance.setFinalPosition(nextPosition);
        return chance;
    }

}
