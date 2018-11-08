package jbasic.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionDemo {

    static Function<String,String> getName = name -> name+" ";
    static Function<String,String> addSalute = name -> "Mr. "+name;
    static Function<String, String> addSirName= name -> name+ " Bharti";

    public static void main(String[] args) {
        System.out.println(getName.compose(addSalute).andThen(addSirName).apply("Prem"));

        List<String> list = new ArrayList<>();

    }


}