package basics.lld.iterable;

import java.util.Iterator;
import java.util.List;

public class ListIterable<T> implements CustomIterable<T> {
    private final List<T> list;

    public ListIterable(List<T> list) {
        this.list = list;
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }


}