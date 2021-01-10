import Game.Game;
import Game.GameComponents.Board.Board;
import Game.GameComponents.Board.BoardImpl;
import Game.Chance;
import Game.GameComponents.Dice;
import Game.GameComponents.DiceImpl;
import Game.GameComponents.Player;

import java.util.ArrayList;
import java.util.List;

public class CommandLineAdapter {

    Board board = new BoardImpl(100);
    Dice dice = new DiceImpl(6);
    List<Player> players = new ArrayList<>();
    Game game = new Game(board,players,dice);
    String format = "%s rolled a %d and moved from %d to %d";

    public void addSnake(String snake){
        String[] values = snake.split(" ");
        int start = Integer.parseInt(values[0]);
        int end = Integer.parseInt(values[1]);
        game.addSnake(start,end);
    }

    public void addLadder(String ladder){
        String[] values = ladder.split(" ");
        int start = Integer.parseInt(values[0]);
        int end = Integer.parseInt(values[1]);
        game.addLadder(start,end);
    }

    public void addPlayer(String player){
        game.addPlayer(player);
    }

    public void play(){
        while(true){
            Chance chance = game.play();
            System.out.println(String.format(format,
                    chance.getCurrentPlayer().getName(),
                    chance.getRolledValue(),
                    chance.getInitialPosition(),
                    chance.getFinalPosition()));
            if(chance.isWonGame()) {
                System.out.println(chance.getCurrentPlayer().getName() +" wins the game");
                break;
            }
        }
    }
}
