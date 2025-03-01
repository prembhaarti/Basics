package basics.lld.iterable;

import java.util.Iterator;

public class IntervalIterable implements CustomIterable<Integer>{

    private final int start, end;

    public IntervalIterable(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int current = start;

            @Override
            public boolean hasNext() {
                return current <= end;
            }

            @Override
            public Integer next() {
                return current++;
            }
        };
    }
}
