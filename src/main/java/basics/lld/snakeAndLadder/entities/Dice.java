package basics.lld.snakeAndLadder.entities;

public class Dice {
    public int roll(){
        return (int)(Math.random()*6+1);
    }
}