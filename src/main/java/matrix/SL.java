package matrix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SL {

    public static Map<Integer, Integer> maps = new HashMap<>();
    public static int destination=30;
    public static int minDis=Integer.MAX_VALUE;
    public void SL(){
        maps.put(3, 22);
        maps.put(5, 8);
        maps.put(11, 26);
        maps.put(20, 29);
        maps.put(17, 4);
        maps.put(19, 7);
        maps.put(21, 9);
        maps.put(27, 1);
    }

    public void findShortest(int currentPos, Set<Integer> visited, int disCovered) {
        for(int i=1;i<7;i++) {
            int newPos=currentPos+i;
            if(newPos>30||visited.contains(currentPos)){
                return;
            }
            else if(newPos==30){
                minDis=Math.min(disCovered, minDis);
            }
            if (maps.containsKey(newPos)) {
                newPos = maps.get(newPos);
            }
            visited.add(currentPos);
            findShortest(newPos,visited,disCovered+1);
            if(visited.size()>1){
                visited.remove(visited.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        SL sl = new SL();
        sl.findShortest(1,new HashSet<Integer>(),0);
        System.out.println(minDis);
    }


}
