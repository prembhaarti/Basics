package basics.lld.iterable;

import java.util.Iterator;

public interface CustomIterable<T> extends Iterable<T> {

    Iterator<T> iterator();

}
