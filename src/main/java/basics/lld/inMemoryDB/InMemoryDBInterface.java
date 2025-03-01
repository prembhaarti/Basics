package basics.lld.inMemoryDB;

import java.util.List;
import java.util.Map;

public interface InMemoryDBInterface<K,V> {

    void setData(K key, V value);
    void setData(K key, V value, long ttl);
    V getData(K key);
    void delete(K key);
    List<K> filterByPrefix(String prefix);
    boolean isExpired(K key);
    Map<K, Data> backupData();
    void restore(Map<String, Data> data);
}
