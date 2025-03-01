package basics.lld.inMemoryDB;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryDB implements InMemoryDBInterface<String, String> {

    private Map<String, Data> db = new ConcurrentHashMap<>();
    private long defaultTTL= 604800;

    @Override
    public void setData(String key, String value) {
        setData(key, value, defaultTTL);
    }

    @Override
    public void setData(String key, String value, long ttl) {
        if(ttl < 0) return;
        Data data = new Data(value, System.currentTimeMillis()+ttl);
        db.put(key, data);
    }

    @Override
    public String getData(String key) {
        return db.containsKey(key) && !isExpired(key) ? db.get(key).getValue(): null;
    }

    @Override
    public void delete(String key) {
        db.remove(key);
    }

    @Override
    public List<String> filterByPrefix(String prefix) {

        List<String> result = new ArrayList<>();
        for (String key : db.keySet()) {
            if (key.startsWith(prefix) && !isExpired(key)) {
                result.add(db.get(key).getValue());
            }
        }
        return result;
    }

    @Override
    public boolean isExpired(String key) {
        return db.containsKey(key) && db.get(key).getTtl() < System.currentTimeMillis();
    }

    @Override
    public Map<String, Data> backupData() {
        return db;
    }

    @Override
    public void restore(Map<String, Data> data) {
        db.clear();
        db.putAll(data);
    }
}
