package design.pattern.singleton;

public class EagerSingletonDemo {

    public static void main(String[] args) {
        EagerSingleton eagerSingleton = EagerSingleton.getInstance();
        eagerSingleton.show();

        LazySingleton lazySingleton = LazySingleton.getInstance();
        lazySingleton.show();

        EnumSingleton.INSTANCE.setName("Prem Bharti");
        System.out.println(EnumSingleton.INSTANCE.getName());

    }
}


class EagerSingleton {
    private static final EagerSingleton singleton = new EagerSingleton();
    private EagerSingleton(){}

    public static EagerSingleton getInstance(){
        return singleton;
    }

    public void show(){
        System.out.println("I am single object");
    }
}

class LazySingleton{
    private static volatile LazySingleton singleton;

    private LazySingleton(){}

    public static LazySingleton getInstance(){
        if (singleton == null) {
            synchronized (LazySingleton.class) {
                if (singleton == null) {
                    singleton = new LazySingleton();
                }
            }
        }
        return singleton;
    }

    public void show(){
        System.out.println("I am single object");
    }

}

enum EnumSingleton{
    INSTANCE;
    private EnumSingleton(){}

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


class LazyWithStaticClass {

    public static LazyWithStaticClass getInstance(){
        return Helper.lazyWithStaticClass;
    }

    static class Helper{
        private static final LazyWithStaticClass lazyWithStaticClass= new LazyWithStaticClass();
    }

    private LazyWithStaticClass(){}
}

