package basics.lld.iterable;

import java.util.Iterator;

public class OddNumberIterable implements CustomIterable<Integer> {
    private final int start, end;

    public OddNumberIterable(final int start, final int end) {
        this.start = (start % 2 == 0) ? start + 1 : start; // Ensure start is odd
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
                int value = current;
                current += 2; // Jump to next odd number
                return value;
            }
        };
    }

}