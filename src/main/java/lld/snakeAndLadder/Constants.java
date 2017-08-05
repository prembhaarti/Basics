package lld.snakeAndLadder;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static final int winningPos=100;
    public static Map<Integer,Integer> snakeLadder;


    static{
        snakeLadder = new HashMap<>();
        snakeLadder.put(2, 40);
        snakeLadder.put(30, 60);
        snakeLadder.put(70, 92);
        snakeLadder.put(80, 2);
        snakeLadder.put(32, 10);
        snakeLadder.put(99, 31);
    }

}
