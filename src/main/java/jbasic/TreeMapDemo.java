package jbasic;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by lovebharti on 25/7/16.
 */
public class TreeMapDemo {

  public static void main(String[] args) {
    Map<Integer,Integer> map = new TreeMap<>();
    map.put(0, 3);
    map.put(-1,4);
    map.put(-2,5);
    map.put(1, 6);
    map.put(2, 7);

    Set<Integer> keys= map.keySet();
    for (int key : keys) {
      System.out.println(map.get(key));
    }
  }
}