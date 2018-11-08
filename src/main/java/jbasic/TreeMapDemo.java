package jbasic;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by lovebharti on 25/7/16.
 */
public class TreeMapDemo {

  public static void main(String[] args) {
    HashMap<Integer,Integer> map = new HashMap<>();
    map.put(0, 3);
    map.put(-1,4);
    map.put(-2,5);
    map.put(1, 6);
    map.put(2, 7);

    Set<Integer> keys= map.keySet();
    Set<Integer> key1= map.keySet();
    Set<Integer> key2= map.keySet();
    Set<Integer> key3= map.keySet();
    Set<Integer> key4= map.keySet();
    Set<Integer> key5= map.keySet();
    Set<Integer> key6= map.keySet();
    Set<Integer> key7= map.keySet();
    Set<Integer> key8= map.keySet();
    Set<Integer> key9= map.keySet();
    Set<Integer> key10= map.keySet();

    System.out.println(keys);
    System.out.println(key1);
    System.out.println(key2);
    System.out.println(key3);
    System.out.println(key4);
    System.out.println(key5);
    System.out.println(key6);
    System.out.println(key7);
    System.out.println(key8);
    System.out.println(key9);
    System.out.println(key10);

    System.out.println(keys);

    for (int key : keys) {
      System.out.println(map.get(key));
    }
  }
}
