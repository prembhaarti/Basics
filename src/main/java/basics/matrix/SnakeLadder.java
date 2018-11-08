package basics.matrix;

import java.util.HashMap;
import java.util.Map;

public class SnakeLadder {

    static Map<Integer,Integer> ladders=new HashMap<>();
    static Map<Integer,Integer> snakes= new HashMap<>();
    static {
        ladders.put(11, 26);
        ladders.put(3, 22);
        ladders.put(5, 8);
        ladders.put(20, 29);
        snakes.put(27, 1);
        snakes.put(21,9);
    }


    public static int getShortestTurn(int start,int pos,int blocks,int turn){
        while(pos<=blocks){
            if(pos==blocks){
                turn+=getTurn(start,pos);
                System.out.println(start+","+pos);
            }
            if(ladders.containsKey(pos)){
                turn+=getTurn(start,pos);
                turn+=getShortestTurn(ladders.get(pos),ladders.get(pos),blocks,turn);
                System.out.println(start+","+pos);
            }
            if(snakes.containsKey(pos)){
                turn+=getTurn(start,pos);
                turn+=getShortestTurn(snakes.get(pos),snakes.get(pos),blocks,turn);
                System.out.println(start+","+pos);
            }
            pos++;
        }
        return turn;
    }

    public static int getTurn(int start,int pos){
        return (int)Math.ceil((pos-start)/6);
    }


    public static void main(String[] args) {
        System.out.println(getShortestTurn(0,0,30,0));
    }
}
