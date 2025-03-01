package basics.lld.inMemoryDB;

public class App {

    public static void main(String[] args) throws InterruptedException {
        InMemoryDBInterface inmemoryDB = new InMemoryDB();
        inmemoryDB.setData("A", "1", 1000);
        inmemoryDB.setData("B", "2", 1000);
        inmemoryDB.setData("C", "3", 1000);
        inmemoryDB.setData("D", "4", 1000);
        inmemoryDB.setData("AA", "27", 1000);
        inmemoryDB.setData("AB", "28", 1000);


        System.out.println("A:"+ inmemoryDB.getData("A"));
        System.out.println("B:"+ inmemoryDB.getData("B"));
        System.out.println("C:"+ inmemoryDB.getData("C"));
        System.out.println("D:"+ inmemoryDB.getData("D"));
        System.out.println("A Prefix:"+ inmemoryDB.filterByPrefix("A"));
        Thread.sleep(500);


        System.out.println("A:"+ inmemoryDB.getData("A"));
        System.out.println("B:"+ inmemoryDB.getData("B"));
        System.out.println("C:"+ inmemoryDB.getData("C"));
        System.out.println("D:"+ inmemoryDB.getData("D"));
        System.out.println("A Prefix:"+ inmemoryDB.filterByPrefix("A"));

        Thread.sleep(500);


        System.out.println("A:"+ inmemoryDB.getData("A"));
        System.out.println("B:"+ inmemoryDB.getData("B"));
        System.out.println("C:"+ inmemoryDB.getData("C"));
        System.out.println("D:"+ inmemoryDB.getData("D"));
        System.out.println("A Prefix:"+ inmemoryDB.filterByPrefix("A"));



    }
}
