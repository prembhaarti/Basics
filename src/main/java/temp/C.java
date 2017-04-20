package temp;

/**
 * Created by prembharti on 5/4/17.
 */
public class C {
    public static void main(String[] args) {
        B b= new B();
       // A a = new A();
    }

}

class A{
    A(){
        System.out.println("A");
    }
    static {
        System.out.println("B");
    }
    {
        System.out.println("C");
    }
}

class B extends A{
    B(){
        System.out.println("D");
    }
    static {
        System.out.println("E");
    }
    {
        System.out.println("F");
    }
}
