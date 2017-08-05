package lld.snakeAndLadder;

import lld.snakeAndLadder.entities.Dice;
import lld.snakeAndLadder.entities.Player;
import lld.snakeAndLadder.functionalities.Movable;
import lld.snakeAndLadder.functionalities.Movement;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players;
    private Player winner;

    public Game(List<Player> players){
        this.players = players;
    }

    public void start(){
        int playerCount=players.size();
        int turn=1;
        while (winner == null) {
            Player player=players.get(turn%playerCount);
            player.move();
            if(player.hasWon()){
                winner=player;
            }
            turn++;
        }
    }
    public static void main(String[] args) {
        Dice dice = new Dice();
        Movable movable=new Movement();
        Player prem = new Player(dice,0,movable,"Prem");
        Player satish = new Player(dice,0,movable,"Satish");
        List<Player> players = new ArrayList<>();
        players.add(prem);
        players.add(satish);
        Game game= new Game(players);
        game.start();
        Player winner=game.getWinner();
        System.out.println(winner.getName());
    }

    public Player getWinner() {
        return winner;
    }
}

