package basics.lld.lift;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LiftDAO {
    private final Map<Integer, Lift> liftMap = new HashMap<>();

    public void save(Lift lift) {
        liftMap.put(lift.getId(), lift);
    }

    public Lift getById(int id) {
        return liftMap.get(id);
    }

    public List<Lift> getAll() {
        return new ArrayList<>(liftMap.values());
    }
}
