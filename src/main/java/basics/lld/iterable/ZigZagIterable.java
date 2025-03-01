package basics.lld.iterable;

import java.util.*;

public class ZigZagIterable implements Iterable<Integer> {

    private Queue<Iterator<Integer>> iteratorQueue = new LinkedList<>();

    public ZigZagIterable(List<Integer> firstList, List<Integer> secondList) {
        iteratorQueue.offer(firstList.iterator());
        iteratorQueue.offer(secondList.iterator());
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                return iteratorQueue.peek().hasNext();
            }

            @Override
            public Integer next() {
                Iterator<Integer> polledIterator = iteratorQueue.poll();
                Integer result = null;
                if(polledIterator.hasNext()){
                    result = polledIterator.next();
                    iteratorQueue.offer(polledIterator);
                }
                return result;
            }
        };
    }

    //    private Iterator<Integer> first, second, temp;
//
//    public ZigZagIterable(List<Integer> first, List<Integer> second) {
//        this.first = first.iterator();
//        this.second = second.iterator();
//    }
//
//    @Override
//    public Iterator<Integer> iterator() {
//
//        return new Iterator() {
//            @Override
//            public boolean hasNext() {
//                return first.hasNext() || second.hasNext();
//            }
//
//            @Override
//            public Integer next() {
//                Integer result = null;
//                if(first.hasNext()){
//                    result = first.next();
//                    temp = first;
//                    second = first;
//                    first = second;
//                }
//                else {
//                    result = second.next();
//                }
//                return result;
//            }
//        };
//    }
}
