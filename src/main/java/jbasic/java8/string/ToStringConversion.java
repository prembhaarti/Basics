package jbasic.java8.string;

import java.util.Arrays;
import java.util.List;

public class ToStringConversion {

    public static List<String> names= Arrays.asList("Prem","Kumar","Bharti");

    public static String getListToString(String joiner){
        return String.join(joiner,names);
    }

    public static void main(String[] args) {
        System.out.println(getListToString(","));
        System.out.println(String.format("Exception in %s %s %s",1,2,3));
    }

}
