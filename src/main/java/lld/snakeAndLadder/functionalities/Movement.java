package lld.snakeAndLadder.functionalities;

import lld.snakeAndLadder.Constants;

import java.util.Map;

public class Movement implements Movable{
    private Map<Integer,Integer> snakeLadderMap;

    public Movement(){
        this.snakeLadderMap= Constants.snakeLadder;
    }

    @Override
    public int moveForward(int initialPos,int steps) {
        return initialPos+steps;
    }

    @Override
    public int changePosition(int initialPos) {
        int newPos=snakeLadderMap.get(initialPos);
        return newPos>0?newPos:-1;
    }
}
