package stack;

import java.util.*;

public class VendorMinPrice {


    public static void main(String[] args) {
        List<Vendor> vendors= getVendors();
        Collections.sort(vendors,new VendorComparator());
        Stack<Vendor> stack = new Stack<>();
        stack.push(vendors.get(0));

        for(int i=1;i<vendors.size();i++) {
            Vendor current=vendors.get(i);
            Vendor popped= stack.pop();
            if (isOverlap(popped, current)) {
                int min = Math.min(current.price, popped.price);
                int common=popped.end-current.start;
                Vendor first= new Vendor(popped.start,common,min);
                Vendor second = new Vendor(common+1, popped.end, min);
                Vendor third = new Vendor(popped.end, current.end, current.price);
                stack.push(first);
                stack.push(second);
                stack.push(third);
            }
        }
        System.out.println(stack.toString());
    }

    public static boolean isOverlap(Vendor vendor1, Vendor vendor2) {
        return vendor1.end>vendor2.start;
    }

    public static List<Vendor> getVendors() {
        List<Vendor> vendors= new ArrayList<>();
        vendors.add(new Vendor(1, 5, 20));
        vendors.add(new Vendor(3, 8, 15));
        vendors.add(new Vendor(7, 10, 8));
        return vendors;
    }
}
class Vendor{
    public int start;
    public int end;
    public int price;

    public Vendor(int start, int end, int price) {
        this.start = start;
        this.end = end;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "start=" + start +
                ", end=" + end +
                ", price=" + price +
                '}';
    }
}

class VendorComparator implements Comparator<Vendor> {
    @Override
    public int compare(Vendor v1, Vendor v2) {
        return v1.end-v1.start;
    }
}
