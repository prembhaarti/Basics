package basics.lld.cabManagement.manager;

import basics.lld.cabManagement.entities.Cab;

public interface StateManager {

    public boolean changeCabState(Cab cab, String state);


}
