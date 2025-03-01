package basics.lld.inMemoryDB;

import java.util.Objects;

public class Data {
    private String value;
    private long ttl;

    public Data(String value, long ttl) {
        this.value = value;
        this.ttl = ttl;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public long getTtl() {
        return ttl;
    }

    public void setTtl(long ttl) {
        this.ttl = ttl;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return ttl == data.ttl && Objects.equals(value, data.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, ttl);
    }
}
