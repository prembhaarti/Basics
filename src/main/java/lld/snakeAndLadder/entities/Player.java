package lld.snakeAndLadder.entities;

import lld.snakeAndLadder.Constants;
import lld.snakeAndLadder.functionalities.Movable;

public class Player {

    private String name;
    private int position;
    private Dice dice;
    private Movable movement;

    public void move() {
        int newPosition=this.position+dice.roll();
        if(hasValidPosition(newPosition)){
            if(Constants.snakeLadder.get(newPosition)!=null){
                position=Constants.snakeLadder.get(newPosition);
            }
            else{
                position=newPosition;
            }
        }
    }

    public Player(Dice dice,int initialPos,Movable movement,String name){
        this.position=initialPos;
        this.dice=dice;
        this.movement=movement;
        this.name=name;
    }

    public boolean hasWon(){
        return this.position==Constants.winningPos;
    }

    private boolean hasValidPosition(int position){
        return position<=100 && position>=0;
    }

    //getters setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public Movable getMovement() {
        return movement;
    }

    public void setMovement(Movable movement) {
        this.movement = movement;
    }
}